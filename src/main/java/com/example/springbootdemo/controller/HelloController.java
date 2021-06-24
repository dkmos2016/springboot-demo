package com.example.springbootdemo.controller;

import com.example.springbootdemo.service.HelloService;
import com.example.springbootdemo.service.impl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        HelloService helloService = new HelloServiceImpl();

        return helloService.index();
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        HelloService helloService = new HelloServiceImpl();
        helloService.upload(file);
        return "done";
    }

    @RequestMapping("/query")
    public String query(@RequestParam String id) throws SQLException, ClassNotFoundException {
        HelloService helloService = new HelloServiceImpl();
        return helloService.query(id);
    }

    @RequestMapping("/pquery")
    public String pquery(@RequestParam String id) throws SQLException, ClassNotFoundException {
        HelloService helloService = new HelloServiceImpl();
        return helloService.pquery(id);
    }
}
