package com.example.springbootdemo;

import java.io.IOException;
import java.io.OutputStream;

public class TestController {

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        Process p = processBuilder.command("calc").start();
        p.waitFor();
        OutputStream out = p.getOutputStream();
        System.out.println(out);
    }
}
