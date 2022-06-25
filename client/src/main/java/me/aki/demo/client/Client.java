package me.aki.demo.client;

import me.aki.demo.model.DemoService;
import me.aki.demo.model.User;
import me.aki.demo.model.UserProvider;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

/**
 * @author bchen5
 * @date 2022/6/21 18:21
 */
public class Client {
    public static void main(String[] args) {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("demo");

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://localhost:2181");

//        // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
//        ReferenceConfig<DemoService> reference = new ReferenceConfig<>();
//        reference.setApplication(application);
//        reference.setRegistry(registry);
//        reference.setInterface(DemoService.class);
//        // reference.setVersion("1.0.0");
//
//       // 和本地bean一样使用xxxService
//        DemoService service = reference.get();
//        String data = service.sayHello("akis");
//        System.out.println(data);


        ReferenceConfig<UserProvider> reference = new ReferenceConfig<>();
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setInterface(UserProvider.class);
        // reference.setVersion("1.0.0");

        // 和本地bean一样使用xxxService
        UserProvider service = reference.get();
        User user = service.getUser("fff");
        System.out.println(user);

    }
}
