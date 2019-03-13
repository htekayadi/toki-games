package com.toki.games;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;

/**
 * @author htekayadi
 *
 */
@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class TokiApplication {
  public static void main(String[] args) {
    SpringApplication.run(TokiApplication.class, args);
  }
}
