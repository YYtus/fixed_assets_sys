package com.thundersoft.fixed_assets_sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot
        .SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.thundersoft.fixed_assets_sys.mapper")
public class FixedAssetsSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(FixedAssetsSysApplication.class, args);
    }

}
