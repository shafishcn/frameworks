package cn.shafish.cicada.util;

import java.util.Date;

import lombok.Data;
import java.io.Serializable;
import java.text.SimpleDateFormat;

@Data
public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = -4699713095477151086L;

    private T data;									//传输数据
    private String msg;                           	//响应状态描述  
	private String code;                            //响应状态码 
	private String time = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());       //时间戳 
	
    public JsonResult() {
        super();
    }
	
	public JsonResult(T data,String msg,String code) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
 

    public JsonResult(T data, String msg) {
        this.data = data;
        this.msg = msg;
        this.code = StatusCode.CODE_SUCCESS;
    }
 
    public JsonResult(T data) {
        this.data = data;
        this.code = StatusCode.CODE_SUCCESS;
    }
    
    public JsonResult(String msg) {
        this.msg = msg;
    }
	/*
	 * public void setStatusObject(StatusObject statusObject) { this.code =
	 * statusObject.getCode(); this.msg = statusObject.getMsg(); }
	 */
}