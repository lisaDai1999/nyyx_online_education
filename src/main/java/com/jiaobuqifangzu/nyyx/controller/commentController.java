package com.jiaobuqifangzu.nyyx.controller;

import com.jiaobuqifangzu.nyyx.dao.commentService;
import com.jiaobuqifangzu.nyyx.domain.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ChenXing
 * @date 2020/10/3 12:47
 * 仅供测试使用！！！！
 */
@Slf4j
@RestController
@RequestMapping("/api/comments")
public class commentController {
//    @Autowired
//    commentService cService;
//
//
//    @RequestMapping("/userComments")
//    public void findallcomments(@RequestParam(value = "userid") int userId){
//
//        log.info("查询所有商品信息！");
//        List<Comment> res = cService.getAllUserId(1);
//        log.info(""+res.size());
//    }
//    @RequestMapping("/all")
//    public List<Comment> findall(){
//
//        log.info("查询所有商品信息！");
//        List<Comment> res = cService.getAll();
//        log.info(""+res.size());
//        return res;
//    }

}
