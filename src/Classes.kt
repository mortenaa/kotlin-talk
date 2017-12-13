class Event {
}

class Message

class Student {

    private val name: String

    constructor(name: String) {
        this.name = name
    }
}

class Person(val firstName: String) {
}

class Person2(val firstName: String, val lastName: String, var age: Int) {
}

data class User(val userName: String, val password: String)

data class Book(val title: String, val author: String, val year: Int = -1, val sortedUnder: String = author)

fun main(args: Array<String>) {
    val student = Student("Per")

    val person = Person("Ole")
    val user = User("Morten", "******")
    val user1 = User(userName = "Morten", password = "******")
    println("${user.userName}")
    val book = Book("The Lord of The Rings", "J.R.R. Tolkien", sortedUnder = "Tolkien")
    println(book)
}
