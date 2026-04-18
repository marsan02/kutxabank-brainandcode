package com.kutxabank.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PaymentsApplication {

    private static final Logger log = LogManager.getLogger(PaymentsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PaymentsApplication.class, args);
    }

    @GetMapping("/lookup")
    public String lookup(@RequestParam String account) {
        log.info("Lookup requested for account: " + account);
        return "ok";
    }
}
