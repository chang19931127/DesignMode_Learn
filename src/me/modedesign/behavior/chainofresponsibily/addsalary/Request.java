package me.modedesign.behavior.chainofresponsibily.addsalary;

/**
 * 
 * @author 43994897
 *	请求类
 */
public class Request {
	private String requestType;//请求类型
	private String requestContent;//请求内容
	private int number;//数量
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getRequestContent() {
		return requestContent;
	}
	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
