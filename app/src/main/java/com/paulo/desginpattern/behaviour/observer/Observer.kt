package com.paulo.desginpattern.behaviour.observer

import java.io.File

class EventManager(vararg operations: String) {
    var listeners: MutableMap<String, MutableList<EventListener>> = HashMap()
    fun subscribe(eventType: String, listener: EventListener) {
        val users: MutableList<EventListener> = listeners[eventType]!!
        users.add(listener)
    }

    fun unsubscribe(eventType: String, listener: EventListener) {
        val users: MutableList<EventListener> = listeners[eventType]!!
        users.remove(listener)
    }

    fun notify(eventType: String, file: File?) {
        val users: List<EventListener> = listeners[eventType]!!
        for (listener in users) {
            listener.update(eventType, file)
        }
    }

    init {
        for (operation in operations) {
            listeners[operation] = ArrayList()
        }
    }
}

class Editor {
    var events: EventManager
    private var file: File? = null
    fun openFile(filePath: String?) {
        file = File(filePath)
        events.notify("open", file)
    }

    @Throws(Exception::class)
    fun saveFile() {
        if (file != null) {
            events.notify("save", file)
        } else {
            throw Exception("Please open a file first.")
        }
    }

    init {
        events = EventManager("open", "save")
    }
}

interface EventListener {
    fun update(eventType: String?, file: File?)
}
class EmailNotificationListener(private val email: String) : EventListener {
    override fun update(eventType: String?, file: File?) {
        println("Email to " + email + ": Someone has performed " + eventType + " operation with the following file: " + file!!.name)
    }
}

class LogOpenListener(fileName: String?) : EventListener {
    private val log: File
    override fun update(eventType: String?, file: File?) {
        println("Save to log " + log + ": Someone has performed " + eventType + " operation with the following file: " + file!!.name)
    }

    init {
        log = File(fileName)
    }
}
object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val editor = Editor()
        editor.events.subscribe("open", LogOpenListener("/path/to/log/file.txt"))
        editor.events.subscribe("save", EmailNotificationListener("admin@example.com"))
        try {
            editor.openFile("test.txt")
            editor.saveFile()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}