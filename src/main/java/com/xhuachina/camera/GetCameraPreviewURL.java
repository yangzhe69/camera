package com.xhuachina.camera;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import java.util.HashMap;
import java.util.Map;

public class GetCameraPreviewURL {

    public static String GetCameraPreviewURL() {



/**
 * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
 */
//        ArtemisConfig.host = "10.19.132.3:443"; // artemis网关服务器ip端口
//        ArtemisConfig.appKey = "29180881"; // 秘钥appkey
//        ArtemisConfig.appSecret = "XO0wCAYGi4KV70ybjznx";// 秘钥appSecret
        ArtemisConfig.host = "172.16.97.127";// 代理API网关nginx服务器ip端口
        ArtemisConfig.appKey = "22197261";// 秘钥appkey
        ArtemisConfig.appSecret = "qkdjw31hRIpguWX8goNt";// 秘钥appSecret

/**
 * STEP2：设置OpenAPI接口的上下文
 */
        final String ARTEMIS_PATH = "/artemis";

/**
 * STEP3：设置接口的URI地址
 */
        final String previewURLsApi = ARTEMIS_PATH +
                "/api/video/v1/cameras/previewURLs";
        Map <String, String> path = new HashMap <String, String>(2) {
            {
                put("https://", previewURLsApi);//根据现场环境部署确认是http还是https
            }
        };

/**
 * STEP4：设置参数提交方式
 */
        String contentType = "application/json";

/**
 * STEP5：组装请求参数
 */
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("cameraIndexCode", "6af5a6c33e3a4e3ea4c0ad820117db12");
        jsonBody.put("streamType", 0);
        jsonBody.put("protocol", "rtsp");
//        jsonBody.put("protocol", "hls");
        jsonBody.put("transmode", 1);
        jsonBody.put("expand", "streamform=ps");
        String body = jsonBody.toJSONString();

/**
 * STEP6：调用接口
 */
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null,
                contentType , null);// post请求application/json类型参数
        return result;
    }


    public static String GetCameraList() {


    /**
     * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
     */
        ArtemisConfig.host = "172.16.97.127";// 代理API网关nginx服务器ip端口
        ArtemisConfig.appKey = "22197261";// 秘钥appkey
        ArtemisConfig.appSecret = "qkdjw31hRIpguWX8goNt";// 秘钥appSecret

    /**
     * STEP2：设置OpenAPI接口的上下文
     */
        final String ARTEMIS_PATH = "/artemis";

    /**
     * STEP3：设置接口的URI地址
     */
        final String previewURLsApi = ARTEMIS_PATH + "/api/resource/v1/camera/advance/cameraList";
        Map <String, String> path = new HashMap <String, String>(2) {
            {
                put("https://", previewURLsApi);//根据现场环境部署确认是http还是https
            }
        };

/**
 * STEP4：设置参数提交方式
 */
        String contentType = "application/json";

/**
 * STEP5：组装请求参数
 */
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("pageNo", 1);
        jsonBody.put("pageSize", 100);
        String body = jsonBody.toJSONString();

/**
 * STEP6：调用接口
 */
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null,
                contentType , null);// post请求application/json类型参数
        return result;
    }


    public static void main(String[] args) {
        String result = GetCameraPreviewURL();
//        String result = GetCameraList();
        System.out.println("result结果示例: " + result);

    }

}