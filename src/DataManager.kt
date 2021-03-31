package learning.elkip

class DataManager {
    var books = ArrayList<Book>()

    fun getId(): String {
        return books.size.toString()
    }

    init {
        books.add(Book(getId(), "How to grow apples", "Mr. Appleton", 100.0f))
        books.add(Book(getId(), "How to grow lemons", "Mr. Lemonon", 1.0f))
        books.add(Book(getId(), "How to grow kumqaut", "Mr. Pineapple", 10.0f))
        books.add(Book(getId(), "How to grow coconuts", "Mr. Gorbachav", 1009.0f))
        books.add(Book(getId(), "How to grow kiwi", "Mr. Lemonon", 120.0f))
    }

    fun newBook(book: Book): Book {
        books.add(book)
        return book
    }

    fun updateBook(book: Book): Book? {
        val foundBook = books.find {
            it.id == book.id
        }
        foundBook?.title = book.title
        foundBook?.author = book.author
        foundBook?.price = book.price
        return foundBook
    }

    fun deleteBook(id: String): Book {
        val bookFound = books.find {
            it.id == id
        }
        books.remove(bookFound)
        return bookFound!!
    }

    fun allBooks(): List<Book> {
        return books
    }
}
