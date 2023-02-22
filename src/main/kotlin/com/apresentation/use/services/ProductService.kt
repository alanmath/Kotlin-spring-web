package com.apresentation.use.services
import com.apresentation.use.dtos.ProductDto
import com.apresentation.use.entities.Product


interface ProductService {
    fun getAll(): List<Product>
    fun getById(id: Long): Product
    fun create(product: Product): ProductDto
    fun update(id: Long, product: Product): Product
    fun delete(id: Long)
}
