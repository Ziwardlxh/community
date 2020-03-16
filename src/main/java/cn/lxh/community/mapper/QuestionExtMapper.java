package cn.lxh.community.mapper;

import cn.lxh.community.dto.QuestionQueryDTO;
import cn.lxh.community.model.Question;

import java.util.List;

public interface QuestionExtMapper {

    int incView(Question record);

    int incCommentCount(Question record);

    List<Question> selectRelated(Question question);

    List<Question> selectHot();

    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}