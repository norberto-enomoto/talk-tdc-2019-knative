package com.example.knative.infra

import com.example.knative.domain.Verify
import javax.validation.constraints.NotBlank

data class VerifyRequest(
        @param:NotBlank val name: String,
        @param:NotBlank val number: String
) {

    fun toVerify() = Verify(name, number)

}