package dev.newton.book_tracker

import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import kotlin.test.Test

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val bookRepository: BookRepository) {

    @Test
    fun `When findByName then return Book`() {
        val book = Book(null, "Moby Dick", "Herman Melville", 1851, "TBR")
        entityManager.persist(book)
        entityManager.flush()
        val found = bookRepository.findByTitle("Moby Dick")
        assertThat(found).isEqualTo(book)
    }
}