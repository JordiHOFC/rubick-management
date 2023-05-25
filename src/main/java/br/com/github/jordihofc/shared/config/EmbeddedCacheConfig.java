package br.com.github.jordihofc.shared.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddedCacheConfig {
    @Value("${cache.name}")
    private String cacheName;
    private final int FOUR_HOURS = 14400;// 4 horas

    @Bean
    Config config() {
        Config config = new Config();

        MapConfig mapConfig = new MapConfig();
        mapConfig.setTimeToLiveSeconds(FOUR_HOURS);

        config.getMapConfigs()
                .put(cacheName, mapConfig);

        return config;
    }
}
