package com.paulo.desginpattern.structural.bridge

/*
Having classes with multiple orthogonal traits exponentially increases the size of the inheritance tree
Split into multiple interfaces/classes
Associate them using a "bridge" reference
 */

interface Device2{
    var volume: Int
    fun getName():String
}

class Radio2: Device2{
    override var volume: Int = 0
    override fun getName() = "Radio"
}
class TV2: Device2{
    override var volume: Int = 0
    override fun getName() = "TV"
}


interface Remote{
    fun volumeUP()
    fun volumeDown()
}

class BasicRemote(val device2: Device2): Remote{
    override fun volumeUP() {
        device2.volume++
        println("${device2.getName()} Vol UP ${device2.volume})")
    }

    override fun volumeDown() {
        device2.volume--
        println("${device2.getName()} Vol Down ${device2.volume})")
    }

}

fun main() {
    val tv = TV2()
    val radio = Radio2()

    val tvRemote = BasicRemote(tv)
    val radioRemote = BasicRemote(radio)

    tvRemote.volumeUP()
    tvRemote.volumeUP()
    tvRemote.volumeUP()
    tvRemote.volumeUP()
    tvRemote.volumeDown()

    radioRemote.volumeUP()
    radioRemote.volumeDown()
}