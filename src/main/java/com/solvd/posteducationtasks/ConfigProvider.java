package com.solvd.posteducationtasks;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("test.conf");
    }

    String URL = readConfig().getString("url");
    String USER1_EMAIL = readConfig().getString("userParams.user1.email");
    String USER1_PASSWORD = readConfig().getString("userParams.user1.password");
    String USER2_EMAIL = readConfig().getString("userParams.user2.email");
    String USER2_PASSWORD = readConfig().getString("userParams.user2.password");
}
