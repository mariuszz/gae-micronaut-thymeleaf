package com.zamolski.gaemicronautthymeleaf

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.views.View
import org.slf4j.LoggerFactory

@Controller
class IndexController {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Get("/")
    @View("index")
    fun index(): HttpResponse<Map<String, Any>> {
        logger.info("index page")
        return HttpResponse.ok(mapOf(
            "title" to "GAE MICRONAUT THYMELEAF",
            "something" to Something(1, "first"),
            "env_variables" to System.getenv()
        ))
    }
}