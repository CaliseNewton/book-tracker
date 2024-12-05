package dev.newton.book_tracker

import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController {

    @GetMapping("/")
    fun book(model: Model): String {
        model["title"] = "Book Tracker"
        return "book"
    }

}