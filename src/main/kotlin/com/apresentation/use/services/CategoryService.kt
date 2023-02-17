package com.apresentation.use.services

import com.apresentation.use.dtos.ProductDto
import com.apresentation.use.entities.Category

interface CategoryService {
    fun getAllCategories(): List<Category>
    fun findProductsByCategoryName(name: String): List<ProductDto>
    fun createCategory(product: Category): Category
}