/**
 * 
 */
package com.jiaobuqifangzu.nyyx.entityForReturn;
/**
* 
* 
* @param 
* @return 
* 编写人: 戴礼霞
* 日期： 2020年10月22日 下午9:50:15
* 输入说明：
* 输出说明：
* 功能简述：
**/
/**
 * @author Lixia Dai
 * @date 2020年10月22日 下午9:50:15
 */
public class CourseReturn {
	
	 /**
	  * data：查询成功时返回的数据，
	  * 	id：课程id
	  * 	course_name：课程名
	  * 	cover_route：课程封面路径
	  * 	brief_introduction：课程简介
	  * 	teacher：课程教师
    */
	
	private int id;
	private String course_name;
	private String cover_route;
	private String brief_introduction;
	private String teacher;
	
	public CourseReturn() {
		
	}
	
	public CourseReturn(int id, String course_name, String cover_route, String brief_introduction, String teacher) {
		this.id = id;
		this.course_name = course_name;
		this.cover_route = cover_route;
		this.brief_introduction = brief_introduction;
		this.teacher = teacher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCover_route() {
		return cover_route;
	}

	public void setCover_route(String cover_route) {
		this.cover_route = cover_route;
	}

	public String getBrief_introduction() {
		return brief_introduction;
	}

	public void setBrief_introduction(String brief_introduction) {
		this.brief_introduction = brief_introduction;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
}
