package cn.lxh.community.dto;

import cn.lxh.community.model.User;
import com.fasterxml.jackson.databind.node.LongNode;
import lombok.Data;

@Data
public class CommentDTO {

    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
}
