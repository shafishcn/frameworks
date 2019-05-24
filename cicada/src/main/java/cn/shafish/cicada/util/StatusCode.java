package cn.shafish.cicada.util;

public class StatusCode {
	public static String CODE_SUCCESS = "ok";          //访问成功 
	 
	public static String CODE_ERROR = "error";          //访问错误 
 
	public static String CODE_ERROR_PARAMETER = "01";	//参数错误
 
	public static String CODE_ERROR_PROGRAM = "02";  	//程序异常
 
	public static String CODE_ERROR_NO_LOGIN_OR_TIMEOUT = "03";  //未登录或登录超时,请重新登录 
 
	public static String CODE_ERROR_EXIST_OPERATION = "04";      //已操作
}
