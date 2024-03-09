package com.medeiros.reservation.configs;

import com.medeiros.reservation.utils.TimeProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimeProviderConfiguration {

  @Bean
  public TimeProvider timeProvider() {
    return TimeProvider.getInstance();
  }
}
