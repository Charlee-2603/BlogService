package com.hunter.blog.core.data;

import java.io.Serializable;


/**
 * 封装返回数据的统一格式
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/4 13:46
 */
public class DataResult<T> implements Serializable {
    /**
     * 业务自定义状态码
     */
    private String code;

    /**
     * 请求状态描述
     */
    private String msg;

    /**
     * 请求数据
     */
    private T data;

    public DataResult() {
    }

    /**
     * 成功的构造函数
     *
     * @param data
     */
    public DataResult(T data) {
        this.code = "200";
        this.msg = "success";
        this.data = data;
    }

    /**
     * 成功的构造函数
     *
     * @param data
     * @param msg
     */
    public DataResult(T data, String msg) {
        // 默认成功0
        this.code = "0";
        this.msg = msg;
        this.data = data;
    }

    /**
     * 失败的构造函数
     *
     * @param codeMsg
     */
    public DataResult(CodeMsg codeMsg) {
        if (codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
    }

    /**
     * 成功的时候调用
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> DataResult<T> success(T data) {
        return new DataResult<>(data);
    }

    /**
     * 失败的时候调用
     *
     * @param codeMsg
     * @param <T>
     * @return
     */
    public static <T> DataResult<T> error(CodeMsg codeMsg) {
        return new DataResult<T>(codeMsg);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
