package com.jiaobuqifangzu.nyyx.dao.repository;

import com.jiaobuqifangzu.nyyx.domain.Course;
import com.jiaobuqifangzu.nyyx.domain.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
/**
 * @author ChenXing
 * @date 2020/10/9 16:44
 */
public interface UserCourseRepository extends JpaRepository<UserCourse, Integer>, JpaSpecificationExecutor<UserCourse> {

    public List<UserCourse> findUserCoursesByUserId(Integer id);
    public List<UserCourse> findUserCourseByUserIdAndCourseId(Integer userid, Integer courserid);

    //根据用户id和课程id删除课程
    public Course deleteByUserIdAndCourseId(Integer userid, Integer courseid);
    


    List<UserCourse> findByCourseId(Integer id);
    
    /**
     * 获取报课人数最多的前5门课
     * 
     * @param 
     * @return
     * 编写人：戴礼霞
     */
    @Query(value = "SELECT course_id, COUNT(user_id) res FROM user_course GROUP BY course_id ORDER BY res DESC  LIMIT 5", nativeQuery = true)
    public List<Object[]> findAllTopDesc();
    
    /**
     * 根据course_id查询报课人数
     * 
     * @param 
     * @return
     * 编写人：戴礼霞
     */
    @Query(value = "SELECT course_id, COUNT(user_id) FROM user_course WHERE course_id = :course_id GROUP BY course_id", nativeQuery = true)
    public Object[][] findCountByCourseId(@Param("course_id") Integer course_id);
}
