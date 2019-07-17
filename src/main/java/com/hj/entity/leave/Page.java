package com.hj.entity.leave;

import lombok.Data;
import org.omg.CORBA.INTERNAL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjie
 * @time 2019-06-19 16:02
 */

public class Page<T> implements Serializable {

    private transient Integer page;

    private transient Integer pageSize;

    private Integer totalPage;

    private Integer totalRecord;

    private List<T> list;


    public Page(int page, int pageSize) {
        this.page = page >= 1 ? page : 1;
        if (pageSize > 0) {
            this.pageSize = pageSize;
        }

//        this.startNum = (page - 1) * pageSize;
        this.list = new ArrayList();
        this.totalPage = 0;
        this.totalRecord = 0;
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        if (this.pageSize <= 0) {
            this.totalPage = 1;
            return this.totalPage;
        } else {
            this.totalPage = (this.totalRecord + this.pageSize - 1) / this.pageSize;
            return this.totalPage >= 0 ? this.totalPage : 1;
        }
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
