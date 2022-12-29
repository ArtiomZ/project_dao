package com.example.projectdao.SqlController;

import com.example.projectdao.Repository.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/fetch-product")
public class SqlController {
    private final Repository repository;

    public SqlController(Repository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<String> getProduct(@RequestParam String name) {
        return repository.getProductName(name);
    }
}