package com.zamolski.gaemicronautthymeleaf

import io.micronaut.runtime.event.ApplicationShutdownEvent
import io.micronaut.runtime.event.ApplicationStartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class ApplicationService {

    private val logger = LoggerFactory.getLogger(javaClass)

    @EventListener
    fun onStartupEvent(event: ApplicationStartupEvent) {
        logger.info("Application started")
    }
    @EventListener
    fun onShutdownEvent(event: ApplicationShutdownEvent) {
        logger.info("Application stopped")
    }
}