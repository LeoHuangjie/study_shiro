package com.hj.excel;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huangjie
 * @time 2019-07-18 09:37
 */
@Data
public class TimeTable implements Serializable {

    private Date beginTime;

    private Date endTime;
}
