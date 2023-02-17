package com.apresentation.use.controller



import com.apresentation.use.dtos.ProductDto
import com.apresentation.use.entities.Category
import com.apresentation.use.services.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/categories")
class CategoryController(
                         private val categoryService: CategoryService
) {

    @GetMapping("/{categoryName}/products")
    fun getProductsByCategoryName(@PathVariable categoryName: String): ResponseEntity<List<ProductDto>> {
        val prodcts = categoryService.findProductsByCategoryName(categoryName)
        return ResponseEntity.ok(prodcts)
    }


    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAllCategories(): ResponseEntity<List<Category>>{
        val categories = categoryService.getAllCategories()
        return ResponseEntity.ok(categories)
    }


    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun save(@RequestBody category: Category): ResponseEntity<Category> {
        val savedCategory = categoryService.createCategory(category)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory)
    }
}