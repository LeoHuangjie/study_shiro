package com.hj.entity.enums;

import lombok.Getter;

/**
 * 错误代码
 *
 * @author wangjing
 */
@Getter
public enum ResultCode {
    /**
     * 成功状态码
     */
    SUCCESS(200, "成功"),
    /**
     * 默认参数不合法
     */
    PARAM_ERROR(400, "参数不合法"),
    /**
     * 未知异常
     */
    INTERNAL_ERROR(500, "系统内部错误"),
    /**
     * 媒体类型不支持
     */
    MEDIA_TYPE_NOT_SUPPORTED(415, "媒体类型不支持"),
    /**
     * 方法不支持
     */
    METHOD_NOT_SUPPORTED(405, "方法不支持"),
    /**
     * 资源未找到
     */
    SOURCE_NOT_FOUND(404, "资源未找到"),
    /**
     * vrf验证提示
     */
    VRF_VALIDATE_FAIL(501, "没有内容，刷新下试试"),
    /**
     * 非图片
     */
    NOT_IMAGE(777, "上传错误/文件类型错误"),
    /**
     * 非图片
     */
    IMAGE_MAX_SIZE(778, "图片最大为10M\n"),
    /**
     * 首页框架模版与当前模版版本号一致
     */
    TEMP_VERSION_SAME(888, "首页框架模版版本与当前模版版本号一致"),
    /**
     * 业务数据唯一约束异常
     */
    TOKEN_AUTH_FAIL(999, "token认证失败"),

    /**
     * 业务数据唯一约束异常
     */
    DUPLICATE_ENTRY_ERROR(1000, "业务数据违反唯一约束"),
    /**
     * 触发敏感词
     */
    PGC_SENSITIVE(1001, "内容包含敏感词"),
    /**
     * 所选分类不可挂文章
     */
    CLASSIFY_NOT_ALLOW_PGC(1002, "所选分类不可挂文章"),
    /**
     * 请重新选择分类
     */
    CLASSIFY_NOT_RIGHT(1003, "请重新选择分类"),

    /**
     * 用户未找到
     */
    USER_NOT_FOUND(1032, "账号不存在,请重新输入"),
    /**
     * 密码两次输入不一致
     */
    TWO_INCONSISTENCIES_IN_PASSWORD(1033, "新密码设置前后不一致，请确认后重新输入"),
    /**
     * 该用户已存在，请直接登录或赋予权限
     */
    EMAIL_EXIST(1035, "该用户已存在，请直接登录或赋予权限"),
    /**
     * 老密码输入错误，请重新输入
     */
    ORG_PWD_ERROR(1036, "旧密码有误，请确认后重新输入"),
    /**
     * 密码非法
     */
    PWD_ILLEGAL(1037, "密码需要为数字和字母或字符的组合，请参照规则设置密码"),
    /**
     * 用户id不能为null
     */
    USER_ID_IS_NULL(1038, "用户id不能为空"),
    /**
     * 请至少选择一个角色
     */
    ROLE_LESS(1050, "每个账号必须最少设置一个角色，请确认"),

    /**
     * 角色绑定账号，无法禁用
     */
    BING_USER_COUNT_GT(1051, "当前角色还有绑定账号，无法禁用"),
    /**
     * 请至少为角色选定一个权限
     */
    PERMISSION_LESS(1052, "请至少为角色选定一个权限"),
    /**
     * 角色不存在
     */
    ROLE_NOT_FOUND(1053, "角色不存在"),
    /**
     * 角色名称不能为空
     */
    ROLE_NOT_BLANK(1054, "角色名称不能为空"),
    /**
     * 角色id不能为空
     */
    ROLE_ID_IS_NULL(1055, "角色id不能为空"),
    /**
     * 角色已禁用
     */
    ROLE_IS_FORBIDDEN(1056, "该角色已被禁用，重新启用后才可编辑权限"),
    /**
     * 不能指定已禁用的角色
     */
    HAS_FORBIDDEN_ROLE(1057, "不能指定已禁用的角色"),
    /**
     * 不能指定已禁用的角色
     */
    ROLE_NAME_EXIST(1058, "角色名称不能重复"),
    /**
     * 不能重复指定权限
     */
    PERMISSION_REPEAT(1059, "同一个账号不能重复配置同一角色，请确认"),

    /**
     * 请求参数为空
     */
    PARAMS_NULL(400,"输入参数不能为空"),

    REQUST_LIMIT(501,"过于频繁，请稍后再试");




    private final int value;
    private final String desc;

    ResultCode(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int value() {
        return this.value;
    }

    public String desc() {
        return this.desc;
    }

    public static ResultCode fromValue(int value) {
        ResultCode[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            ResultCode c = var1[var3];
            if (c.value == value) {
                return c;
            }
        }

        throw new RuntimeException("unknown result code:" + value);
    }
}
