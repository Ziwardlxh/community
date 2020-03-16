package cn.lxh.community.controller;

import cn.lxh.community.dto.CommentDTO;
import cn.lxh.community.dto.QuestionDTO;
import cn.lxh.community.enums.CommentTypeEnum;
import cn.lxh.community.exception.CustomizeErrorCode;
import cn.lxh.community.exception.CustomizeException;
import cn.lxh.community.mapper.QuestionMapper;
import cn.lxh.community.model.Question;
import cn.lxh.community.model.QuestionExample;
import cn.lxh.community.service.CommentService;
import cn.lxh.community.service.QuestionService;
import cn.lxh.community.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") String id, Model model) {
        Long questionId;
        try {
            questionId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        }
        QuestionDTO questionDTO = questionService.getById(questionId);
        List<QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);
        List<CommentDTO> comments = commentService.listByTargetId(questionId, CommentTypeEnum.QUESTION);

        questionService.incView(questionId);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);
        model.addAttribute("relatedQuestions", relatedQuestions);
        return "question";
    }

    @ResponseBody
    @RequestMapping(value = "/hello/{id}")
    public String hello(@PathVariable(value = "id") String id) {
        String str = "";
        Long questionId = Long.parseLong(id);
        if (redisUtil.get(id) == null) {
            System.out.println("从数据库获取");
            QuestionExample questionExample = new QuestionExample();
            questionExample.createCriteria().andIdEqualTo(questionId);
            List<Question> questions = questionMapper.selectByExample(questionExample);
            str = questions.get(0).getTitle();
            redisUtil.set(id, str, 10l, TimeUnit.MINUTES);
        } else {
            System.out.println("从redis中获取");
            Object object = redisUtil.get(id);
            str = object.toString();
        }
        return str;
    }
}
