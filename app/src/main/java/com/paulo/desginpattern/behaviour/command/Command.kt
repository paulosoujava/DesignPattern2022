package com.paulo.desginpattern.behaviour.command

/*
A request is wrapped in an object that contains all request info
The command object is passed to the correct handler
 */

interface Command {
    fun execute()
}

class OrderAddCommand(private val id: Long): Command{
    override fun execute() {
        println("Add order with id:: $id")
    }
}

class OrderPayCommand(private val id: Long): Command{
    override fun execute() {
        println("Paying order with id:: $id")
    }
}

class CommandProcessor {
    private val queue = arrayListOf<Command>()
    fun addQueue(command: Command): CommandProcessor = apply {
        queue.add(command)
    }

    fun processCommands():CommandProcessor = apply {
        queue.forEach{ it.execute()}
        queue.clear()
    }
}

fun main() {
    CommandProcessor()
        .addQueue(OrderAddCommand(1L))
        .addQueue(OrderAddCommand(2L))
        .addQueue(OrderPayCommand(2L))
        .addQueue(OrderPayCommand(1L))
        .processCommands()
}