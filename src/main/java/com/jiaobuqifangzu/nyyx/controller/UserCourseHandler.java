package com.jiaobuqifangzu.nyyx.controller;

import com.jiaobuqifangzu.nyyx.dao.repository.CourseRepository;
import com.jiaobuqifangzu.nyyx.dao.repository.UserCourseRepository;
import com.jiaobuqifangzu.nyyx.domain.Course;
import com.jiaobuqifangzu.nyyx.domain.UserCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jiaobuqifangzu.nyyx.entityForReturn.MsgReturn;

import java.util.Date;
import java.util.List;

/**
 * @author ChenXing
 * @date 2020/10/9 16:47
 */
@RestController
@RequestMapping("/usercourse")
public class UserCourseHandler {
    @Autowired
    UserCourseRepository userCourseRepository;

    /**
     * 加入课程
     * 
     * @param userCourseReq: user_id, course_id
     * @return
     * 编写人：戴礼霞
     * 日期：2020年10月22日 
     * 输入说明：user_id, course_id
     * 输出说明：加入课程反馈信息
     * 功能简述：向user_course表中插入一条数据
     */
    @PostMapping("/add")
    public MsgReturn addUserCourse(@RequestBody UserCourse userCourseReq) {
    	try {
    		//向user_course表插入数据
    		userCourseRepository.save(userCourseReq);
    		//验证数据插入是否成功
    		List<UserCourse> uc = userCourseRepository.
    				findUserCourseByUserIdAndCourseId(userCourseReq.getUserId(), userCourseReq.getUserId());
    		if(uc.size() > 0) {
        		return new MsgReturn(0, "加入课程成功");
    		}
    		else {
    			return new MsgReturn(1, "加入课程失败");
    		}
        	
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return new MsgReturn();
    }
    
    @PostMapping("/test")
    public String Test() {
    	return "0";
    }

    /**
     * 退出课程
     * 
     * @param userCourseReq: user_id, course_id
     * @return
     * 编写人：戴礼霞
     * 日期：2020年10月22日 
     * 输入说明：user_id, course_id
     * 输出说明：退出课程反馈信息
     * 功能简述：从user_course表中删除一条数据
     */
    @PostMapping("/delete")
    public MsgReturn deleteUserCourse(@RequestBody UserCourse userCourseReq) {
    	try {
    		//数据库查询
        	List<UserCourse> res = userCourseRepository.
        			findUserCourseByUserIdAndCourseId(userCourseReq.getUserId(), userCourseReq.getCourseId());
    		//有符合条件的数据
        	if(res.size() >= 1) {
        		for(UserCourse uc : res) {
        			userCourseRepository.deleteById(uc.getId());
        		}
            	//删除后验证删除操作是否成功
            	List<UserCourse> res1 = userCourseRepository.
            			findUserCourseByUserIdAndCourseId(userCourseReq.getUserId(), userCourseReq.getCourseId());
            	if(res1.size() < 1) {
            		return new MsgReturn(0, "退出课程成功");
            	}
            	else {
            		return new MsgReturn(1, "退出课程失败");
            	}
        	}
        	//无符合条件的数据
        	else {
        		return new MsgReturn(1, "退出课程失败");
        	}
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
		return new MsgReturn();
    }
    
    /**
     * 根据user_id、course_id查询用户是否加入课程
     * 
     * @param userCourseReq
     * @return
     * 编写人：戴礼霞
     * 日期：2020年10月22日 
     * 输入说明：user_id, course_id
     * 输出说明：查询反馈信息
     * 功能简述：根据用户id、课程id查询user_course表中是否存在该记录
     */
    @GetMapping("/findUser")
    public MsgReturn findUserInUserCourse(@RequestBody UserCourse userCourseReq) {
    	try {
        	//数据库查询
        	List<UserCourse> res = userCourseRepository.
        			findUserCourseByUserIdAndCourseId(userCourseReq.getUserId(), userCourseReq.getCourseId());
        	//判断
        	if(res.size() >= 1) {
        		return new MsgReturn(0, "用户已加入课程");
        	}
    		return new MsgReturn(1, "用户未加入课程");
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return new MsgReturn();
    }

    /**
     * 已加入课程
     *
     * @param usercourseReq
     * @return
     */
    @GetMapping("/all")
    public List<UserCourse> allJoin(@RequestBody UserCourse usercourseReq) {
        List<UserCourse> res = userCourseRepository.findUserCoursesByUserId(usercourseReq.getUserId());
        return res;
    }


}
