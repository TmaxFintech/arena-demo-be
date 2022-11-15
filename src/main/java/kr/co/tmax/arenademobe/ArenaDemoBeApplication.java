package kr.co.tmax.arenademobe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ArenaDemoBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArenaDemoBeApplication.class, args);
    }
}
