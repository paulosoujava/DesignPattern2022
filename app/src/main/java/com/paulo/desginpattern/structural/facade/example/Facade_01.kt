package com.paulo.desginpattern.structural.facade.example

/*
Provide a simple interface to a complex functionality
Remove the need for complex object / memory management
simplifies client implementation
 */

class ComplexSystemStore(private val filePath: String) {
    private val cache: HashMap<String, String>

    init {
        println("Reading data from the file: $filePath")
        cache = HashMap()
        // Read properties from file and put to cache
    }

    fun store(key: String, value: String) {
        cache[key] = value
    }

    fun read(key: String) = cache[key] ?: ""

    fun commit() = println("Storing cached ata to file $filePath")
}

data class User(val login: String)

//Facade
class UserRepository {
    private val systemPreference = ComplexSystemStore("/data/default.prefs")

    fun save(user: User) {
        systemPreference.store("USER_KEY", user.login)
        systemPreference.commit()
    }

    fun findFirst(): User = User(systemPreference.read("USER_KEY"))
}

fun main() {
    val repo = UserRepository()
    val user = User("john")
    repo.save(user)

    val retrievedUer = repo.findFirst()
}