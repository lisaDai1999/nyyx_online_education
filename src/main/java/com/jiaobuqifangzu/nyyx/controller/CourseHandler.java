package com.jiaobuqifangzu.nyyx.controller;

import com.jiaobuqifangzu.nyyx.dao.repository.CourseRepository;
import com.jiaobuqifangzu.nyyx.entityForReturn.*;
import com.jiaobuqifangzu.nyyx.dao.repository.UserRepository;
import com.jiaobuqifangzu.nyyx.dao.repository.UserCourseRepository;

import com.jiaobuqifangzu.nyyx.domain.Course;
import com.jiaobuqifangzu.nyyx.domain.User;
import com.jiaobuqifangzu.nyyx.domain.UserCourse;

import com.jiaobuqifangzu.nyyx.somePropertiesInData.SwiperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.ColorUIResource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ChenXing
 * @date 2020/10/9 11:47
 * <p>
 * 课程hanlder
 */
@RestController
@RequestMapping("/course")
public class CourseHandler {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserCourseRepository userCourseRepository;

    /**
     * 添加课程
     *
     * @param courseReq
     * @return
     * 编写人：陈星
     * 日期：2020/10/18
     * 输入说明：课程信息
     * 输出说明：请求是否成功信息
     * 功能简述：向数据库中插入一条数据
     */
    @PostMapping("/add")
    public LoginReturn addCourse(@RequestBody Course courseReq) {

        Date data = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String formattedDate = dateFormat.format(data);
        courseReq.setCreateTime(data);
//        System.out.println(courseReq);
        try {
            courseRepository.save(courseReq);
            return new LoginReturn(0, "课程创建成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new LoginReturn(1, "课程创建失败");
    }

    /**
     * 获取推荐课程列表
     * @param
     * @return
     * 编写人：戴礼霞
     * 日期：2020年10月22日 
     * 输入说明：无
     * 输出说明：推荐课程列表
     * 			id-课程id, course_name-课程名, cover_route-课程封面路径, 
     * 			brief_introduction-课程简介, teacher-课程教师
     * 功能简述：在user_course表中，计算各们课程的总数，按递减序列返回前5条数据
     */
    @GetMapping("/findRecommend")
    public QueryCourseReturn getRecommendCourses() {	
		QueryCourseReturn queryCourseReturn = new QueryCourseReturn();
		
    	try {
    		/**
    		 * 获取每门课程报课人数（递减）
    		 * 结果表封装到List<Object[]>
    		 * Object[]：Object[0]:course_id, Object[1]:count
    		 */
        	List<Object[]> objs = userCourseRepository.findAllTopDesc();
        	
        	if(objs.size() > 0) {
        		//截取集合的前5条--报课总数最多的前5条
        		if(objs.size() > 5) {
        			objs = objs.subList(0, 5);
        		}

        		List<CourseReturn> res = new ArrayList();

//        		System.out.println("!!!!IN");
        		for(Object[] obj : objs) {
        			//根据course_id查询course实体
        			Course c = courseRepository.findCourseById(Integer.parseInt(obj[0].toString()));
        			User t = userRepository.findUserById(c.getTeacher_id());
        			CourseReturn courseReturn = new CourseReturn(c.getId(), c.getCourse_name(), 
        					c.getCover_route(), c.getBrief_introduction(), t.getUsername());
        			res.add(courseReturn);
        		}
        		queryCourseReturn.setCode(0);
        		queryCourseReturn.setMsg("课程获取成功");
        		queryCourseReturn.setData(res);
        		return queryCourseReturn;
        	}
        	else {
        		queryCourseReturn.setCode(1);
        		queryCourseReturn.setMsg("课程获取失败");
            	return queryCourseReturn;
        	}
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return queryCourseReturn;
    }

    /**
     * 查询课程信息
     * @param course_id
     * @return
     * 编写人：戴礼霞
     * 日期：2020年10月23日 
     * 输入说明：course_id
     * 输出说明：指定课程的课程信息
     * 功能简述：查询指定课程信息
     */
    @GetMapping("/findCourseInfo")
    public QueryCourseCountInfoReturn findCourseInfo(@RequestParam(value = "course_id") int course_id) {
    	QueryCourseCountInfoReturn queryCourseCountInfoReturn = new QueryCourseCountInfoReturn();
    	try {
    		//在user_course表中统计指定课程的报课人数
//    		Object[][] obj = userCourseRepository.findCountByCourseId(course_id);
    		List<Object[][]> object = userCourseRepository.findCountByCourseId(course_id);
    		
    		CourseCountInfoReturn courseCountInfoReturn = new CourseCountInfoReturn();
    				
    		//根据course_id获取课程实体
    		Course c = courseRepository.findCourseById(course_id);
    		//根据课程的teacher_id获取teacher_user实体
    		User t = userRepository.findUserById(c.getTeacher_id());
    		if(object.size() == 1) {
    			Object[][] obj = object.get(0);
        		courseCountInfoReturn = new CourseCountInfoReturn(c.getCover_route(), c.getCourse_name(), 
        				c.getBrief_introduction(), c.getTeacher_id(), t.getUsername(), Integer.parseInt(obj[0][0].toString()));
    		}else if(object.size() == 0) {//报课人数为0
        		courseCountInfoReturn = new CourseCountInfoReturn(c.getCover_route(), c.getCourse_name(), 
        				c.getBrief_introduction(), c.getTeacher_id(), t.getUsername(), 0);
    		}
    		
    		queryCourseCountInfoReturn.setCode(0);
    		queryCourseCountInfoReturn.setMsg("课程信息获取成功");
    		queryCourseCountInfoReturn.setData(courseCountInfoReturn);
        	return queryCourseCountInfoReturn;
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	queryCourseCountInfoReturn.setCode(1);
    	queryCourseCountInfoReturn.setMsg("课程信息获取失败");
    	return queryCourseCountInfoReturn;
    }
    
    
    /**
     * 根据user_id查询课程列表
     * 
     * @param user_id
     * @return
     * 编写人：戴礼霞
     * 日期：2020年10月23日 
     * 输入说明：user_id
     * 输出说明：指定用户的查询课程列表
     * 功能简述：根据user_id查询课程列表
     */
    @GetMapping("/findByUserId")
    public QueryCourseReturn findByUserID(@RequestParam(value = "user_id") Integer user_id) {
    	QueryCourseReturn queryCourseReturn = new QueryCourseReturn();
    	try {
    		List<CourseReturn> res = new ArrayList();
			//根据user_id查询user_course表
    		List<UserCourse> userCourses = userCourseRepository.findUserCoursesByUserId(user_id);
    		
    		if(userCourses.size() > 0) {
    			for(UserCourse uc : userCourses) {
    				//根据获取到的course_id查询course表
        			Course c = courseRepository.findCourseById(uc.getCourseId());
        			//根据获取到的teacher_id查询user表
        			User u = userRepository.findUserById(c.getTeacher_id());
        			
        			CourseReturn courseReturn = new CourseReturn(c.getId(), c.getCourse_name(), 
        					c.getCover_route(), c.getBrief_introduction(), u.getUsername());
        			res.add(courseReturn);
    			}//for
    			queryCourseReturn.setCode(0);
    			queryCourseReturn.setMsg("课程信息获取成功");
    			queryCourseReturn.setData(res);
    			return queryCourseReturn;
    		}//if
    		else {
    			queryCourseReturn.setCode(1);
    			queryCourseReturn.setMsg("课程信息获取失败");
    			return queryCourseReturn;
    		}
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return queryCourseReturn;
    }
    
    
    /**
     * 根据teacher_id查询课程列表
     * 
     * @param
     * @return
     * 编写人：戴礼霞
     * 日期：2020年10月24日 
     * 输入说明：
     * 输出说明：
     * 功能简述：
     */
    @GetMapping("/findByTeacherId")
    public QueryCourseListByIdReturn findByTeacherId(@RequestParam(value = "teacher_id") int teacherId) {
    	QueryCourseListByIdReturn queryCourseListByIdReturn = new QueryCourseListByIdReturn();
    	try {
    		CourseInfoByIdRetrun courseInfoReturn = new CourseInfoByIdRetrun();
    		
    		List<CourseInfoByIdRetrun> res = new ArrayList();
    		//根据teacher_id查询课程列表
    		List<Course> courses = courseRepository.findCoursesByTeacher_id(teacherId);

    		for(Course c : courses) {
    			/**
    			 * 统计每门课程的报课人数
    			 * 查询结果按行返回给Object[]
    			 */
        		
        		List<Object[][]> object = userCourseRepository.findCountByCourseId(c.getId());
        		if(object.size() == 1) {
        			Object[][] obj = object.get(0);
					courseInfoReturn = new CourseInfoByIdRetrun(c.getId(), c.getCover_route(), 
							c.getCourse_name(), c.getBrief_introduction(), Integer.parseInt(obj[0][0].toString()));
					res.add(courseInfoReturn);
        			
        		}else if(object.size() == 0){//报课人数为0
					courseInfoReturn = new CourseInfoByIdRetrun(c.getId(), c.getCover_route(), 
							c.getCourse_name(), c.getBrief_introduction(), 0);
					res.add(courseInfoReturn);
        		}
    		}
    		queryCourseListByIdReturn.setCode(0);
    		queryCourseListByIdReturn.setMsg("课程信息获取成功");
    		queryCourseListByIdReturn.setData(res);
    		return queryCourseListByIdReturn;
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	queryCourseListByIdReturn.setCode(1);
    	queryCourseListByIdReturn.setMsg("课程信息获取失败");
    	return queryCourseListByIdReturn;
    }

    /**
     * 根据course_name模糊查询课程列表
     * 
     * @param course_name
     * @return
     * 编写人：戴礼霞
     * 日期：2020年10月22日 
     * 输入说明：
     * 输出说明：
     * 功能简述：
     */
    @GetMapping("/findCourseByCourseName")
    public QueryCourseReturn findCourseByCourseName(@RequestParam(value = "course_name") String course_name) {
    	QueryCourseReturn queryCourseReturn = new QueryCourseReturn();
    	
    	try {
        	//模糊查询找到符合的course课程列表
    		List<Course> courses = courseRepository.findAllByCourseNameLike(course_name);

    		List<CourseReturn> res = new ArrayList();
    		System.out.println("!!INFO!!");

    		System.out.println("SIZE" + courses.size());
    		if(courses.size() > 0) {
        		for(Course c : courses) {
        			//根据course表中的teacher_id查找user_teacher实体
            		User t = userRepository.findUserById(c.getTeacher_id());
            		
            		CourseReturn courseReturn = new CourseReturn(c.getId(), c.getCourse_name(),
							 c.getCover_route(), c.getBrief_introduction(), t.getUsername());
            		res.add(courseReturn);
        		}
        		queryCourseReturn.setCode(0);
        		queryCourseReturn.setMsg("课程信息获取成功");
        		queryCourseReturn.setData(res);
        		return queryCourseReturn;
        	
    		}
//    		else {
//    			queryCourseReturn.setCode(1);
//    			queryCourseReturn.setMsg("课程信息获取失败");
//    			return queryCourseReturn;
//    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
		queryCourseReturn.setCode(1);
		queryCourseReturn.setMsg("课程信息获取失败");
		return queryCourseReturn;
    }
    
    
    /**
     * 根据teacher_name模糊查询课程列表
     * 
     * @param teacher_name
     * @return
     * 编写人：戴礼霞
     * 日期：2020年10月23日 
     * 输入说明：teacher_name
     * 输出说明：输出该教师的所有课程
     * 功能简述：根据teacher_name查询课程列表
     */
    @GetMapping("/findCourseByTeacherName")
    public QueryCourseReturn findCourseByTeacherName(@RequestParam(value = "teacher_name") String teacher_name) {
    	QueryCourseReturn queryCourseReturn = new QueryCourseReturn();
    	try {
        	//根据teacher_name找到教师列表
        	List<User> teachers = userRepository.findAllByNameLike(teacher_name);
        	
        	if(teachers.size()> 0) {
        		List<CourseReturn> res = new ArrayList();
        		for(User t : teachers) {
        			//每个老师都有一个课程列表
        			List<Course> tCourses = courseRepository.findCoursesByTeacher_id(t.getId());
        			//分别添加各老师的课程列表
        			if(tCourses.size() > 0) {
        				for(Course c : tCourses) {
        	    			CourseReturn courseReturn = new CourseReturn(c.getId(), c.getCourse_name(), 
        	    					c.getCover_route(), c.getBrief_introduction(), t.getUsername());
        	    			res.add(courseReturn);
        				}
        			}//if(tCourses.size() > 0)
        		}//for
        		queryCourseReturn.setCode(0);
        		queryCourseReturn.setMsg("课程信息获取成功");
        		queryCourseReturn.setData(res);
        		return queryCourseReturn;
        	}//if(teachers.size()> 0)
        	else {
        		queryCourseReturn.setCode(1);
        		queryCourseReturn.setMsg("课程信息获取失败");
        		return queryCourseReturn;
        	}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
		queryCourseReturn.setCode(1);
		queryCourseReturn.setMsg("课程信息获取失败");
		return queryCourseReturn;
    }

	/**
	 * 1获取首页轮播图列表：
	 * 编写人：卢芮
	 * 日期：2020年10月23日
	 * 输入说明：无
	 * 输出说明：
	 * 功能简述：返回前四个课程信息
	 * @return 轮播图信息
	 */
	@GetMapping("/findswiper")
	public SwiperReturn getSwiper(){

		List<Course> all = courseRepository.findAllByIdAfter(0);
		SwiperReturn swiperReturn = new SwiperReturn();

		if (all == null){
			//查找失败
			swiperReturn.setCode(1);
			swiperReturn.setMsg("轮播图获取失败");
			return swiperReturn;
		}

		//进行排序
		Collections.sort(all, new Comparator<Course>() {
			@Override
			public int compare(Course o1, Course o2) {
				//重写比较函数
				return o1.getCreateTime().compareTo(o2.getCreateTime());
			}
		});

		//排序完成
		if (all != null){
			//查找成功，将前四个送入data中
			List<Course> newlist = all.subList(0,4);
			swiperReturn.setCode(0);
			swiperReturn.setMsg("轮播图获取成功");
			//用作data返回
			List<SwiperData> swiperDatas = new ArrayList<>();


			for (Course course : newlist) {
				SwiperData swiperData = new SwiperData();
				swiperData.setId(course.getId());
				swiperData.setCover_route(course.getCover_route());
				swiperDatas.add(swiperData);
			}

			swiperReturn.setData(swiperDatas);

			return swiperReturn;
		}

		return null;
	}
    

    /**
     * 已发布课程
     *
     * @param courseReq
     * @return
     */
    @GetMapping("/courses")
    public List<Course> findByTeacherId(@RequestBody Course courseReq) {
        List<Course> res = courseRepository.findCoursesByTeacher_id(courseReq.getTeacher_id());
        System.out.println("kechegnxinxi");
        return res;
    }

	/**
	 * 删除课程
	 * @param id
	 * @return
	 */
	@GetMapping("/delete")
	public MsgReturn delVideo(@RequestParam(value = "id") int id) {
		try {
			courseRepository.deleteById(id);
			userCourseRepository.deleteUserCoursesByCourseId(id);
			return new MsgReturn(0, "课程删除成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new MsgReturn(1, "课程删除失败");
	}
}
