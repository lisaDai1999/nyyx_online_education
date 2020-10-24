package com.jiaobuqifangzu.nyyx.controller;


import com.jiaobuqifangzu.nyyx.entityForReturn.FileReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ChenXing
 * @date 2020/10/14 20:37
 */
@Controller
@RequestMapping("/file")
public class FileHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileHandler.class);


    /**
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     *编写人：陈星
     *日期：2020/10/18
     *输入说明：获取视频封面文件
     *输出说明：返回文件路径以及成功信息
     *功能简述：视频封面上传
     */

    @PostMapping("/uploadPoster")
    @ResponseBody
    public FileReturn uploadPoster(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        FileReturn fileReturn = new FileReturn();

        if (file.isEmpty()) {
            fileReturn.setCode(1);
            fileReturn.setMsg("视频封面上传失败");
            return fileReturn;
        }

        String upFile = file.getOriginalFilename();
        //用时间戳代替文件名
        Date data = new Date();
        String fileType = "";
        System.out.println(upFile);
        if (upFile != null)
            fileType += upFile.split("\\.")[upFile.split("\\.").length - 1];

//        System.out.println(fileType);
        String fileName = data.getTime() + "." + fileType;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String filepath = dateFormat.format(data);
        String creatpath = ResourceUtils.getURL("classpath:").getPath() + "static/" + filepath + "/";

        //用于查看路径是否正确
//        System.out.println(creatpath);

        File file1 = new File(creatpath);
        if (!file1.exists())
            file1.mkdirs();
        File dest = new File(creatpath + fileName);
        try {
            file.transferTo(dest);
            fileReturn.setCode(0);
            fileReturn.setMsg("视频封面上传成功");
            fileReturn.setData("/" + filepath + "/" + fileName);
            return fileReturn;
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return fileReturn;
    }

    /**
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     *编写人：陈星
     *日期：2020/10/18
     *输入说明：获取课程封面文件
     *输出说明：返回文件路径以及成功信息
     *功能简述：课程封面上传
     */

    @PostMapping("/uploadCourseCover")
    @ResponseBody
    public FileReturn uploadCourseCover(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        FileReturn fileReturn = new FileReturn();

        if (file.isEmpty()) {
            fileReturn.setCode(1);
            fileReturn.setMsg("课程封面上传失败");
            return fileReturn;
        }

        String upFile = file.getOriginalFilename();
        Date data = new Date();
        String fileType = "";
        System.out.println(upFile);
        if (upFile != null)
            fileType += upFile.split("\\.")[upFile.split("\\.").length - 1];

        String fileName = data.getTime() + "." + fileType;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String filepath = dateFormat.format(data);
        String creatpath = ResourceUtils.getURL("classpath:").getPath() + "static/" + filepath + "/";

        File file1 = new File(creatpath);
        if (!file1.exists())
            file1.mkdirs();
        File dest = new File(creatpath + fileName);
        try {
            file.transferTo(dest);
            fileReturn.setCode(0);
            fileReturn.setMsg("课程封面上传成功");
            fileReturn.setData("/" + filepath + "/" + fileName);
            return fileReturn;
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return fileReturn;
    }

    /**
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     *编写人：陈星
     *日期：2020/10/18
     *输入说明：获取视频文件
     *输出说明：返回视频路径以及成功信息
     *功能简述：视频文件上传
     */

    @PostMapping("/uploadVideo")
    @ResponseBody
    public FileReturn uploadVideo(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        FileReturn fileReturn = new FileReturn();

        if (file.isEmpty()) {
            fileReturn.setCode(1);
            fileReturn.setMsg("视频文件上传失败");
            return fileReturn;
        }

        String upFile = file.getOriginalFilename();
        Date data = new Date();
        String fileType = "";
        System.out.println(upFile);
        if (upFile != null)
            fileType += upFile.split("\\.")[upFile.split("\\.").length - 1];

        String fileName = data.getTime() + "." + fileType;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String filepath = dateFormat.format(data);
        String creatpath = ResourceUtils.getURL("classpath:").getPath() + "static/" + filepath + "/";

        File file1 = new File(creatpath);
        if (!file1.exists())
            file1.mkdirs();
        File dest = new File(creatpath + fileName);
        try {
            file.transferTo(dest);
            fileReturn.setCode(0);
            fileReturn.setMsg("视频文件上传成功");
            fileReturn.setData("/" + filepath + "/" + fileName);
            return fileReturn;
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return fileReturn;
    }

}



