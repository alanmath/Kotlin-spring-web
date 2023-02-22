package com.apresentation.use.handlers

import com.apresentation.use.services.exceptions.ProductAlreadyExistsException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import kotlin.collections.mapOf


@ControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(ProductAlreadyExistsException::class)
    fun handleProductAlreadyExistsException(
        ex: ProductAlreadyExistsException,
        request: WebRequest
    ): ResponseEntity<Any> {
        val body = mapOf("message" to ex.message)
        return ResponseEntity.badRequest().body(body)
    }
}