

package com.jiaobuqifangzu.nyyx.dao.repository;

import com.jiaobuqifangzu.nyyx.domain.Course;
import com.jiaobuqifangzu.nyyx.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author ChenXing
 * @date 2020/10/9 11:52
 */

public interface CourseRepository extends JpaRepository<Course, Integer>, JpaSpecificationExecutor<Course> {

	@Query(value = "select * from course where teacher_id = :teacherId", nativeQuery = true)
    public List<Course> findCoursesByTeacher_id(@Param("teacherId") Integer teacherId);
	
	//根据course_id查找课程
	public Course findCourseById(Integer courseId);

	/**
	 * 根据course_name模糊查询
	 * 
	 * @param course_name
	 * @return
	 * 编写人：戴礼霞
	 * 日期：2020年10月23日 
	 * 输入说明：course_name
	 * 输出说明：根据course_name模糊查询得到course课程列表
	 * 功能简述：根据course_name模糊查询
	 */
    @Query(value = "SELECT * FROM course WHERE course_name LIKE '%?%' ORDER BY create_time DESC", nativeQuery = true)
    public List<Course> findAllByCourseNameLike(String course_name);

}
