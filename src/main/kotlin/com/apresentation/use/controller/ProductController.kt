package com.apresentation.use.controller

import com.apresentation.use.dtos.ProductDto
import com.apresentation.use.services.ProductService
import com.apresentation.use.entities.Product
import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
@Api(value = "API do Produto")
class ProductController(private val productService: ProductService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): ResponseEntity<List<Product>>{
        val products = productService.getAll()
        return ResponseEntity.ok(products)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Product {
        return productService.getById(id)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun save(@RequestBody product: Product): ResponseEntity<ProductDto> {
        val savedProduct = productService.create(product)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct)
    }

    @PutMapping(value = ["/{id}"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@PathVariable id: Long, @RequestBody product: Product): ResponseEntity<Product> {
        val updatedProduct = productService.update(id, product)
        return ResponseEntity.ok(updatedProduct)
    }

    @DeleteMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        productService.delete(id)
        return ResponseEntity.noContent().build()
    }
}