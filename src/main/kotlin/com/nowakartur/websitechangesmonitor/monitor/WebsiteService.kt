package com.nowakartur.websitechangesmonitor.monitor

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class WebsiteService(private val websiteRepository: WebsiteRepository) {

    private val logger = LoggerFactory.getLogger(WebsiteService::class.java)

    fun notExistsByUrl(url: String): Boolean = !websiteRepository.existsByUrl(url)

    fun findAll(): List<WebsiteEntity> = websiteRepository.findAll()

    fun saveAll(websites: List<WebsiteEntity>) {
        if (websites.isEmpty()) {
            return
        }
        websiteRepository.saveAll(websites)
        logger.info("Saved websites: {}", websites)
    }

    fun updateCurrentValue(website: WebsiteEntity, newValue: String) {
        website.currentValue = newValue
        websiteRepository.save(website)
        logger.info("Update value for website: {} with value: {}", website.url, newValue)
    }
}
