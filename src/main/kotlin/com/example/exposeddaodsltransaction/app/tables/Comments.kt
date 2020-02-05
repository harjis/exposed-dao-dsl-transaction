package com.example.exposeddaodsltransaction.app.tables

import org.jetbrains.exposed.dao.id.UUIDTable

object Comments : UUIDTable() {
    val body = varchar("body", 255)
    val post = reference("post", Posts)
}
