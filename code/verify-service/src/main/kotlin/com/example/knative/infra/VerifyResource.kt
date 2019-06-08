package com.example.knative.infra

import com.example.knative.domain.VerifyService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/verify")
class VerifyResource(val verifyService: VerifyService) {

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun post(@RequestBody payload: VerifyRequest) = verifyService.verifyNumber(payload.toVerify())

}