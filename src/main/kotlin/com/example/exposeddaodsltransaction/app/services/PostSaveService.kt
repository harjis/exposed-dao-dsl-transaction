package com.example.exposeddaodsltransaction.app.services

import com.example.exposeddaodsltransaction.app.models.Comment
import com.example.exposeddaodsltransaction.app.models.Post
import com.example.exposeddaodsltransaction.app.tables.Comments
import com.example.exposeddaodsltransaction.app.tables.Posts
import org.jetbrains.exposed.sql.insert
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class PostSaveService {
    fun createInvalidDataDAO() {
        Post.new {
            name = "Post 1 created with DAO"
        }
        Comment.new {
            body = "Post 1 is cool"
        }
    }

    fun createInvalidDataDSL() {
        Posts.insert {
            it[name] = "Post 1 created with DSL"
        }

        Comments.insert {
            it[body] = "Post 1 is cool"
        }
    }
}
