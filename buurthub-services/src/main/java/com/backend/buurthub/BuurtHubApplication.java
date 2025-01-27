package com.backend.buurthub;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
    info =
        @Info(
            title = "BuurtHub backend REST API Documentation",
            description = "BuurtHub backend services REST API Documentation",
            version = "v1",
            contact =
                @Contact(
                    name = "Viswanath Kambhampati",
                    email = "test@test.com",
                    url = "https://buurt-hub.vercel.app/"),
            license = @License(name = "BuurtHub 1.0", url = "https://buurt-hub.vercel.app")),
    externalDocs =
        @ExternalDocumentation(
            description = "BuurtHub backend services REST API Documentation",
            url = "https://www.test.com/swagger-ui.html"))
public class BuurtHubApplication {

  public static void main(String[] args) {
    SpringApplication.run(BuurtHubApplication.class, args);
  }
}
