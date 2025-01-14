package org.springcourse.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
@EntityScan(basePackages = "org.springcourse.springboot.model")
@EnableJpaRepositories(basePackages = "org.springcourse.springboot.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        if (args.length == 0) {
            System.setProperty("java.awt.headless", "false");
            try {
                Desktop.getDesktop().browse(new URI("http://localhost:8080/users"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
