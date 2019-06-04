package com.hj.lombokTest;

import lombok.*;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-06-04 13:42
 */
@ToString  //toString 方法
@EqualsAndHashCode //equals和hashCode方法
@Getter
@Setter
@AllArgsConstructor //构造方法
@Data // @Value和data类似 用来修饰不可变的类上
public class LomBokTest implements Serializable {

    private static final long serialVersionUID = 3586929047524569809L;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Integer id;

    private Integer studentId;

    private Integer classId;

    private Integer lessonId;

    private String name;
}
