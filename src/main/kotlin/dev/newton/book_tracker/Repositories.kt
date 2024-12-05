package dev.newton.book_tracker

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BookRepository : JpaRepository<Book, UUID> {
    fun findByTitle(title: String): Book?
}