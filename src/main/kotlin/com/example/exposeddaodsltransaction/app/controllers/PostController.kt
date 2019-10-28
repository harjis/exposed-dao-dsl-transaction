package com.example.exposeddaodsltransaction.app.controllers

import com.example.exposeddaodsltransaction.app.models.Post
import com.example.exposeddaodsltransaction.app.services.PostSaveService
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(val postSaveService: PostSaveService) {
    @GetMapping
    @Transactional
    fun index(): List<PostView> = Post.all().map { PostView(it.name) }

    @GetMapping("/dao")
    fun createWithDAO() = postSaveService.createInvalidDataDAO()

    @GetMapping("/dsl")
    fun createWithDSL() = postSaveService.createInvalidDataDSL()
}

data class PostView(val name: String)
