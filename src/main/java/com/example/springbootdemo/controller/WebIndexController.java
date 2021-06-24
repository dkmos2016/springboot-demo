package com.example.springbootdemo.controller;

import com.example.springbootdemo.service.HelloService;
import com.example.springbootdemo.service.impl.HelloServiceImpl;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class WebIndexController {

//    @GetMapping("/index")
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String Index(@RequestParam String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });

        return url;
    }


    @RequestMapping("echo")
    public String Echo(@RequestParam String message) {
        return message;
    }

    @RequestMapping("cmd")
    public String exec(@RequestParam String cmd) throws IOException, InterruptedException {
        HelloService helloService = new HelloServiceImpl();
        helloService.execute(cmd);
        return "done.";
    }
}
