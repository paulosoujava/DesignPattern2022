package com.paulo.desginpattern.behaviour.iterator.exampleGuru

class SocialSpammer(var network: SocialNetwork) {
    var iterator: ProfileIterator? = null
    fun sendSpamToFriends(profileEmail: String?, message: String) {
        println("\nIterating over friends...\n")
        iterator = network.createFriendsIterator(profileEmail)
        while (iterator!!.hasNext()) {
            val profile = iterator!!.next
            sendMessage(profile!!.email, message)
        }
    }

    fun sendSpamToCoworkers(profileEmail: String?, message: String) {
        println("\nIterating over coworkers...\n")
        iterator = network.createCoworkersIterator(profileEmail)
        while (iterator!!.hasNext()) {
            val profile = iterator!!.next
            sendMessage(profile!!.email, message)
        }
    }

    fun sendMessage(email: String, message: String) {
        println("Sent message to: '$email'. Message body: '$message'")
    }
}