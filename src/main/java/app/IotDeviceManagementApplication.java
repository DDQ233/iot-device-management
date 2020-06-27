package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "app.dao")
public class IotDeviceManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotDeviceManagementApplication.class, args);
    }

}
