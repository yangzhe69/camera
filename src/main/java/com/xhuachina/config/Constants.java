package com.xhuachina.config;

import com.hikvision.artemis.sdk.config.ArtemisConfig;


public class Constants {

    public static void initArtemisConfig(){
        /**
         * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
         */
        // 代理API网关nginx服务器ip端口
        ArtemisConfig.host = "172.16.97.127";
        // 秘钥appkey
        ArtemisConfig.appKey = "22197261";
        // 秘钥appSecret
        ArtemisConfig.appSecret = "qkdjw31hRIpguWX8goNt";

    }
}
