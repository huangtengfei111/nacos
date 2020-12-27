package com.example.demo.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class NacosController {
//        @NacosInjected
//        private ConfigService configService;

//        @NacosValue(value = "${common: false}", autoRefreshed = true)
        @Value(value = "${common: false}")
        private String config1;

        @Value(value = "${common-fullname: false}")
        private String config2;

        @Autowired
        ApplicationContext applicationContext;

        @GetMapping("/configs")
        public String test(){
                System.out.println("11111");
            return config1;
        }
        @GetMapping("/getValue")
        public String gteValue(){
                String property = applicationContext.getEnvironment().getProperty("common-fullname");
                String property2 = applicationContext.getEnvironment().getProperty("common2");
                System.out.println(property + "--" + property2);
                return config2;
        }
}
