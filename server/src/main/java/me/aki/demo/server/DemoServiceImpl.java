package me.aki.demo.server;

import me.aki.demo.model.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author bchen5
 * @date 2022/6/21 17:32
 */
@DubboService
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
