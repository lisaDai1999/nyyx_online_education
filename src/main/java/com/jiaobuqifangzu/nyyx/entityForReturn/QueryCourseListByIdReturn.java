/**
 * 
 */
package com.jiaobuqifangzu.nyyx.entityForReturn;

import java.util.List;

import com.jiaobuqifangzu.nyyx.domain.Course;

/**
* 
* 
* @param 
* @return 
* 编写人: 戴礼霞
* 日期： 2020年10月24日 下午12:14:18
* 输入说明：
* 输出说明：
* 功能简述：
**/
/**
 * @author Lixia Dai
 * @date 2020年10月24日 下午12:14:18
 */
public class QueryCourseListByIdReturn {

	private int code;
	private String msg;
	private List<CourseInfoByIdRetrun> data;
	
	public QueryCourseListByIdReturn() {
		
	}
	
	public QueryCourseListByIdReturn(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public QueryCourseListByIdReturn(int code, String msg, List<CourseInfoByIdRetrun> data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<CourseInfoByIdRetrun> getData() {
		return data;
	}

	public void setData(List<CourseInfoByIdRetrun> data) {
		this.data = data;
	}
	
}
