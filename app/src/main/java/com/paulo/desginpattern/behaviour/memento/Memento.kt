package com.paulo.desginpattern.behaviour.memento

import com.paulo.desginpattern.creational.prototype.example.Cat

/*
Save and restore previous state without revealing implementation details
 3 - Components:
    Memento - stores the state
    Originator - creates the state
    Caretaker - decides to save or restore the state
 */

data class Memento(val state: String)
class Originator(var state: String){
    fun createMemento() = Memento(state)
    fun restoreMemento(memento: Memento){
        state = memento.state
    }
}

class Caretaker{
    private val mementoList = arrayListOf<Memento>()

    fun saveState(state: Memento){
        mementoList.add(state)
    }
    fun restoreMemento(index: Int): Memento  = mementoList[index]

}

fun main() {
    val originator = Originator("initial state")
    val caretaker = Caretaker()
    caretaker.saveState(originator.createMemento())

    originator.state = "State 1"
    caretaker.saveState(originator.createMemento())

    originator.state = "State 2"
    caretaker.saveState(originator.createMemento())

    println("Current state is ${originator.state}")

    println(originator.state == "State 2")

    originator.restoreMemento(caretaker.restoreMemento(1))
    println(originator.state == "State 1")

    originator.restoreMemento(caretaker.restoreMemento(0))
    println(originator.state == "initial state")


    println(originator.state)
}