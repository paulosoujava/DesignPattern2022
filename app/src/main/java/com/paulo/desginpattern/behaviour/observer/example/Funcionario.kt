package com.paulo.desginpattern.behaviour.observer.example

import com.paulo.desginpattern.behaviour.observer.example.Observer
import com.paulo.desginpattern.behaviour.observer.example.Subject

class Funcionario(
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

    override fun getName() = name

    override fun getEmail() = email
}