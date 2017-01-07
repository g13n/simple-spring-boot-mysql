package me.g13n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application extends AsyncConfigurerSupport {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
