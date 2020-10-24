package com.jiaobuqifangzu.nyyx.dao.repository;


import com.jiaobuqifangzu.nyyx.domain.Comment;
import com.jiaobuqifangzu.nyyx.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ChenXing
 * @date 2020/10/12 13:54
 */
public interface VideoRepository extends JpaRepository<Video, Integer>, JpaSpecificationExecutor<Video> {
    @Query(value = "select * from video where course_id = :courseId order by create_time desc", nativeQuery = true)
    public List<Video> findAllByCourse_id(@Param("courseId") Integer courseId);

    public Video findVideoById(Integer id);
}
