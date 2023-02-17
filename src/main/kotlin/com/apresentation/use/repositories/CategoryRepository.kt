package com.apresentation.use.repositories

import com.apresentation.use.entities.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository: JpaRepository<Category, Long> {
    fun findByName(name: String): Category
}