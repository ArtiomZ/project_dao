package com.example.projectdao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {

    private final String request = read("myScript.sql");
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Repository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public String getProductName(String name) {
        StringBuilder sB = new StringBuilder();

        var result = namedParameterJdbcTemplate.queryForRowSet(request
                + "'" + name + "'", new HashMap<>());

        while (result.next()) {
            sB.append(result.getString("product_name") + "\n");
        }
        return sB.toString();
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
