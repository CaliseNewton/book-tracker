package dev.newton.book_tracker

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookTrackerApplication

fun main(args: Array<String>) {
	runApplication<BookTrackerApplication>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}
}
