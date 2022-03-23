package com.paulo.desginpattern.structural.proxy.otherExample

interface Image{
    fun display()
}

class RealImage(private val filename: String): Image{
    override fun display(){
        println("RealImage Displaying $filename")
    }
    private fun loadFromDisk(filename: String){
        println("RealImage: Loading: $filename")
    }

    init {
        loadFromDisk(filename)
    }
}

class ProxyImage(private val filename: String): Image{
    private var realImage: RealImage? = null

    override fun display() {
        println("ProxyImage Displayin $filename")
        if(realImage == null){
            realImage = RealImage(filename)
        }
        realImage!!.display()
    }
}

fun main() {
    val image = ProxyImage("test.jpg")
    //load image from disk
    image.display()

    //load image from "cache"
    image.display()
}

















