package cn.lxh.community.mapper;

import cn.lxh.community.model.Question;

public interface QuestionExtMapper {

    int incView(Question record);

    int incCommentCount(Question record);

}