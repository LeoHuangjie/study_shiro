package com.hj.entity.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.hj.entity.excel.BaseReadModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huangjie
 * @time 2019-05-31 14:48
 */
@Data
public class ExcelReadUser extends BaseRowModel implements Serializable {
    private static final long serialVersionUID = -4330537011063501647L;

    @ExcelProperty(index = 0)
    private Integer id;

    @ExcelProperty(index = 1)
    private String name;

    @ExcelProperty(index = 2)
    private Integer sex;

    @ExcelProperty(index = 3)
    private Integer age;

    @ExcelProperty(index = 4)
    private Integer delete;

    @ExcelProperty(index = 5,format = "yyyy-MM-dd")
    private Date createTime;

    @ExcelProperty(index = 9)
    private Data updateTime;

}
