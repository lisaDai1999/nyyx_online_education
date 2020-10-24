package com.jiaobuqifangzu.nyyx.controller;

import com.jiaobuqifangzu.nyyx.dao.repository.CommentRepository;
import com.jiaobuqifangzu.nyyx.dao.repository.UserRepository;
import com.jiaobuqifangzu.nyyx.domain.Comment;
import com.jiaobuqifangzu.nyyx.domain.User;
import com.jiaobuqifangzu.nyyx.entityForReturn.CommentRe;
import com.jiaobuqifangzu.nyyx.entityForReturn.MsgReturn;
import com.jiaobuqifangzu.nyyx.entityForReturn.UserComments;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ChenXing
 * @date 2020/10/23 09:07
 */
@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentHandler {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * @param commentReq
     * @return
     *
     * 编写人：陈星
     * 日期：2020/10/23
     * 输入说明：评论信息
     * 输出说明：暂无
     * 功能简述：添加评论
     */

    @PostMapping("/add")
    public MsgReturn add(@RequestBody Comment commentReq) {

        Date data = new Date();
        commentReq.setCreateTime(data);
        try {
            commentRepository.save(commentReq);
            return new MsgReturn(0, "评论成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new MsgReturn(1, "评论失败");
    }

    /**
     * @param video_id
     * @return
     *
     *
     * 编写人：陈星
     * 日期：2020/10/23
     * 输入说明：视频id
     * 输出说明：所有视频下的评论
     * 功能简述：获取评论
     */
    @GetMapping("/all")
    public CommentRe getAll(@RequestParam(value = "video_id") Integer video_id) {
        //返回结果
        CommentRe result = new CommentRe();
        List<UserComments> re = new ArrayList<>();

        //所有评论
        List<Comment> comments = commentRepository.findallVideo_id(video_id);


        if (comments.size() > 0) {
            //得到用户信息
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (Comment c : comments) {
                User user = userRepository.findUserById(c.getUser_id());
                String formattedDate = dateFormat.format(c.getCreateTime());
                re.add(new UserComments(user.getId(), user.getUsername(), formattedDate, user.getHead_img(), c.getText()));
            }
            result.setCode(0);
            result.setData(re);
            result.setMsg("评论获取成功");
        } else {
            result.setCode(1);
            result.setMsg("评论获取失败");
        }


        return result;
    }

}
