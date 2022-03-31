package com.paulo.desginpattern.behaviour.templateMethod

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Base class of social network.
 */
abstract class Network internal constructor() {
    var userName: String? = null
    var password: String? = null

    /**
     * Publish the data to whatever network.
     */
    fun post(message: String): Boolean {
        // Authenticate before posting. Every network uses a different
        // authentication method.
        if (logIn(userName, password)) {
            // Send the post data.
            val result = sendData(message.toByteArray())
            logOut()
            return result
        }
        return false
    }

    abstract fun logIn(userName: String?, password: String?): Boolean
    abstract fun sendData(data: ByteArray?): Boolean
    abstract fun logOut()
}

/**
 * Class of social network
 */
class Facebook(userName: String?, password: String?) : Network() {
    override fun logIn(userName: String?, password: String?): Boolean {
        println("\nChecking user's parameters")
        println("Name: " + this.userName)
        print("Password: ")
        for (i in 0 until this.password!!.length) {
            print("*")
        }
        simulateNetworkLatency()
        println("\n\nLogIn success on Facebook")
        return true
    }

    override fun sendData(data: ByteArray?): Boolean {
        val messagePosted = true
        return if (messagePosted) {
            println("Message: '" + String(data!!) + "' was posted on Facebook")
            true
        } else {
            false
        }
    }

    override fun logOut() {
        println("User: '$userName' was logged out from Facebook")
    }

    private fun simulateNetworkLatency() {
        try {
            var i = 0
            println()
            while (i < 10) {
                print(".")
                Thread.sleep(500)
                i++
            }
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }

    init {
        this.userName = userName
        this.password = password
    }
}

/**
 * Class of social network
 */
class Twitter(userName: String?, password: String?) : Network() {
    override fun logIn(userName: String?, password: String?): Boolean {
        println("\nChecking user's parameters")
        println("Name: " + this.userName)
        print("Password: ")
        for (i in 0 until this.password!!.length) {
            print("*")
        }
        simulateNetworkLatency()
        println("\n\nLogIn success on Twitter")
        return true
    }

    override fun sendData(data: ByteArray?): Boolean {
        val messagePosted = true
        return if (messagePosted) {
            println("Message: '" + String(data!!) + "' was posted on Twitter")
            true
        } else {
            false
        }
    }

    override fun logOut() {
        println("User: '$userName' was logged out from Twitter")
    }

    private fun simulateNetworkLatency() {
        try {
            var i = 0
            println()
            while (i < 10) {
                print(".")
                Thread.sleep(500)
                i++
            }
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }

    init {
        this.userName = userName
        this.password = password
    }
}

/**
 * Demo class. Everything comes together here.
 */
object Demo {
    @Throws(IndexOutOfBoundsException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val reader = BufferedReader(InputStreamReader(System.`in`))
        var network: Network? = null
        print("Input user name: ")
        val userName: String = reader.readLine()
        print("Input password: ")
        val password: String = reader.readLine()

        // Enter the message.
        print("Input message: ")
        val message: String = reader.readLine()
        println(
            """
                
                Choose social network for posting message.
                1 - Facebook
                2 - Twitter
                """.trimIndent()
        )
        val choice: Int = reader.readLine().toInt()

        // Create proper network object and send the message.
        if (choice == 1) {
            network = Facebook(userName, password)
        } else if (choice == 2) {
            network = Twitter(userName, password)
        }
        network!!.post(message)
    }
}