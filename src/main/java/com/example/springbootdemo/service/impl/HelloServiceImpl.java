package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.service.HelloService;
import com.mysql.cj.jdbc.StatementImpl;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class HelloServiceImpl implements HelloService {
    @Override
    public String index() {
        return "Hello World!";
    }

    @Override
    public String upload(MultipartFile file) throws IOException {
        byte[] cont = file.getBytes();
        FileOutputStream fos = new FileOutputStream(this.getClass().getResource("").getPath()+ File.separator + "output"+File.separator+ file.getOriginalFilename());

        fos.write(cont);
        fos.close();
        return "write done.";
    }

    @Override
    public String query(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RUNOOB");

        PreparedStatement ps = conn.prepareStatement("select * from user where id=?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        return "query done";
    }

    @Override
    public String pquery(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RUNOOB");

        String sql = "select * from user where id='"+id+"'";
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        return "query done";
    }

    @Override
    public String execute(String cmd) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = null;
        Process p = null;
        switch ((int) (Math.random() % 4)) {
            case 0:
                p = Runtime.getRuntime().exec(cmd);
                p.waitFor();
                p.getInputStream();
                break;
            case 1:
                processBuilder = new ProcessBuilder();
                processBuilder.command(cmd);
                p = processBuilder.start();
                p.getInputStream();
                break;
            case 2:
                processBuilder = new ProcessBuilder(cmd);
                p = processBuilder.start();
                p.getInputStream();
                break;
            case 3:
                p = new ProcessBuilder(cmd).start();
                p.getInputStream();
                break;
        }
        return null;
    }
}
