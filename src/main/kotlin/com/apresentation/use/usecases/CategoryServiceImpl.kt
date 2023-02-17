package com.apresentation.use.usecases

import com.apresentation.use.entities.Category
import com.apresentation.use.repositories.CategoryRepository
import com.apresentation.use.repositories.ProductRepository
import com.apresentation.use.services.CategoryService
import org.springframework.stereotype.Service
import com.apresentation.use.dtos.ProductDto
import com.apresentation.use.entities.Product

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository,
): CategoryService {
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
        return categoryRepository.save(category)
    }
}