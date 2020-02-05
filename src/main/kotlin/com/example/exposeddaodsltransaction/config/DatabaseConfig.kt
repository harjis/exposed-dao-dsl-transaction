package com.example.exposeddaodsltransaction.config

import org.flywaydb.core.Flyway
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DatabaseConfig {
    @Bean
    fun flyway(dataSource: DataSource): Flyway = Flyway
            .configure()
            .dataSource(dataSource)
            .load()
            .apply {
                clean()
                migrate()
            }
}
