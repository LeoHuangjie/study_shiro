package com.hj.applicationListener;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author huangjie
 * @time 2019-07-22 11:34
 */
@Data
public class StudentEvent extends ApplicationEvent {

    private Integer id;

    public StudentEvent(Object source) {
        super(source);
    }

    public StudentEvent(Object source, Integer id) {
        super(source);
        this.id = id;
    }


}
