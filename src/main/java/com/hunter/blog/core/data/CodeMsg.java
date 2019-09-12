package com.hunter.blog.core.data;

/**
 * 状态码信息
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/4 15:56
 */
public class CodeMsg {
    private String code;
    private String msg;
    private String type;

    public static CodeMsg SUCCESS = new CodeMsg("0", "请求成功", "success");
    public static CodeMsg ERROR = new CodeMsg("-1", "请求失败", "error");
    public static CodeMsg REQUEST_PARAMETER_ERROR = new CodeMsg("105", "请求参数异常", "error");

    public static CodeMsg BIND_ERROR = new CodeMsg("101", "参数异常!");
    public static CodeMsg SERVER_ERROR = new CodeMsg("100", "系统异常!");

    public static CodeMsg SESSION_ERROR = new CodeMsg("102", "session异常！");
    public static CodeMsg REQUEST_ERROR = new CodeMsg("103", "非法请求!");
    public static CodeMsg REQUEST_OVER_LIMT = new CodeMsg("104", "请求次数过多！");

    public CodeMsg() {
    }

    /**
     * 不带参的构造函数
     *
     * @param code
     * @param msg
     */
    public CodeMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg(String code, String msg, String type) {
        this.code = code;
        this.msg = msg;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CodeMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
