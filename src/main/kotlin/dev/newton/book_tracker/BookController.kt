package dev.newton.book_tracker

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/books")
class BookController(private val bookService: BookService) {
    @GetMapping
    fun getAllBooks() = bookService.findAll()

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: UUID) = bookService.findById(id)

    @PostMapping
    fun createBook(@RequestBody book: Book) : ResponseEntity<Book> {
        bookService.create(book)
        return ResponseEntity.ok(book)
    }

    @PutMapping("/{id}")
    fun updateBook(@PathVariable id: UUID, @RequestBody book: Book) = bookService.update(id, book)

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: UUID) = bookService.delete(id)
}