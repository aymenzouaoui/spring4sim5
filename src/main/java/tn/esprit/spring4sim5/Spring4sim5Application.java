package tn.esprit.spring4sim5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Spring4sim5Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring4sim5Application.class, args);
    }

}
