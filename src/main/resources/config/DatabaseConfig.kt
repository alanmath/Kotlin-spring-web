//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
//import org.springframework.boot.jdbc.DataSourceBuilder
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.jdbc.datasource.DataSourceTransactionManager
//import org.springframework.transaction.PlatformTransactionManager
//import org.springframework.transaction.annotation.EnableTransactionManagement
//import org.springframework.transaction.annotation.TransactionManagementConfigurer
//import javax.sql.DataSource
//
//@Configuration
//@EnableTransactionManagement
//class DatabaseConfig(private val dataSourceProperties: DataSourceProperties) : TransactionManagementConfigurer {
//
//    @Bean
//    fun dataSource(): DataSource {
//        val dataSourceBuilder = DataSourceBuilder.create()
//        dataSourceBuilder.driverClassName(dataSourceProperties.driverClassName)
//        dataSourceBuilder.url(dataSourceProperties.url)
//        dataSourceBuilder.username(dataSourceProperties.username)
//        dataSourceBuilder.password(dataSourceProperties.password)
//        return dataSourceBuilder.build()
//    }
//
//    override fun annotationDrivenTransactionManager(): PlatformTransactionManager {
//        return DataSourceTransactionManager(dataSource())
//    }
//}