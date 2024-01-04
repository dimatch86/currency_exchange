package ru.skillbox.currency.exchange.configuration;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }
}
