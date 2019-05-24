package cn.shafish.cicada.sms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import cn.shafish.cicada.util.Utils;

public class AliSMS {
	
	public static String getSMS(String phone){
        DefaultProfile profile = DefaultProfile.getProfile("cicada", "LTAIBZO9XVmZVmBj", "wlddrZ1z1z4TVASVzd654uxMh3tHSr");
        IAcsClient client = new DefaultAcsClient(profile);
        String num = Utils.getRandomNumCode(7);
        String message = "";
        
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cicada");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "知了应用");
        request.putQueryParameter("TemplateCode", "SMS_162521078");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+num+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            //System.out.println(response.getData());
            JSONObject jsonx = JSON.parseObject(response.getData());
            message = jsonx.getString("Message");
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return  message +","+ num;
   }
}
