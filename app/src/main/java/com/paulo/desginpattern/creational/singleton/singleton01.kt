package com.paulo.desginpattern.creational.singleton

import org.jetbrains.annotations.TestOnly

object NetworkDriver{
    init {
        println("Initializing: $this")
    }

    fun log(): NetworkDriver =
        apply {  println("Network driver $this") }

}

fun main() {
    val net1 = NetworkDriver.log()
    val net2 = NetworkDriver.log()

    println( net1 == net2)
}