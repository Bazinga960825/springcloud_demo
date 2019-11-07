package cn.itcast.user.service;

import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Zac Dong
 * @Date 2019/10/29 15:16
 * @Version 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id主键查询用户
     *
     * @param id
     * @return
     */
    public User queryById(Long id) {
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return userMapper.selectByPrimaryKey(id);
    }

}
