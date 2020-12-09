package com.xhuachina.config;


import com.xhuachina.config.Constants;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SettingConfig implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {

        Constants.initArtemisConfig();
    }
}