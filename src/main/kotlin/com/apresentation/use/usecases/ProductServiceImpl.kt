package com.apresentation.use.usecases
import com.apresentation.use.repositories.ProductRepository
import com.apresentation.use.services.ProductService
import com.apresentation.use.entities.Product
import org.slf4j.LoggerFactory
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service



//private val logger = LogManager.getLogger(ProductServiceImpl::class.java)

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
) : ProductService {
    val LOGGER = LoggerFactory.getLogger(ProductServiceImpl::class.java)
    override fun getAll(): List<Product> = productRepository.findAll()


    override fun getById(id: Long): Product = productRepository.findById(id).orElseThrow { ChangeSetPersister.NotFoundException() }


    override fun create(product: Product): Product {
        try {
            val savedProduct = productRepository.save(product)
            LOGGER.info("Product created with id ${savedProduct.id}")
            return savedProduct
        } catch (ex: Exception) {
            LOGGER.error("Error creating product: ${ex.message}", ex)
            throw ex
        }
    }

    override fun update(id: Long, product: Product): Product {

        val foundProduct = getById(id)
        foundProduct.name = product.name
        foundProduct.description = product.description
        foundProduct.price = product.price
        return productRepository.save(foundProduct)
    }


    override fun delete(id: Long) = productRepository.deleteById(id)
}















//@Service
//class ProductServiceImpl : ProductService {
//    private val products = mutableListOf<Product>()
//    private var lastId = 0L
//
//    override fun getProducts(): List<Product> {
//        try {
//            return products
//        } catch (e: Exception) {
//            //logger.error("Erro ao recuperar produtos", e)
//            throw Exception("Erro ao recuperar lista de produtos.")
//        }
//    }
//
//    override fun getProductById(id: Long): Product = products.find { it.id == id }!!
//
//
//    override fun createProduct(product: Product): Product {
//        lastId++
//        product.id = lastId
//        products.add(product)
//        return product
//    }
//
//    override fun updateProduct(id: Long, product: Product): Product {
//        val index = products.indexOfFirst { it.id == id }
//        if (index == -1){
//            return products[0]
//        }
//        else{
//        products[index] = product.copy(id = id)}
//        return product
//    }
//
////    override fun deleteProduct(id: Long) = products.removeIf { it.id == id }
//}

