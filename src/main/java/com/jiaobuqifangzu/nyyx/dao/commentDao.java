package com.jiaobuqifangzu.nyyx.dao;



import com.jiaobuqifangzu.nyyx.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ChenXing
 * @date 2020/10/3 12:07
 * 仅供测试使用!!!!!
 */

public interface commentDao extends JpaRepository<Comment, Integer>{
    //新增一条评论
//    @Query(value = "insert into comment (user_id, video_id, text, create_time) VALUES\n" +
//            "(00001,00001,'这是一个视频',current_timestamp)", nativeQuery = true)
//    public List<Comment> addComment(Comment comment);


    //查找某个id评论
//    public List<Comment> findAllByUserId(int userId);

    //查找所有评论
//    @Query(value = "select * from comment",nativeQuery = true)
//    public  List<Comment> findAll();

}

