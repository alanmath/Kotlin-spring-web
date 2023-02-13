package com.apresentation.use
import com.apresentation.use.entities.Product


interface ProductService {
    fun getAll(): List<Product>
    fun getById(id: Long): Product
    fun create(product: Product): Product
    fun update(id: Long, product: Product): Product
    fun delete(id: Long)
}
