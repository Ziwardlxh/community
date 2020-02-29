package cn.lxh.community.exception;

public enum CustomizeErrorCode implements ICustomizerErrorCode {

    Question_Not_Found(2001,"你找的问题不在了，要不要换个试试?"),
    TARGET_PARAM_Not_Found(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试"),
    SYSTEM_ERROR(2004, "服务冒烟了，要不然你稍后再试试"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006, "回复的评论不存在，要不要换个试试?");

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code,String message ) {
        this.code = code;
        this.message = message;
    }

}
