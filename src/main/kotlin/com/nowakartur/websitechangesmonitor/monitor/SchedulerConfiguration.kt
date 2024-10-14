package com.nowakartur.websitechangesmonitor.monitor

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@Configuration
@EnableScheduling
@ConditionalOnProperty(value = ["app.scheduler.enabled"], havingValue = "true", matchIfMissing = true)
class SchedulerConfiguration {

    @Bean
    fun websiteMonitorScheduler(websiteService: WebsiteService): WebsiteMonitorScheduler =
        WebsiteMonitorScheduler(websiteService)
}
