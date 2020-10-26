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
* 日期： 2020年10月22日 下午10:57:08
* 输入说明：
* 输出说明：
* 功能简述：
**/
/**
 * @author Lixia Dai
 * @date 2020年10月22日 下午10:57:08
 */
public class CourseListReturn {
    /**
     * code：整型数据，返回的代码，
     * 0为查询成功
     * 1为查询失败
     * msg：字符串，code对应的说明，
     * code == 0，“获取成功”
     * code == 1，“获取失败”
     */
	
	private int code;
	private String msg;
	private List<CourseReturn> data;
	
	public CourseListReturn() {
		
	}
	
	public CourseListReturn(int code, String msg) {
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
