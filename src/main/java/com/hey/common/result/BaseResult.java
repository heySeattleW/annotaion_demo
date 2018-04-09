package com.hey.common.result;

import com.hey.common.enums.CodeStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by heer on 2018/3/29.
 */
@Data
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String msg = CodeStatus.SUCCESS.getMsg();

    private int code = CodeStatus.SUCCESS.getCode();

    private T data;

    public BaseResult() {
        super();
    }

    public BaseResult(T data) {
        super();
        this.data = data;
    }

    public BaseResult(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = CodeStatus.ERROR.getCode();
    }

    public String getMsg(CodeStatus code) {
        String msg = code.getMsg(code.getCode());
        return this.msg.equals(msg)?msg:null;
    }



    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setMsg(CodeStatus code) {
        this.msg = code.getMsg(code.getCode());
    }


    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"msg\":\"")
                .append(msg).append('\"');
        sb.append(",\"code\":")
                .append(code);
        sb.append(",\"data\":")
                .append(data);
        sb.append('}');
        return sb.toString();
    }

    public void setData(T data) {
        this.data = data;
    }


}
