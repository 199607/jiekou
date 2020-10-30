package com.nufe.grain.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nufe.grain.bean.Result;
import com.nufe.grain.mapper.GraphMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;
@CrossOrigin
@RestController
public class GraphController {
    @Autowired
    private GraphMapper mapper;

    @GetMapping("/companyTestingNum")
    public Result companyTestingNum() {
        Result result = new Result();
        List<Map<String, Object>> companyTestingNum = mapper.getCompanyTestingNum();
        result.setData(companyTestingNum);
        return result;
    }


    @GetMapping("/testpie")
    public Object testpie() {

        String jsonpath = "src/main/resources/graph.json";
        String s = null;
        try {
            s = fileRead(jsonpath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object result = JSONObject.parse(s);

        return result;
    }

    public String fileRead(String url) {
        File file = new File(url);//定义一个file对象，用来初始化FileReader
        FileReader reader = null;//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = null;
        StringBuilder sb = null;
        try {
            reader = new FileReader(file);
            bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
            sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
            String s = "";
            while ((s = bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
                sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String str = sb.toString();
        return str;

    }
}