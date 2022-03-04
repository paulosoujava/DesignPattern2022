package com.paulo.desginpattern.creational.builder

// USed when we have multiple parameters to initialize
// for many parameters, It's impractical to build all constructors
class Component private constructor(builder: Builder) {
    var param1: String? = null
    var param2: Int? = 0
    var param3: Boolean? = false

    class Builder {
        var param1: String? = null
        var param2: Int? = 0
        var param3: Boolean? = false

        fun setParam1( param1: String) = apply { this.param1 = param1 }
        fun setParam2( param2: Int) = apply { this.param2 = param2 }
        fun setParam3( param3: Boolean) = apply { this.param3 = param3 }
        fun build() = Component(this)


        fun getParams1() = param1
        fun getParams2() = param2
        fun getParams3() = param3
    }

    init {
        param1 = builder.getParams1()
        param2 = builder.getParams2()
        param3 = builder.getParams3()
    }

}

fun main() {
    val component = Component.Builder()
        .setParam1("Some value")
        .setParam2(12)
        .setParam3(true)
        .build()
}
