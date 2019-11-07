package cn.itcast.consumer.controller;

import cn.itcast.consumer.client.UserClient;
import cn.itcast.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zac Dong
 * @Date 2019/11/05 22:31
 * @Version 1.0
 */
@RestController
@RequestMapping("/cf")
public class ConsumerFeignController {
    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userClient.queryById(id);
    }

}
