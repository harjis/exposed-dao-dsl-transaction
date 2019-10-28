package com.example.exposeddaodsltransaction

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
class ExposedDaoDslTransactionApplication

fun main(args: Array<String>) {
    runApplication<ExposedDaoDslTransactionApplication>(*args)
}
