package com.hj.entity;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-04-30 17:32
 */
public class Permission implements Serializable {

    private static final long serialVersionUID = 2806860583406068623L;

    private Long id;

    private String permission;

    private String description;

    private Boolean available = Boolean.FALSE;


    public Permission() {
    }

    public Permission(String permission, String description, Boolean available) {
        this.permission = permission;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
