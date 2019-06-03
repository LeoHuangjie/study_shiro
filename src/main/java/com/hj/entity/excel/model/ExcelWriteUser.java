package com.hj.entity.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.hj.entity.excel.BaseWriteModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huangjie
 * @time 2019-05-31 14:53
 */
@Data
public class ExcelWriteUser extends BaseRowModel implements Serializable {
    private static final long serialVersionUID = 8162636595556053576L;

    @ExcelProperty(index = 0,value = "ID")
    private Integer id;

    @ExcelProperty(index = 1,value = "姓名")
    private String name;

    @ExcelProperty(index = 2,value = "性别")
    private Byte sex;

    @ExcelProperty(index = 3,value = "年龄")
    private Integer age;

    @ExcelProperty(index = 4,value = "是否有效")
    private Byte delete;

    @ExcelProperty(index = 5,value = "时间",format = "yyyy-mm-dd")
    private Date createTime;
}
