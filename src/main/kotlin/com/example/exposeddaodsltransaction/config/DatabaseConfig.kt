package com.example.exposeddaodsltransaction.config

import org.flywaydb.core.Flyway
import org.jetbrains.exposed.spring.SpringTransactionManager
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.annotation.TransactionManagementConfigurer
import javax.sql.DataSource


@Configuration
@AutoConfigureAfter(DataSourceAutoConfiguration::class)
@EnableTransactionManagement
class DatabaseConfig {
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
    open fun springTransactionManager(datasource: DataSource) = SpringTransactionManager(dataSource())
}
