package com.Pasta.JustMeet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JustMeet extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JustMeet.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(JustMeet.class, args);
    }
}




// TODO : 5.SpringTest (difficult) inter merda
// TODO : 7. factory or builder per la creazione delle notifiche (medium)


 