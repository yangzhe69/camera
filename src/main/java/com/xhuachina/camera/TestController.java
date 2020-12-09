package com.xhuachina.camera;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("camera")
public class TestController {

    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 回去监控设备列表
     */
    @PostMapping("/getCameraList")
    public String getCameraList(@RequestParam Map<String, Object> params) {

        String pageNo = (String) params.get("pageNo");
        String pageSize = (String) params.get("pageSize");

        /**
         * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
         */
        // 代理API网关nginx服务器ip端口

//        ArtemisConfig.host = "172.16.97.127";
//        // 秘钥appkey
//        ArtemisConfig.appKey = "22197261";
//        // 秘钥appSecret
//        ArtemisConfig.appSecret = "qkdjw31hRIpguWX8goNt";
//

        /**
         * STEP2：设置OpenAPI接口的上下文
         */
        final String ARTEMIS_PATH = "/artemis";
        /**
         * STEP3：设置接口的URI地址
         */
        final String previewURLsApi = ARTEMIS_PATH + "/api/resource/v1/camera/advance/cameraList";
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                //根据现场环境部署确认是http还是https
                put("https://", previewURLsApi);
            }
        };
        logger.info(path.toString());
        /**
         * STEP4：设置参数提交方式
         */
        String contentType = "application/json";
        /**
         * STEP5：组装请求参数
         */
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("pageNo", pageNo);
        jsonBody.put("pageSize", pageSize);
        String body = jsonBody.toJSONString();
        logger.info(body);
        /**
         * STEP6：调用接口
         */
        // post请求application/json类型参数
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null,
                contentType, null);

        return result;
    }


    /**
     * 获取设备直播刘地址
     */
    @PostMapping("/GetCameraStatus")
    public String GetCameraStatus(@RequestParam Map<String, Object> params) {

        String pageNo = (String) params.get("pageNo");
        String pageSize = (String) params.get("pageSize");

        /**
         * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
         */
        // 代理API网关nginx服务器ip端口

        ArtemisConfig.host = "172.16.97.127";
        // 秘钥appkey
        ArtemisConfig.appKey = "22197261";
        // 秘钥appSecret
        ArtemisConfig.appSecret = "qkdjw31hRIpguWX8goNt";
        /**
         * STEP2：设置OpenAPI接口的上下文
         */
        final String ARTEMIS_PATH = "/artemis";


        // STEP3：设置接口的URI地址
        final String previewURLsApi = ARTEMIS_PATH +
                "/api/nms/v1/online/camera/get";
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                //根据现场环境部署确认是http还是https
                put("https://", previewURLsApi);
            }
        };
        logger.info(path.toString());
        /**
         * STEP4：设置参数提交方式
         */
        String contentType = "application/json";

        /**
         * STEP5：组装请求参数
         */
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("pageNo", pageNo);
        jsonBody.put("pageSize", pageSize);
        String body = jsonBody.toJSONString();
        logger.info(body);
        /**
         * STEP6：调用接口
         */
        // post请求application/json类型参数
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null,
                contentType, null);
        return result;

    }

    /**
     * 获取设备直播刘地址
     */
    @PostMapping("/GetCameraPreviewURL")
    public String GetCameraPreviewURL(@RequestParam Map<String, Object> params) {

        //设备监控点唯一标识集
        String cameraIndexCode = (String) params.get("cameraIndexCode");
        //协议
        String protocol = (String) params.get("protocol");

        /**
         * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
         */
        // 代理API网关nginx服务器ip端口

//        ArtemisConfig.host = "172.16.97.127";
//        // 秘钥appkey
//        ArtemisConfig.appKey = "22197261";
//        // 秘钥appSecret
//        ArtemisConfig.appSecret = "qkdjw31hRIpguWX8goNt";

        /**
         * STEP2：设置OpenAPI接口的上下文
         */
        final String ARTEMIS_PATH = "/artemis";


        // STEP3：设置接口的URI地址
        final String previewURLsApi = ARTEMIS_PATH +
                "/api/video/v1/cameras/previewURLs";
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                //根据现场环境部署确认是http还是https
                put("https://", previewURLsApi);
            }
        };
        logger.info(path.toString());
        /**
         * STEP4：设置参数提交方式
         */
        String contentType = "application/json";

        /**
         * STEP5：组装请求参数
         */
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("cameraIndexCode", cameraIndexCode);
        jsonBody.put("streamType", 0);
        jsonBody.put("protocol", protocol);
        jsonBody.put("transmode", 1);
        jsonBody.put("expand", "streamform=ps");
        String body = jsonBody.toJSONString();
        logger.info(body);
        /**
         * STEP6：调用接口
         */
        // post请求application/json类型参数
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null,
                contentType, null);
        return result;

    }

    /**
     * 获取监控点回放取流URL
     */
    @PostMapping("/playbackURLs")
    public String playbackURLs(@RequestParam Map<String, Object> params) {

        //设备监控点唯一标识集
        String cameraIndexCode = (String) params.get("cameraIndexCode");
        //协议
//        String protocol = (String) params.get("protocol");
        String beginTime = (String) params.get("beginTime");
        String endTime = (String) params.get("endTime");

        /**
         * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
         */
        // 代理API网关nginx服务器ip端口
        ArtemisConfig.host = "172.16.97.127";
        // 秘钥appkey
        ArtemisConfig.appKey = "22197261";
        // 秘钥appSecret
        ArtemisConfig.appSecret = "qkdjw31hRIpguWX8goNt";
        /**
         * STEP2：设置OpenAPI接口的上下文
         */
        final String ARTEMIS_PATH = "/artemis";


        // STEP3：设置接口的URI地址
        final String previewURLsApi = ARTEMIS_PATH +
                "/api/video/v1/cameras/playbackURLs";
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                //根据现场环境部署确认是http还是https
                put("https://", previewURLsApi);
            }
        };
        logger.info(path.toString());
        /**
         * STEP4：设置参数提交方式
         */
        String contentType = "application/json";

        /**
         * STEP5：组装请求参数
         */
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("cameraIndexCode", cameraIndexCode);
        jsonBody.put("beginTime", beginTime);
        jsonBody.put("endTime", endTime);
        String body = jsonBody.toJSONString();
        logger.info(body);
        /**
         * STEP6：调用接口
         */
        // post请求application/json类型参数
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null,
                contentType, null);
        return result;

    }


    /**
     * 手动开启回放
     */
    @PostMapping("/startVideo")
    public String startVideo(@RequestParam Map<String, Object> params) {

        //设备监控点唯一标识集
        String cameraIndexCode = (String) params.get("cameraIndexCode");
        //协议
      String recordType = (String) params.get("recordType");


        /**
         * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
         */
        // 代理API网关nginx服务器ip端口
        ArtemisConfig.host = "172.16.97.127";
        // 秘钥appkey
        ArtemisConfig.appKey = "22197261";
        // 秘钥appSecret
        ArtemisConfig.appSecret = "qkdjw31hRIpguWX8goNt";
        /**
         * STEP2：设置OpenAPI接口的上下文
         */
        final String ARTEMIS_PATH = "/artemis";


        // STEP3：设置接口的URI地址
        final String previewURLsApi = ARTEMIS_PATH +
                "/api/video/v1/manualRecord/start";
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                //根据现场环境部署确认是http还是https
                put("https://", previewURLsApi);
            }
        };
        logger.info(path.toString());
        /**
         * STEP4：设置参数提交方式
         */
        String contentType = "application/json";

        /**
         * STEP5：组装请求参数
         */
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("cameraIndexCode", cameraIndexCode);
        jsonBody.put("recordType", recordType);
        String body = jsonBody.toJSONString();
        logger.info(body);
        /**
         * STEP6：调用接口
         */
        // post请求application/json类型参数
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null,
                contentType, null);
        return result;
    }


    /**
     * 手动关闭回放
     */
    @PostMapping("/stopVideo")
    public String stopVideo(@RequestParam Map<String, Object> params) {

        //设备监控点唯一标识集
        String cameraIndexCode = (String) params.get("cameraIndexCode");
        //协议
      String taskID = (String) params.get("taskID");


        /**
         * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
         */
        // 代理API网关nginx服务器ip端口
        ArtemisConfig.host = "172.16.97.127";
        // 秘钥appkey
        ArtemisConfig.appKey = "22197261";
        // 秘钥appSecret
        ArtemisConfig.appSecret = "qkdjw31hRIpguWX8goNt";
        /**
         * STEP2：设置OpenAPI接口的上下文
         */
        final String ARTEMIS_PATH = "/artemis";


        // STEP3：设置接口的URI地址
        final String previewURLsApi = ARTEMIS_PATH + "/api/video/v1/manualRecord/stop";
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                //根据现场环境部署确认是http还是https
                put("https://", previewURLsApi);
            }
        };
        logger.info(path.toString());
        /**
         * STEP4：设置参数提交方式
         */
        String contentType = "application/json";

        /**
         * STEP5：组装请求参数
         */
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("cameraIndexCode", cameraIndexCode);
        jsonBody.put("taskID", taskID);
        String body = jsonBody.toJSONString();
        logger.info(body);
        /**
         * STEP6：调用接口
         */
        // post请求application/json类型参数
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null,
                contentType, null);
        return result;
    }


}
