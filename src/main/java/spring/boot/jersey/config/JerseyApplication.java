package spring.boot.jersey.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages = "spring.boot.jersey")
public class JerseyApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JerseyApplication.class, args);
    }
}
