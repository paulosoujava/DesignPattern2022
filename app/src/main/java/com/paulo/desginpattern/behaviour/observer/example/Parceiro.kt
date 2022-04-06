package com.paulo.desginpattern.behaviour.observer.example

class Parceiro(
    private val name: String,
    private val email: String,
    private val subject: Subject
) : Observer {

    init {
        subject.registerObserver(this)
    }
    override fun update(message: String) {
        Email().enviar(this, message)
    }

    override fun getName()= name

    override fun getEmail() = email
}