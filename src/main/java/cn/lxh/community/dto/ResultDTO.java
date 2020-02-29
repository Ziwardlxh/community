package cn.lxh.community.dto;

import cn.lxh.community.exception.CustomizeErrorCode;
import cn.lxh.community.exception.CustomizeException;
import cn.lxh.community.exception.ICustomizerErrorCode;
import lombok.Data;

@Data
public class ResultDTO {

    private Integer code;
    private String message;

    public static ResultDTO errorof(Integer code,String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorof(ICustomizerErrorCode customizerErrorCode) {
        return  errorof(customizerErrorCode.getCode(),customizerErrorCode.getMessage());
    }

    public static ResultDTO errorof(CustomizeException e) {
        return  errorof(e.getCode(),e.getMessage());
    }

    public static ResultDTO okof(){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }
}
