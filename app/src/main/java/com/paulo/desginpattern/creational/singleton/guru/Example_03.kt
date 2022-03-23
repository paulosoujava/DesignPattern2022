package com.paulo.desginpattern.creational.singleton.guru
/*
Singleton seguro para threads com carregamento lento
Para corrigir o problema, você deve sincronizar os threads durante a primeira criação do objeto Singleton.
 */

class Singleton2 private constructor(var value: String) {
    companion object {
        // The field must be declared volatile so that double check lock would work
        // correctly.
        private var instance: Singleton2? = null
        fun getInstance(value: String?): Singleton2? {
            // The approach taken here is called double-checked locking (DCL). It
            // exists to prevent race condition between multiple threads that may
            // attempt to get singleton instance at the same time, creating separate
            // instances as a result.
            //
            // It may seem that having the `result` variable here is completely
            // pointless. There is, however, a very important caveat when
            // implementing double-checked locking in Java, which is solved by
            // introducing this local variable.
            //
            // You can read more info DCL issues in Java here:
            // https://refactoring.guru/java-dcl-issue
            val result = Companion.instance
            if (result != null) {
                return result
            }
            synchronized(Singleton::class.java) {
                if (Companion.instance == null) {
                    Companion.instance = Singleton2(value!!)
                }
                return Companion.instance
            }
        }
    }
}
object DemoMultiThread2 {
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
