package com.jenkins.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app/")
public class AppController {

    @GetMapping("test")
    public ResponseEntity<String> app(){
        return ResponseEntity.ok("App Working fine...!!!!");
    }
}
