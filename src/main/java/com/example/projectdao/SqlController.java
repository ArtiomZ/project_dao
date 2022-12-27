package com.example.projectdao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/products/fetch-product")
public class SqlController {
    private final Repository repository;

    public SqlController(Repository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ResponseBody
    public String getProduct(@RequestParam String name) {
        return repository.getProductName(name);
    }
}