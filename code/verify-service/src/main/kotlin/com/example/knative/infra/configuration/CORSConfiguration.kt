package com.example.knative.infra.configuration

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
class CORSConfiguration {

    @Bean
    fun corsFilter(): FilterRegistrationBean<*> {
        val urlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource()
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.allowCredentials = true
        corsConfiguration.addAllowedOrigin("*")
        corsConfiguration.addAllowedHeader("*")
        corsConfiguration.addAllowedMethod("GET")
        corsConfiguration.addAllowedMethod("PUT")
        corsConfiguration.addAllowedMethod("POST")
        corsConfiguration.addAllowedMethod("DELETE")
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration)
        val corsFilter = CorsFilter(urlBasedCorsConfigurationSource)
        val bean = FilterRegistrationBean(corsFilter)
        bean.order = 0
        return bean
    }

    @Bean
    fun mvcConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurerAdapter() {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**").allowedMethods("GET", "PUT", "POST", "GET", "OPTIONS")
            }
        }
    }

}