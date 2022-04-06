package com.paulo.desginpattern.behaviour.observer.example

interface Observer {
    fun update(message: String)
    fun getName(): String
    fun getEmail(): String
}