package com.hj.entity.leave;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-06-19 15:50
 */
@Data
public class ResultData<T> implements Serializable {
    private Integer status = 1;

    private String message = "Success";

    private T data;
}
