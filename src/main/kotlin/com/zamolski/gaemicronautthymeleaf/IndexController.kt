package com.zamolski.gaemicronautthymeleaf

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.views.View

@Controller
class IndexController {

    @Get("/")
    @View("index")
    fun index(): HttpResponse<Map<String, Any>> {
        return HttpResponse.ok(mapOf(
            "title" to "GAE MICRONAUT THYMELEAF",
            "something" to Something(1, "first")
        ))
    }
}