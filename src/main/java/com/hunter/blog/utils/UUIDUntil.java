package com.hunter.blog.utils;

import java.util.UUID;

/**
 * UUID工具类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/10 21:57
 */
public class UUIDUntil {

    public static final String getUUID32() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
