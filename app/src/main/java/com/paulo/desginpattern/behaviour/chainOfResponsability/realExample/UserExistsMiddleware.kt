package com.paulo.desginpattern.behaviour.chainOfResponsability.realExample




/**
 * ConcreteHandler. Checks whether a user with the given credentials exists.
 */
class UserExistsMiddleware(server: Server) : Middleware() {
    private val server: Server
    override fun check(email: String?, password: String?): Boolean {
        if (!server.hasEmail(email)) {
            println("This email is not registered!")
            return false
        }
        if (!server.isValidPassword(email, password)) {
            println("Wrong password!")
            return false
        }
        return checkNext(email, password)
    }

    init {
        this.server = server
    }
}