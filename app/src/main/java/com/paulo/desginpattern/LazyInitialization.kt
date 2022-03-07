package com.paulo.desginpattern

/*
Very useful technique for memory management
Initialize a resource when it’s needed, not when declared
Lazy vs eager initialization

Kotlin has built in lazy initialization
Can only be used with val properties

Kotlin allows for late initialization
Can be used with var properties
Crash if variable not initialized before use
 */
class AlertBox {
    var message: String? = null

    fun show() {
        println("AlertBox $this: $message")
    }
}

class Window {
    val box by lazy { AlertBox() }

    fun showMessage(message: String) {
        box.message = message
        box.show()
    }
}

class Window2 {
    lateinit var box: AlertBox

    fun showMessage(message: String) {
        box = AlertBox()
        box.message = message
        box.show()
    }
}

class WindowTest {

    fun windowTest() {
        val window = Window()
        window.showMessage("Hello window")


        val window2 = Window2()
//        println(window2.box)
        window2.showMessage("Second window")

    }
}