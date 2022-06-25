package me.aki.demo.server;

import me.aki.demo.model.User;
import me.aki.demo.model.UserProvider;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author bchen5
 * @date 2022/6/21 20:41
 */
@DubboService
public class UserProviderImpl implements UserProvider {
    @Override
    public User getUser(String name) {
        System.out.println(name);
        User u = new User();
        u.setName("akis");
        u.setAge(20);
        return u;
    }
}
