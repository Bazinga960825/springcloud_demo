package cn.itcast.consumer.client.fallback;

import cn.itcast.consumer.client.UserClient;
import cn.itcast.consumer.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @Author Zac Dong
 * @Date 2019/11/07 09:16
 * @Version 1.0
 */
@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("用户异常！");
        return user;
    }
}
