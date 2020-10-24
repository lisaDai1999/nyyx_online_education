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
* 日期： 2020年10月24日 下午12:58:17
* 输入说明：
* 输出说明：
* 功能简述：
**/
/**
 * @author Lixia Dai
 * @date 2020年10月24日 下午12:58:17
 */
public class CourseCountInfoReturn {
	/**
	* data：查询成功时返回的数据，
	* 		cover_route：课程封面路径
	* 		course_name：课程名
	* 		brief_introduction：课程简介
	* 		teacher_id：教师id
	* 		teacher_name：教师名
	* 		student_count：查询user_course表，统计选了该课的用户数
	*/

	private String cover_route;
	private String course_name;
	private String brief_introduction;
	private int teacher_id;
	private String teacher_name;
	private int student_count;
	
	public CourseCountInfoReturn() {
		
	}
	
	public CourseCountInfoReturn(String cover_route, String course_name, String brief_introduction, 
			int teacher_id, String teacher_name, int student_count) {
		this.cover_route = cover_route;
		this.course_name = course_name;
		this.brief_introduction = brief_introduction;
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.student_count = student_count;
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

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public int getStudent_count() {
		return student_count;
	}

	public void setStudent_count(int student_count) {
		this.student_count = student_count;
	}
}
