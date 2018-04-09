package com.hey.web.entity;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by heer on 2018/3/30.
 */
@Data
public class Hello {

    private int id;

    @Size(min = 1,max = 255,message = "长度必须在1到255之间")
    private String name;

    @Pattern(regexp = "^((0\\d{2,3}-\\d{7,8})|(1[3584]\\d{9}))$",message = "请输入正确的电话号码")
    private String tel;

    @NotNull(message = "date不能为空")
    private String date;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"tel\":")
                .append(tel);
        sb.append(",\"date\":\"")
                .append(date).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
