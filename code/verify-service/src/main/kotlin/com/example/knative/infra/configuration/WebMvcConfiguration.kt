package com.example.knative.infra.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
class WebMvcConfiguration : WebMvcConfigurerAdapter() {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/")
        }
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(*CLASSPATH_RESOURCE_LOCATIONS)
        }
    }

    companion object {
        private val CLASSPATH_RESOURCE_LOCATIONS = arrayOf("classpath:/META-INF/resources/",
                "classpath:/resources/", "classpath:/static/", "classpath:/public/", "classpath:/")
    }

}