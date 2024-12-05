package dev.newton.book_tracker

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*

@Entity
class Book(
    @Id @GeneratedValue val id: UUID? = null,
    val title: String,
    val author: String,
    val yearPublished: Int,
    var status: String
) {
    fun copy(id: UUID, title: String, author: String, yearPublished: Int, status: String): Book {
        return Book(id, title, author, yearPublished, status)
    }
}