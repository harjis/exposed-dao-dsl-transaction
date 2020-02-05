package com.example.exposeddaodsltransaction.config

import org.flywaydb.core.Flyway
import org.jetbrains.exposed.spring.SpringTransactionManager
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.TransactionManagementConfigurer
import javax.sql.DataSource


@Configuration
class DatabaseConfig : TransactionManagementConfigurer {
    @Bean
    fun dataSource(): DataSource {
        return DataSourceBuilder
                .create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:testdb")
                .username("sa")
                .password("password")
                .build()
    }

    @Bean
    fun flyway(): Flyway = Flyway
            .configure()
            .dataSource(dataSource())
            .load()
            .apply {
                clean()
                migrate()
            }

    @Bean
    override fun annotationDrivenTransactionManager() = SpringTransactionManager(dataSource())
}
