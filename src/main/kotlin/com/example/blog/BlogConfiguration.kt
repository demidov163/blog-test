package com.example.blog

import com.example.blog.entity.Article
import com.example.blog.entity.User
import com.example.blog.repositories.ArticleRepository
import com.example.blog.repositories.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {
    @Bean
    fun databaseInitializer(
        userRepository: UserRepository,
        articleRepository: ArticleRepository
    ) = ApplicationRunner {
        val smaldini = userRepository.save(User("smaldini", "Stephane", "Maldini"))
        articleRepository.save(
            Article(
                title = "Reactor Bismuth Op",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            )
        )
        articleRepository.save(Article(
            title = "Reactor Alimuninr Op",
            headline = "Lorem ipsum",
            content = "dolor sit amet",
            author = smaldini
        ))
    }
}
