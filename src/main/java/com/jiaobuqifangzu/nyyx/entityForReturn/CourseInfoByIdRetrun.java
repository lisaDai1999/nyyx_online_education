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
* 日期： 2020年10月24日 下午12:18:58
* 输入说明：
* 输出说明：
* 功能简述：
**/
/**
 * @author Lixia Dai
 * @date 2020年10月24日 下午12:18:58
 */
public class CourseInfoByIdRetrun {

	private int id;
	private String cover_route;
	private String course_name;
	private String brief_introduction;
	private int course_student_num;
	
	public CourseInfoByIdRetrun() {
		
	}
	
	public CourseInfoByIdRetrun(int id, String cover_route, 
			String course_name, String brief_introduction, int course_student_num) {
		this.id = id;
		this.cover_route = cover_route;
		this.course_name = course_name;
		this.brief_introduction = brief_introduction;
		this.course_student_num = course_student_num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCover_route() {
		return cover_route;
	}

	public void setCover_route(String cover_route) {
		this.cover_route = cover_route;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getBrief_introduction() {
		return brief_introduction;
	}

	public void setBrief_introduction(String brief_introduction) {
		this.brief_introduction = brief_introduction;
	}

	public int getCourse_student_num() {
		return course_student_num;
	}

	public void setCourse_student_num(int course_student_num) {
		this.course_student_num = course_student_num;
	}

}
