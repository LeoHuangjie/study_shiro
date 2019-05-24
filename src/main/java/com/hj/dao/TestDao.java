package com.hj.dao;

import com.hj.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author huangjie
 * @time 2019-05-13 19:11
 */
@Mapper
public interface TestDao {
    /**
     * @param id
     * @return
     */
    Test selectOne(@Param("id") Integer id);
}
