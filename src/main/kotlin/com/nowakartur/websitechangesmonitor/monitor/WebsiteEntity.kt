package com.nowakartur.websitechangesmonitor.monitor

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "website")
data class WebsiteEntity(
    @Column(name = "url", nullable = false, unique = true)
    val url: String,
    @Column(name = "css_selector", nullable = false)
    val cssSelector: String,
    @Column(name = "element_index", nullable = false)
    val elementIndex: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private val id: Long = 0

    @Column(name = "current_value", nullable = false)
    val currentValue: String = ""
}
