package com.paulo.desginpattern.behaviour.iterator.exampleGuru


interface ProfileIterator {
    operator fun hasNext(): Boolean
    val next: Profile?

    fun reset()
}