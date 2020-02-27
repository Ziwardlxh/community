package cn.lxh.community.exception;

public enum CustomizeErrorCode implements ICustomizerErrorCode {

    Question_Not_Found("你找的问题不在了，要不要换个试试?");

    @Override
    public String getMessage() {
        return message;
    }

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }
}
