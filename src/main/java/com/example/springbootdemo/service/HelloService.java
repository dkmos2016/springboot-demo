package com.example.springbootdemo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

public interface HelloService {

    public String index();
    public String upload(MultipartFile file) throws IOException;
    public String pquery(String id) throws ClassNotFoundException, SQLException;

    public String query(String id) throws ClassNotFoundException, SQLException;

    public String execute(String cmd) throws IOException, InterruptedException;
}
