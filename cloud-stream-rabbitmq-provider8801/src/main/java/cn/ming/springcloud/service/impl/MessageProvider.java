package cn.ming.springcloud.service.impl;

import cn.ming.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: ming
 * @create: 2020/11/2 18:14
 */
@EnableBinding(Source.class) //定義消息的推送管道
public class MessageProvider implements IMessageProvider {

    /**
     * 消息發送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*******serial: " + serial);
        return null;
    }
}
