package com.jiaobuqifangzu.nyyx.Utils;

import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 包含main函数，测试文件存储路径访问
 *
 * @author ChenXing
 * @date 2020/10/14 21:36
 */
public class test {
    public static void main(String[] args) throws FileNotFoundException {
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        String creatpath = ResourceUtils.getURL("").getPath();
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "template";
        String formattedDate = dateFormat.format(data);
        String creatpath1 = ResourceUtils.getURL("classpath:").getPath() + "static/" + "filename" + "/";

        System.out.println(creatpath + "src/man");

        System.out.println(creatpath1);
//        System.out.println(path);
//        System.out.println(formattedDate);
//        System.out.println(data.getTime());
//        String value= "32.jpeg";
//        String[] re = value.split("\\.");
//
//        System.out.println(re.length);
//        String fileType = value.split(".")[value.split(".").length+1];
//        System.out.println(fileType);
    }
}
