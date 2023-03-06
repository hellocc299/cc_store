package com.cc.response;

public enum ErrorEnum {
    /*
     * 错误信息
     * */
    E_10000(10000, "登录过期，请重新登录！"),
    E_20000(20000, "操作失败！"),
    E_20001(20000, "请求超过次数！"),
    E_20010(20010, "网络异常！"),
    E_20011(20011, "缺少必填参数"),
    E_20012(20012, "该菜单已存在！"),
    E_20013(20013, "菜单不存在！"),
    E_20014(20014, "该职员不存在！"),
    E_20015(20015, "该用户不存在！"),
    E_20016(20016, "密码错误！"),
    E_20017(20017, "该用户已经存在！"),
    E_20018(20018, "参数不可为空！"),
    E_20019(20019, "密码必须为6～16位的字母或数字！"),
    E_20020(20020, "验证码错误！"),
    E_20021(20021, "文件为空！"),
    E_20022(20022, "服务器出现错误，上传失败"),
    E_20023(20023, "该商品已经存在"),
    E_20024(20024, "该商品不存在"),
    E_20025(20025, "该分类已经存在"),
    E_20026(20026, "分类名称不可为空"),
    E_20027(20027, "该分类不存在"),
    E_20028(20028, "签名校验失败"),
    E_20029(20029, "获取微信accesstoken失败"),
    ;
    private Integer errorCode;
    private String errorMsg;
    ErrorEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    public Integer getErrorCode() {
        return errorCode;
    }
    public String getErrorMsg() {
        return errorMsg;
    }
}
