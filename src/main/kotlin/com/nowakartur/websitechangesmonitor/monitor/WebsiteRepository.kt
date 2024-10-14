package com.nowakartur.websitechangesmonitor.monitor

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface WebsiteRepository : JpaRepository<WebsiteEntity, UUID> {
    fun existsByUrl(url: String): Boolean
}
