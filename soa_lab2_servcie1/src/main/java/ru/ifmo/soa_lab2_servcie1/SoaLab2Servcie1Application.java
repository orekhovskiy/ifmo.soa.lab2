package ru.ifmo.soa_lab2_servcie1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SoaLab2Servcie1Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SoaLab2Servcie1Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SoaLab2Servcie1Application.class, args);
    }

}
