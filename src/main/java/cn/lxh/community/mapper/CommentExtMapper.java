package cn.lxh.community.mapper;

import cn.lxh.community.model.Comment;
import cn.lxh.community.model.CommentExample;
import cn.lxh.community.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {

    int incCommentCount(Comment comment);

}