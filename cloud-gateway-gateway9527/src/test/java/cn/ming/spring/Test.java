package cn.ming.spring;

import java.time.ZonedDateTime;

/**
 * @author: ming
 * @create: 2020/11/1 10:08
 */
public class Test {
    public static void main(String[] args) {
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
        //2020-11-01T10:10:51.512+08:00[Asia/Shanghai]
    }
}
