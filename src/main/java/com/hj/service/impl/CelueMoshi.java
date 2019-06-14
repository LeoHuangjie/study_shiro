package com.hj.service.impl;

import com.hj.service.InnerCommon;
import com.hj.service.InnerCommonContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author huangjie
 * @time 2019-06-10 19:35
 */
@Service
public class CelueMoshi {
    @Autowired
    private InnerCommonContext innerCommonContext;


    public void test (Integer id) {
        InnerCommon instance = null;
        try {
            instance = innerCommonContext.getInstance(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        instance.process(id);
    }


    public void test18In () {
        Date date = new Date();
        System.out.println(date);
    }


    public class I18nEntity {

        @NotBlank(message = "{vo.myerror.name}")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



}
