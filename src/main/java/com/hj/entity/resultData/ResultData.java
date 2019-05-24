package com.hj.entity.resultData;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.hj.entity.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * http 请求返回的最外层对象
 *
 * @param <T>
 * @author wangjing
 */
@Data
//为NULL或者为空不参加序列化
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultData<T> implements Serializable {

    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String errmsg;
    /**
     * 业务数据
     */
    private T data;
    /**
     * 分页信息
     */
    private MetaInfo meta;

    public final static Integer CODE_SUCCESS = 200;

    public static ResultData success(Object object) {
        ResultData resultData = new ResultData();
        resultData.setData(object);
        resultData.setCode(CODE_SUCCESS);
        return resultData;
    }

    public static ResultData success(Object object, MetaInfo meta) {
        ResultData resultData = new ResultData();
        resultData.setData(object);
        resultData.setCode(CODE_SUCCESS);
        resultData.setErrmsg("");
        resultData.setMeta(meta);
        return resultData;
    }

    public static ResultData success() {
        return success(null);
    }


    public static ResultData fail(Integer code, String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setErrmsg(msg);
        return resultData;
    }


    public static ResultData fail(ResultCode resultCode) {
        ResultData resultData = new ResultData();
        resultData.setCode(resultCode.value());
        resultData.setErrmsg(resultCode.desc());
        return resultData;
    }
}
