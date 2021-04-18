package learning.elkip

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*

@Location("/api/book/list")
data class BookListLocation(val sortby: String, val asc: Boolean)

fun Route.books(){
    val dataManager = DataManager()
    authenticate("bookStoreAuth") {
        get<BookListLocation>() {
            call.respond(dataManager.sortedBooks(it.sortby, it.asc))
        }
    }
}