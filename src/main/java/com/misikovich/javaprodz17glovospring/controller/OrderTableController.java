package com.misikovich.javaprodz17glovospring.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class OrderTableController {
    private final ResourceLoader resourceLoader;

    @GetMapping
    public @ResponseBody String getTable() throws IOException {
        return new String(resourceLoader.getResource("classpath:/static/OrderTable.html")
                .getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
