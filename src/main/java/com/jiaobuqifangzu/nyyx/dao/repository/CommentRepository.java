package com.jiaobuqifangzu.nyyx.dao.repository;

import com.jiaobuqifangzu.nyyx.domain.Comment;
import com.jiaobuqifangzu.nyyx.entityForReturn.UserComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ChenXing
 * @date 2020/10/23 08:44
 */

public interface CommentRepository extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {
    //新增一条评论
    @Query(value = "insert into comment (user_id, video_id, text, create_time) VALUES\n" +
            "(:userId,:videoId,:text,current_timestamp)", nativeQuery = true)
    public List<Comment> addComment(@Param("userId") String userId, @Param("videoId") String videoId, @Param("text") String text);

    @Query(value = "select * from comment where video_id = :id order by create_time desc ", nativeQuery = true)
    public List<Comment> findallVideo_id(@Param("id") Integer id);

    //查找某个id评论
//    select user.username,head_img,comment.user_id,comment.text,comment.create_time from comment left join nyyx.user on user_id = user.id where video_id = 1
//    @Query(value = "select user.username,head_img,comment.user_id,comment.text,comment.create_time from comment left join nyyx.user on user_id = user.id where video_id = :videoId order by comment.create_time desc)", nativeQuery = true)
//    public List<UserComments> findComment(@Param("videoId") Integer videoId);

    //查找所有评论
    @Query(value = "select * from comment", nativeQuery = true)
    public List<Comment> findAll();

}