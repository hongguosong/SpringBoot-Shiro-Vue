package com.heeexy.example;

import com.heeexy.example.config.security.VertifyHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyApplicationTest {

    @Test
    public void contextLoads() {
//        LicenseVertify vlicense=new LicenseVertify("noryar"); // 项目唯一识别码，对应生成配置文件的subject
//        vlicense.install(System.getProperty("user.dir"));
//        vlicense.vertify();

        VertifyHelper.getInstance().vertify();
    }

}
