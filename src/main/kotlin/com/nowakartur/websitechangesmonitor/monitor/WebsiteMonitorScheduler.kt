package com.nowakartur.websitechangesmonitor.monitor

import org.jsoup.Jsoup
import org.springframework.scheduling.annotation.Scheduled
import java.util.concurrent.TimeUnit

class WebsiteMonitorScheduler(private val websiteService: WebsiteService) {

    @Scheduled(
        initialDelayString = "\${app.scheduler.monitor.initial-delay-minutes}",
        fixedDelayString = "\${app.scheduler.monitor.fixed-delay-minutes}",
        timeUnit = TimeUnit.MINUTES
    )
    fun monitorWebsites() {
        websiteService.findAll()
            .forEach {
                val newValue = Jsoup.connect(it.url)
                    .get()
                    .select(it.cssSelector)[it.elementIndex]
                    .text()
                if (newValue.isNotBlank() && newValue != it.currentValue) {
                    websiteService.updateCurrentValue(it, newValue)
                }
            }
    }
}
