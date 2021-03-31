package learning.elkip

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.books() {
    val dataManager = DataManager()
    route("/book") {
        get("/") {
            call.respond(dataManager.allBooks())
        }

        post("/{id}") {
            val book = call.receive(Book::class)
            val updatedBook = dataManager.updateBook(book)
            call.respondText("$updatedBook has been updated")
        }

        put("/") {
            val book = call.receive(Book::class)
            val newBook = dataManager.newBook(book)
            call.respond(newBook)
        }

        delete("/{id}") {
            val id = call.parameters.get("id").toString()
            val deletedBook = dataManager.deleteBook(id)
            call.respond(deletedBook)
        }
    }
}
