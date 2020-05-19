package org.example.util;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author TMK
 * date 2020/5/19 - 16:34
 */
public class baiduAIP {
    //设置APPID/AK/SK
    private static final String APP_ID = "19954294";
    private static final String API_KEY = "xL1oBhhDDP33PVU6Vs02wXat";
    private static final String SECRET_KEY = "UW09WVIeHtQZ8P7yXVNUKQckcPhxVivM";

    public static AipNlp getAipNlp(){
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
/*        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理*/
        return client;
    }
    public static void main(String[] args) {
        AipNlp aipNlp = baiduAIP.getAipNlp();
        // 调用接口
        String text1 = "你好先生，我是TMK";
        String text2 = "你好先生，我是MACK，来自纽约";
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("model", "CNN");
        JSONObject res = aipNlp.simnet(text1, text2, options);
        System.out.println(res.toString(1));

    }
}
