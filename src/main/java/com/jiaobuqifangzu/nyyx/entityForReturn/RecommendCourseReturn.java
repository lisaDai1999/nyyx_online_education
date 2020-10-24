/**
 * 
 */
package com.jiaobuqifangzu.nyyx.entityForReturn;

import java.util.List;

/**
* 
* 
* @param 
* @return 
* 编写人: 戴礼霞
* 日期： 2020年10月22日 下午10:36:59
* 输入说明：
* 输出说明：
* 功能简述：
**/
/**
 * @author Lixia Dai
 * @date 2020年10月22日 下午10:36:59
 */
public class RecommendCourseReturn {

	private int code;
	private String msg;
	private List<CourseReturn> data;
	
	public RecommendCourseReturn() {
		
	}
	
	public RecommendCourseReturn(int code, String msg) {
		this.code = code;
		this.msg = msg;
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

	public List<CourseReturn> getData() {
		return data;
	}

	public void setData(List<CourseReturn> data) {
		this.data = data;
	}
	
	
}
