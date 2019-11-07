package cn.itcast.consumer.controller;

import cn.itcast.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author Zac Dong
 * @Date 2019/10/29 16:42
 * @Version 1.0
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
//    @HystrixCommand(fallbackMethod = "queryByIdFallback")
    @HystrixCommand
    public String queryById(@PathVariable Long id) {
/*
        String url = "http://localhost:9091/user/" + id;

        //获取Eureka中注册的user-service的实例
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("user-service");
        ServiceInstance serviceInstance = serviceInstances.get(0);
        url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id;
*/
        if (id == 1) {
            throw new RuntimeException("繁忙！");
        }
        String url = "http://user-service/user/" + id;
        return restTemplate.getForObject(url, String.class);
    }


    public String queryByIdFallback(Long id) {
        log.error("查询用户失败。id:{}", id);
        return "对不起，网络拥挤！";
    }

    public String defaultFallback() {
        return "默认降级提示：对不起，网络拥挤！";
    }

}
