package com.paulo.desginpattern.creational.singleton

import java.util.concurrent.atomic.AtomicInteger
/*
Uses:
 Network manager
 Database access
 Logging
 Utility class(es)

 */

object CounterSingleton {
    private val counter = AtomicInteger(0)
    fun increment() = counter.incrementAndGet()
}
class CounterNotSingleton{
    private var counter = 1;
    fun increment() = counter++
}

fun main() {
    for (i in 1..10) {
        println("${CounterSingleton.increment() } ${CounterNotSingleton().increment()} ")
    }

}