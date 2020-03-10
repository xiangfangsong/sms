package com.vlogplusplus.controller;

import com.vlogplusplus.entity.Sms;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/sms")
public class SmsController {
    @RequestMapping(value = "/sendCode", method = RequestMethod.POST)
    public void sendCode(@RequestBody Sms sms){
        int appid = 1000000003;
        String appkey = "";
        int templateId = 123456; //模板ID
        String smsSign = "CNXFS";
        try{
            String[] params = {sms.getCode(), Integer.toString(sms.getMin())}; //短信中的参数
            SmsSingleSender ssender = new SmsSingleSender(appid,appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86",sms.getPhoneNumber(),templateId,
                    params,smsSign,"","");
            System.out.println(result);
        }catch (HTTPException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
