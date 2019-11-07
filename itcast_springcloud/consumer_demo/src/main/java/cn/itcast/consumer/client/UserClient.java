package cn.itcast.consumer.client;

import cn.itcast.consumer.client.fallback.UserClientFallback;
import cn.itcast.consumer.config.FeignConfig;
import cn.itcast.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Zac Dong
 * @Date 2019/11/05 22:21
 * @Version 1.0
 */
@Component
//@FeignClient("user-service")
@FeignClient(value = "user-service", fallback = UserClientFallback.class, configuration = FeignConfig.class)
public interface UserClient {

    @GetMapping("/user/{id}")
    User queryById(@PathVariable("id") Long id);

}
