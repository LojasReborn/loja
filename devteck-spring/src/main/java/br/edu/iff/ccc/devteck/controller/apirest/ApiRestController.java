package br.edu.iff.ccc.devteck.controller.apirest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiRestController {

    @GetMapping
    public String status() {
        return "API DevTeck v1 - em construcao";
    }

}
