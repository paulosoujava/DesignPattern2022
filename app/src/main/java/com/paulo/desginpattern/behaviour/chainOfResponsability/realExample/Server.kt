package com.paulo.desginpattern.behaviour.chainOfResponsability.realExample


/**
 * Server class.
 */
class Server {
    private val users: MutableMap<String, String> = HashMap()
    private var middleware: Middleware? = null

    /**
     * Client passes a chain of object to server. This improves flexibility and
     * makes testing the server class easier.
     */
    fun setMiddleware(middleware: Middleware?) {
        this.middleware = middleware
    }

    /**
     * Server gets email and password from client and sends the authorization
     * request to the chain.
     */
    fun logIn(email: String?, password: String?): Boolean {
        if (middleware!!.check(email, password)) {
            println("Authorization have been successful!")

            // Do something useful here for authorized users.
            return true
        }
        return false
    }

    fun register(email: String, password: String) {
        users[email] = password
    }

    fun hasEmail(email: String?): Boolean {
        return users.containsKey(email)
    }

    fun isValidPassword(email: String?, password: String?): Boolean {
        return users[email] == password
    }
}