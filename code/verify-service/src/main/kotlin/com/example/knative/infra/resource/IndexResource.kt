package com.example.knative.infra.resource

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/")
class IndexResource {

    @GetMapping
    fun index(): ModelAndView {
        return ModelAndView("index")
    }

}