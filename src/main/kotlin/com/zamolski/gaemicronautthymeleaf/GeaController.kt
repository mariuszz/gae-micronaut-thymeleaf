package com.zamolski.gaemicronautthymeleaf

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.slf4j.LoggerFactory
@Controller
class GeaController {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Get("/_ah/warmup")
    fun warmup(): HttpResponse<Boolean> {
        logger.info("warmup done")
        return HttpResponse.ok(true)
    }

}