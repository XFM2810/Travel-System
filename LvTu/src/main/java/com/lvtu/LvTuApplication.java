package com.lvtu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lvtu.mapper")
@SpringBootApplication
public class LvTuApplication {

  public static void main(String[] args) {
    SpringApplication.run(LvTuApplication.class, args);
  }
}
