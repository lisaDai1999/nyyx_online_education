package com.jiaobuqifangzu.nyyx.controller;

import com.jiaobuqifangzu.nyyx.dao.repository.SchoolRepository;
import com.jiaobuqifangzu.nyyx.dao.repository.UserCourseRepository;
import com.jiaobuqifangzu.nyyx.dao.repository.UserRepository;
import com.jiaobuqifangzu.nyyx.domain.School;
import com.jiaobuqifangzu.nyyx.domain.User;
import com.jiaobuqifangzu.nyyx.domain.UserCourse;
import com.jiaobuqifangzu.nyyx.entityForReturn.*;
import com.jiaobuqifangzu.nyyx.req.Regreq;
import com.jiaobuqifangzu.nyyx.somePropertiesInData.CourseUserData;
import com.jiaobuqifangzu.nyyx.somePropertiesInData.LoginData;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 组名：交不起房组
 * 创建人： 卢芮
 * 日期 ：2020/10/17
 * 描述： 用户handler
 * 版本 ：1.0
 *！！！还未进行异常捕捉
 */
@RestController
@RequestMapping("/user")
public class UserHandler {

    //注入userrepository
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserCourseRepository userCourseRepository;

    @Autowired
    SchoolRepository schoolRepository;

    //用户名已存在变量
    private static final int USERALREADYEXIST = -1;

    /**单元测试完成
     *
     * 15验证登录：
     * 编写人：卢芮
     * 日期：2020/10/17
     * @param phone 电话号码
     * @param password 密码
     * @return
     */
    @GetMapping("/login")
    public LoginReturn findUserByData(@RequestParam(value = "phone_num") String phone, @RequestParam(value = "password") String password){
        //System.out.println(userReq.getUsername());
        User userPhone = userRepository.findByPhoneNum(phone);
        LoginReturn loginReturn = new LoginReturn();
        User loginUser = userRepository.findByPhoneNumAndPassword(phone, password);

        //用户名不存在
        if (userPhone == null){

            loginReturn.setCode(1);
            loginReturn.setMsg("用户不存在");
            return loginReturn;

        }
        //密码不正确
         if (loginUser == null && userPhone != null){
            loginReturn.setCode(2);
            loginReturn.setMsg("密码错误");
            return loginReturn;
        }
        //登录正确
        if (loginUser != null && userPhone != null) {
            loginReturn.setCode(0);
            loginReturn.setMsg("登录成功");
            loginReturn.setData(new LoginData(loginUser.getId()));
        }

        //User loginUser = userRepository.findByUsernameAndPassword(userReq.getUsername(), userReq.getPassword());
        //User user = null;
        //user = userService.findUserByUsernameAndPassword(userReq.getUsername(), userReq.getPassword());
       // System.out.println(loginUser.getId());
        return loginReturn;
        //return loginUser;
    }

    /**
     * 查询课程表获取用户列表
     * @param courseid 课程id
     *
     * @return
     */
    @GetMapping
    public User getUserFromCourse(@RequestParam(value = "course_id") Integer courseid){


        return null;
    }

    /**单元测试完成
     *
     *
     * 10用户信息查询：
     * 编写人：卢芮
     * 日期：2020/10/22
     * @param id 传入id
     * @return 学生信息类
     */
    @GetMapping("/getuserinfo")
    public UserInfoReturn getUserInfo(@RequestParam(value = "user_id") Integer id){

        Optional<User> byId = userRepository.findById(id);
        //User user = userRepository.findById(id).get();
        UserInfoReturn userTypeReturn = new UserInfoReturn();
        if (byId == null || !byId.isPresent()){
            //查询失败
            userTypeReturn.setCode(1);
            userTypeReturn.setMsg("用户信息获取失败");
            return userTypeReturn;
        }
        else  {
            //查询成功
            User user = byId.get();
            UserSchool userSchool = new UserSchool();
            School school = schoolRepository.findById(user.getSchool_id()).get();
            BeanUtils.copyProperties(user,userSchool);
            userSchool.setSchool_name(school.getSchool_name());
            userSchool.setPhone_num(user.getPhoneNum());
            userTypeReturn.setCode(0);
            userTypeReturn.setMsg("用户信息获取成功");
            userTypeReturn.setData(userSchool);
            return userTypeReturn;
        }



    }

    /**单元测试完成
     *
     *
     *5根据id查询用户类型：
     * 编写人：卢芮
     * 日期：2020/10/22
     * @param id
     * @return
     */
    @GetMapping("/usertype")
    public UserTypeReturn getUserTypeByID(@RequestParam(value = "id") Integer id){
        UserTypeReturn userTypeReturn = new UserTypeReturn();
        Optional<User> byId = userRepository.findById(id);


        if (byId == null || !byId.isPresent()){
            //查询失败
            userTypeReturn.setCode(1);
            userTypeReturn.setMsg("用户信息获取失败");
            return userTypeReturn;
        }

        if (byId != null){
            User user = byId.get();
            //有此用户
            userTypeReturn.setCode(0);
            userTypeReturn.setMsg("用户信息获取成功");
            User userForReturn = new User();
            userForReturn.setUser_type(user.getUser_type());
            userTypeReturn.setData(userForReturn);
            return userTypeReturn;
        }

        return userTypeReturn;
    }

    /**单元测试完成
     *
     *
     *14用户注册：
     * 编写人：卢芮
     * 日期：2020/10/22
     * @param
     * @return
     */
    @PostMapping("/register")
    public MsgReturn registerUser(@RequestBody Regreq user){


        MsgReturn msgReturn = new MsgReturn();
        User userReq = new User();
        BeanUtils.copyProperties(user,userReq);
        userReq.setPhoneNum(user.getPhone_num());
        //用户名已经存在
        if (userRepository.findByUsername(userReq.getUsername()) != null){

            //返回的user对象的id设置为-1 ，目前并没有进行异常捕捉
            //User error_user = new User();
            //error_user.setId(USERALREADYEXIST);
            msgReturn.setCode(1);
            msgReturn.setMsg("用户注册失败");
            return msgReturn;
        }
        //进行注册
        else {
            User user_success = userRepository.save(userReq);
            msgReturn.setCode(0);
            msgReturn.setMsg("用户注册成功");
            return msgReturn;
        }
    }

    /**单元测试完成
     *
     * 编写人：卢芮
     * 日期：2020/10/22
     * 16学校查询：
     * @return
     */
    @GetMapping("/getallschool")
    public AllSchoolReturn findAllSchoolInfo(){
        List<School> allByIdExists = schoolRepository.findAllByIdAfter(0);
        AllSchoolReturn allSchoolReturn = new AllSchoolReturn();
        if (allSchoolReturn != null){
            //查询成功
            allSchoolReturn.setCode(0);
            allSchoolReturn.setMsg("学校信息获取成功");
            allSchoolReturn.setData(allByIdExists);
            return allSchoolReturn;
        }
        else {
            //查询失败
            allSchoolReturn.setCode(1);
            allSchoolReturn.setMsg("学校信息获取失败");
            return allSchoolReturn;
        }
    }

    /**
     * 获取用户信息
     * @param userReq
     * @return
     */
    @GetMapping("/getmessage")
    public User getUserMessage(@RequestBody User userReq){

        return userRepository.findById(userReq.getId()).get();

    }

    /**
     * ！！！还未完成 还需前端沟通接口
     * 修改用户信息  ！！！
     * @param userReq 修改用户信息类
     * @return
     */
    @PostMapping("/modifyuser")
    public User modifyUser(@RequestBody User userReq){

        User userInDB = userRepository.findById(userReq.getId()).get();

        //复制属性
        BeanUtils.copyProperties(userReq,userInDB);

        //再次保存
        userRepository.save(userInDB);

        return userInDB;
    }


    /**3获取用户列表：
     *
     * 编写人：卢芮
     * 日期：2020/10/19

     * @param courseID 课程id
     * 根据传入id寻找该课程用户信息用户
     * @return 课程信息
     */
    @GetMapping("/getuserbycourseid")
    public CourseUserReturn getInfomation(@RequestParam(value = "course_id") Integer courseID){

        //查询
        List<UserCourse> byCourseId = userCourseRepository.findByCourseId(courseID);

        CourseUserReturn courseUserReturn = new CourseUserReturn();
        List<CourseUserData> courseUserDataList = new ArrayList<>();

        if (byCourseId == null){
            //查询失败
            courseUserReturn.setCode(1);
            courseUserReturn.setMsg("用户列表获取失败");
            return courseUserReturn;
        }


        for (UserCourse userCourse : byCourseId) {

            User user = userRepository.findUserById(userCourse.getUserId());
            CourseUserData courseUser = new CourseUserData();
            courseUser.setUser_id(user.getId());
            courseUser.setUsername(user.getUsername());

            courseUserDataList.add(courseUser);

        }

        if (byCourseId != null){
            //查找成功
            courseUserReturn.setCode(0);
            courseUserReturn.setMsg("用户列表获取成功");
            courseUserReturn.setData(courseUserDataList);

            return courseUserReturn;
        }

        return courseUserReturn;
    }
}
