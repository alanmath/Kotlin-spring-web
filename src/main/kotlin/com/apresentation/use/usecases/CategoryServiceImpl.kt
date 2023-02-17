package com.apresentation.use.usecases

import com.apresentation.use.entities.Category
import com.apresentation.use.repositories.CategoryRepository
import com.apresentation.use.repositories.ProductRepository
import com.apresentation.use.services.CategoryService
import org.springframework.stereotype.Service
import com.apresentation.use.dtos.ProductDto
import com.apresentation.use.entities.Product
import org.slf4j.LoggerFactory

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository,

): CategoryService {
    val LOGGER = LoggerFactory.getLogger(ProductServiceImpl::class.java)
    override fun getAllCategories(): List<Category> {
        return categoryRepository.findAll()
    }

    override fun findProductsByCategoryName(categoryName: String): List<ProductDto> {
        val category = categoryRepository.findByName(categoryName)

        val productList = productRepository.findByCategory(category)

        val productDTOList = mutableListOf<ProductDto>()

        for (product in productList) {
            val p = ProductDto(product.name, product.description, category.name)
            productDTOList.add(p)
        }

        return productDTOList
    }


    override fun createCategory(category: Category): Category {
        try {
            val savedCategory = productRepository.save(category)
            LOGGER.info("Category created with id ${savedCategory.id}")
            return savedCategory
        } catch (ex: Exception) {
            LOGGER.error("Error creating category: ${ex.message}", ex)
            throw ex
        }
    }
}