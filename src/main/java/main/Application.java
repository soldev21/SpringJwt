package main;

import az.ds.asanpay.logging.configuration.LoggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {Application.class, LoggerConfiguration.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
