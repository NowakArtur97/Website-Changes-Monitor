package com.nowakartur.websitechangesmonitor.monitor

import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

class WebsiteDataLoader(
    private val websiteEntityRepository: WebsiteEntityRepository
) {

    private val logger = LoggerFactory.getLogger(WebsiteDataLoader::class.java)

    @EventListener(ApplicationReadyEvent::class)
    fun prepareDataOnStartup() {
        val websites: List<WebsiteEntity> = listOf(
            WebsiteEntity("https://anitaku.pe/home.html", ".name", 0),
            WebsiteEntity("https://nyaa.si/?f=0&c=3_1&q=J-Novel+Club", "td a", 1),
            WebsiteEntity("https://jnovels.com/", ".post-title", 4),
            WebsiteEntity("http://www.vn-meido.com/k1/index.php?board=17.0", ".preview a", 4),
        )
    }
}
