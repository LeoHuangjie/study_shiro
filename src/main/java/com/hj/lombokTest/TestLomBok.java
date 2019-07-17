package com.hj.lombokTest;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author huangjie
 * @time 2019-06-04 13:44
 */
@Slf4j
public class TestLomBok {

    public void test (@NonNull Integer id, @NonNull Integer studentId, @NonNull Integer classId, @NonNull Integer lessonId) throws FileNotFoundException {
        //@Cleanup 用于标记需要释放清理操作的资源对象变量

//        @Cleanup FileInputStream fileInputStream = new FileInputStream("path");

    }

    @SneakyThrows
    public void test1 () {
        //val 用于修饰不可变变量，var 修饰可变变量
//        val a = "123";
//
//        Integer num = 123;
    }
}
