package com.hey.common.result;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by heer on 2018/3/29.
 */
@Data
@ToString
public class MultiResult<T> extends BaseResult {

    private List<T> data;

    public MultiResult() {
        super();
    }

    public MultiResult(List<T> data) {
        super();
        this.data = data;
    }

}
