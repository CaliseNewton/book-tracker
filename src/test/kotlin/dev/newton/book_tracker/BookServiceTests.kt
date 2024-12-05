package dev.newton.book_tracker

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*
import kotlin.test.Test


@ExtendWith(MockitoExtension::class)
class BookServiceTests {

    @Mock
    lateinit var myRepository: BookRepository

    @InjectMocks
    lateinit var myService: BookService

    @Test
    fun `should return data when Book exists`() {
        val id = UUID.randomUUID()
        val mockBook = Book(id, "Moby Dick", "Herman Melville", 1851, "TBR")
        Mockito.`when`(myRepository.findById(id)).thenReturn(Optional.of(mockBook))

        val result = myService.findById(id)

        assertEquals(mockBook, result)
    }
}