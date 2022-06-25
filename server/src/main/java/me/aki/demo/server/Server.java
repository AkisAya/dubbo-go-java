package me.aki.demo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @author bchen5
 * @date 2022/6/21 17:28
 */
@EnableAutoConfiguration
public class Server {
    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }
}
