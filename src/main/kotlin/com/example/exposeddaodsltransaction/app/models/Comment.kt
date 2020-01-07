package com.example.exposeddaodsltransaction.app.models

import com.example.exposeddaodsltransaction.app.tables.Comments
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class Comment(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<Comment>(Comments)

    var post by Post referencedOn Comments.post

    var body by Comments.body
}
