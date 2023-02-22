package com.apresentation.use.repositories

import com.apresentation.use.entities.Category
import com.apresentation.use.entities.Product
import org.springframework.data.jpa.repository.JpaRepository
import javax.naming.Name

interface ProductRepository: JpaRepository<Product, Long>{
    fun findByCategory(category: Category): List<Product>
    fun findByName(name: String): Product?


}