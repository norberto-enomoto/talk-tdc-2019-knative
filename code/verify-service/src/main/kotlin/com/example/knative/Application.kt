package com.example.knative

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VerifyServiceApplication

fun main(args: Array<String>) {
	runApplication<VerifyServiceApplication>(*args)
}
