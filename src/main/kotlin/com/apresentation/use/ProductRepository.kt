package com.apresentation.use

import com.apresentation.use.entities.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long>