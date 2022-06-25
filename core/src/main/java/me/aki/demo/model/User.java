package me.aki.demo.model;

import lombok.Data;

/**
 * @author bchen5
 * @date 2022/6/21 17:21
 */
@Data
public class User implements java.io.Serializable{
    private String name;
    private Integer age;
}
