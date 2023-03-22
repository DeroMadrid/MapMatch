package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class IndexController {
    @Autowired
    private JdbcOperations jdbcTemplate;

    @GetMapping("/index")
    public String gotoIndex(Model model){
        File file = new File("E:\\MyMapMatching\\demo\\src\\main\\resources\\static\\images\\captcha");
        File[] listImage = file.listFiles();
        Random r = new Random();
        int index = r.nextInt(listImage.length);
        String filename = listImage[index].toString();
        String ans = filename.split("_")[1].split("\\.")[0];
        System.out.println(filename.split("static")[1].replace("\\", "/"));
        System.out.println(ans);
        model.addAttribute("imagePath", filename.split("static")[1].replace("\\", "/"));
        model.addAttribute("answer", ans);
        return "pages/index.html";

    }

    @RequestMapping("login")
    public String loginAction(String name,String password){
//      name 和 password 是从前端拿回来的数据
        System.out.println(name);
        System.out.println(password);
        String sql = String.format("select username,password from userinfo where username='%s' and password='%s'", name, password);
        System.out.println(sql);
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        //判断userinfo表中是否存在对应用户，非空则登录成功，跳转到下一界面，否则回到登录页面
        while (result.next()){

            return "pages/login.html";
        }
        return "pages/login.html";
    }

}


