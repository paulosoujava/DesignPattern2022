package com.paulo.desginpattern.creational.singleton.guru
/*
Singleton ingênuo (multithreaded)
A mesma classe se comporta incorretamente em um ambiente multithread.
Vários threads podem chamar o método de criação simultaneamente e obter várias instâncias da classe Singleton.

 */
class Singleton1 private constructor(value: String) {
    var value: String

    companion object {
        private var instance: Singleton1? = null
        fun getInstance(value: String?): Singleton1? {
            if (Companion.instance == null) {
                Companion.instance = Singleton1(value!!)
            }
            return Companion.instance
        }
    }

    init {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000)
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
        this.value = value
    }
}
object DemoMultiThread {
    @JvmStatic
    fun main(args: Array<String>) {
        println(
            "If you see the same value, then singleton was reused (yay!)" + "\n" +
                    "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                    "RESULT:" + "\n"
        )
        val threadFoo = Thread(ThreadFoo())
        val threadBar = Thread(ThreadBar())
        threadFoo.start()
        threadBar.start()
    }

    internal class ThreadFoo() : Runnable {
        override fun run() {
            val singleton = Singleton.getInstance("FOO")
            println(singleton!!.value)
        }
    }

    internal class ThreadBar() : Runnable {
        override fun run() {
            val singleton = Singleton.getInstance("BAR")
            println(singleton!!.value)
        }
    }
}