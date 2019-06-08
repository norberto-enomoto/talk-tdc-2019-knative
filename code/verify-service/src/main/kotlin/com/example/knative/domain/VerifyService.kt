package com.example.knative.domain

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class VerifyService {

    val log = LoggerFactory.getLogger(this::class.java)

    fun verifyNumber(verify: Verify) {
        log.info("Verifying number ${verify.number}")
        // TODO Add to queue
    }

}