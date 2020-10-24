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
* 日期： 2020年10月22日 下午8:41:19
* 输入说明：
* 输出说明：
* 功能简述：
**/
/**
 * @author Lixia Dai
 * @date 2020年10月22日 下午8:41:19
 */
public class MsgReturn {

	private int code;//返回代码：0为成功  1为失败
	private String msg;//返回信息
	
	public MsgReturn() {
		
	}
	
	public MsgReturn(int code, String msg) {
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

}
