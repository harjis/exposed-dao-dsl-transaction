package com.example.exposeddaodsltransaction.app.services

import com.example.exposeddaodsltransaction.app.models.Comment
import com.example.exposeddaodsltransaction.app.models.Post
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class PostSaveServiceTest {
    @Autowired
    lateinit var postSaveService: PostSaveService

    @Test
    fun doesNotSaveInvalidDataWithDAO() {
        try {
            postSaveService.createInvalidDataDAO()
        } catch (e: Exception) {
            println("Creating of invalid data failed")
        }

        Assertions.assertThat(Post.count()).isEqualTo(0)
        Assertions.assertThat(Comment.count()).isEqualTo(0)
    }

    @Test
    fun doesNotSaveInvalidDataWithDSL() {
        try {
            postSaveService.createInvalidDataDSL()
        } catch (e: Exception) {
            println("Creating of invalid data failed")
        }

        Assertions.assertThat(Post.count()).isEqualTo(0)
        Assertions.assertThat(Comment.count()).isEqualTo(0)
    }
}
