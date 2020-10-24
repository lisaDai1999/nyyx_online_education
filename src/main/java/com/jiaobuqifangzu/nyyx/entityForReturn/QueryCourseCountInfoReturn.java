/**
 * 
 */
package com.jiaobuqifangzu.nyyx.entityForReturn;


import com.jiaobuqifangzu.nyyx.entityForReturn.CourseCountInfoReturn;

/**
* 
* 
* @param 
* @return 
* 编写人: 戴礼霞
* 日期： 2020年10月24日 下午12:53:59
* 输入说明：
* 输出说明：
* 功能简述：
**/
/**
 * @author Lixia Dai
 * @date 2020年10月24日 下午12:53:59
 */
public class QueryCourseCountInfoReturn {

	private int code;
	private String msg;
	private CourseCountInfoReturn data;
	
	public QueryCourseCountInfoReturn()
	{
		
	}
	
	public QueryCourseCountInfoReturn(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public QueryCourseCountInfoReturn(int code, String msg, CourseCountInfoReturn data) {
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

	public CourseCountInfoReturn getData() {
		return data;
	}

	public void setData(CourseCountInfoReturn data) {
		this.data = data;
	}
	
	
}
