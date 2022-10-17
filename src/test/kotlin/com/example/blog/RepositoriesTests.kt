package com.example.blog

import com.example.blog.entity.Article
import com.example.blog.entity.User
import com.example.blog.repositories.ArticleRepository
import com.example.blog.repositories.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository,
    val articleRepository: ArticleRepository){

    @Test
    fun `When findByIdOrNull then return Article`() {
        val jurgen = User(login = "springjurgen", firstName = "Jurgen", lastName = "Holler")
        entityManager.persist(jurgen)
        val article = Article(title = "Spring data examples", headline = "Examples", content = "The article info",jurgen)
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }
}