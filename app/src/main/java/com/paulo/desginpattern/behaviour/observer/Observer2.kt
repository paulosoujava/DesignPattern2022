package com.paulo.desginpattern.behaviour.observer

import java.io.File

/*
Define a subscription mechanism
Notify multiple objects simultaneously
One to many relationship
 */
interface EventListener2 {
    fun update(eventType: String?, file: File?)
}

class EventManager2(vararg operations: String) {
    private var listiners = hashMapOf<String, ArrayList<EventListener2>>()

    init {
        for (operation in operations) {
            listiners[operation] = ArrayList()
        }
    }

    fun subscribe(eventType: String?, listener: EventListener2) {
        val users: ArrayList<EventListener2>? = listiners[eventType]
        users?.add(listener)
    }

    fun unsubscribe(eventType: String?, listener: EventListener2) {
        val users: ArrayList<EventListener2>? = listiners[eventType]
        users?.remove(listener)
    }

    fun notify(eventType: String?, file: File?) {
        val users: ArrayList<EventListener2>? = listiners[eventType]
        users?.let {
            for(listener in it){
                listener.update(eventType, file)
            }
        }
    }
}

class Editor2 {
    var events = EventManager2("open", "save")
    private var file: File? = null

    fun openFile(filePath: String){
        file = File(filePath)
        events.notify("open", file)
    }
    fun saveFile(){
            file?.let {
                events.notify("save", file)
            }
    }
}

class EmailNotificationListener2(private val email: String): EventListener2{
    override fun update(eventType: String?, file: File?) {
        println("Email to " + email + ": Someone has performed " + eventType + " operation with the following file: " + file!!.name)

    }
}

class LogOpenListener2(var log: String): EventListener2{
    override fun update(eventType: String?, file: File?) {
        println("Save to log " + log + ": Someone has performed " + eventType + " operation with the following file: " + file!!.name)
    }
}

fun main() {
    val editor = Editor2()
    editor.events.subscribe("open", LogOpenListener2("path"))
    editor.events.subscribe("save", EmailNotificationListener2("email"))

    editor.openFile("text.txt")
    editor.saveFile()
}
