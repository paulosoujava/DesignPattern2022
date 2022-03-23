package com.paulo.desginpattern.creational.singleton.guru

/*
Singleton ingênuo (thread única)
É muito fácil implementar um Singleton desleixado. Você só precisa ocultar o construtor e implementar um método de criação estático.
 */
class Singleton private constructor(value: String) {
    var value: String

    companion object {
        private var instance: Singleton? = null
        fun getInstance(value: String): Singleton? {
            if (instance == null) {
                instance = Singleton(value)
            }
            return instance
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
object DemoSingleThread {
    @JvmStatic
    fun main(args: Array<String>) {
        println(
            """
                If you see the same value, then singleton was reused (yay!)
                If you see different values, then 2 singletons were created (booo!!)
                
                RESULT:
                
                """.trimIndent()
        )
        val singleton = Singleton.getInstance("FOO")
        val anotherSingleton = Singleton.getInstance("BAR")
        println(singleton!!.value)
        println(anotherSingleton!!.value)
    }
}