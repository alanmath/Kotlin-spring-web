package com.apresentation.use.repositories

import com.apresentation.use.entities.Category
import com.apresentation.use.entities.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long>{
    fun findByCategory(category: Category): List<Product>

}