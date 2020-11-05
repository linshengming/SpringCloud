package cn.ming.springcloud.myhandler;

import cn.ming.springcloud.entity.CommonResult;
import cn.ming.springcloud.entity.Payment;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author: ming
 * @create: 2020/11/5 12:50
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return  new CommonResult(444,"按照用戶自定義的global 異常處理 ----->1",new Payment(2020L,"serial001"));
    }

    public static CommonResult handlerException2(BlockException exception){
        return  new CommonResult(444,"按照用戶自定義的global 異常處理 ----->2",new Payment(2020L,"serial002"));
    }
}