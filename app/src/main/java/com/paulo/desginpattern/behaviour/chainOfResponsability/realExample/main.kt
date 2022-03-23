package com.paulo.desginpattern.behaviour.chainOfResponsability.realExample

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * Demo class. Everything comes together here.
 */
object Demo {
    private val reader: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    private var server: Server? = null
    private fun init() {
        server = Server()
        server!!.register("admin@example.com", "admin_pass")
        server!!.register("user@example.com", "user_pass")

        // All checks are linked. Client can build various chains using the same
        // components.
        val middleware: Middleware = ThrottlingMiddleware(2)
        middleware.linkWith(UserExistsMiddleware(server!!))
            ?.linkWith(RoleCheckMiddleware())

        // Server gets a chain from client code.
        server!!.setMiddleware(middleware)
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        init()
        var success: Boolean
        do {
            print("Enter email: ")
            val email: String = reader.readLine()
            print("Input password: ")
            val password: String = reader.readLine()
            success = server!!.logIn(email, password)
        } while (!success)
    }
}