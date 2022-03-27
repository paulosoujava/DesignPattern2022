package com.paulo.desginpattern.behaviour.mediator

/*
Provide a central object used for communicating between objects
Obects don't talk to each other
Reduce dependencies between objects
 */
class ChatUser(private val mediator: Mediator, private val name: String){
    fun send(msg: String){
        println("$name: Sending message: $msg")
        mediator.sendMessage(msg, this)
    }
    fun recive(msg: String) {
        println("$name: Received message: $msg")
    }

}
class Mediator{
    private val users = arrayListOf<ChatUser>()

    fun sendMessage(msg: String, user: ChatUser){
        users.filter{ it != user }.forEach { it.recive(msg) }
    }
    fun addUser(user: ChatUser): Mediator = apply { users.add(user) }
}

fun main() {
    val mediator = Mediator()
    val paulo = ChatUser(mediator, "Paulo")
    val bruna = ChatUser(mediator, "Bruna")
    val malu = ChatUser(mediator, "Malu")

    mediator.addUser(paulo).addUser(bruna).addUser( malu)
    val renata = ChatUser(mediator, "Renata")
    renata.send("Ola a todos")
}