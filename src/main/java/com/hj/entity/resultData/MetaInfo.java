package com.hj.entity.resultData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 分页信息
 *
 * @author wangjing
 * @Description:
 * @date 2018/12/11 5:46 PM
 */
@Data
@NoArgsConstructor //将生成一个没有参数的构造函数
@AllArgsConstructor  //为类中的每个字段生成一个带有1个参数的构造函数
public class MetaInfo implements Serializable {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = 5522441251703441537L;

    private Integer total;

    private Integer limit;

    private Integer offset;
}
