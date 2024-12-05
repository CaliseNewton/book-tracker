package dev.newton.book_tracker

import org.springframework.stereotype.Service
import java.util.*
import kotlin.NoSuchElementException

@Service
class BookService(private val bookRepository: BookRepository) {
    fun findAll(): List<Book> = bookRepository.findAll()
    fun findById(id: UUID): Book = bookRepository.findById(id).orElseThrow { NoSuchElementException("Book not found") }
    fun findByTitle(title: String): Book? = bookRepository.findByTitle(title)
    fun create(book: Book): Book = bookRepository.save(book)
    fun update(id: UUID, updatedBook: Book): Book {
        val book = findById(id)
        return bookRepository.save(book.copy(
            id = id,
            title = updatedBook.title,
            author = updatedBook.author,
            yearPublished = updatedBook.yearPublished,
            status = updatedBook.status
        ))
    }
    fun delete(id: UUID) = bookRepository.deleteById(id)
}