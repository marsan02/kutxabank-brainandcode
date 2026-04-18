package com.kutxabank.sample;

import org.apache.commons.text.StringSubstitutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {

    @GetMapping("/render")
    public String render(@RequestParam String template) {
        StringSubstitutor interpolator = StringSubstitutor.createInterpolator();
        return interpolator.replace(template);
    }
}
