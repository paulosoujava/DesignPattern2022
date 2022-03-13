package com.paulo.desginpattern.creational.prototype.example

/*
Letsmyou copy  existing objets
without depending on their classes only reliant on interface
the copied object must provide the copy functionality
 */

abstract class NewShape: Cloneable{
    var id: String? = null
    var type: String? = null

     abstract fun draw()

    public override fun clone(): Any {
        var clone: Any? = null
        return try{
            clone = super.clone()
        }catch (e: CloneNotSupportedException){
            println(e.message)
        }
    }
}

class NewRectangle: NewShape(){
    override fun draw() {
        println("Inside Rectangle::draw() method")
    }
    init {
        type = "Rectangle"
    }

}
class NewSquare: NewShape(){
    override fun draw() {
        println("Inside Square::draw() method")
    }
    init {
        type = "Square"
    }
}
class NewCircle: NewShape(){
    override fun draw() {
        println("Inside Circle::draw() method")
    }
    init {
        type = "Circle"
    }
}

object ShapeCache{
    private val shapeMap = hashMapOf<String?, NewShape>()

    fun loadCache(){
        val circle = NewCircle()
        val square = NewSquare()
        val rectangle = NewRectangle()

        shapeMap["1"] = circle
        shapeMap["2"] = square
        shapeMap["3"] = rectangle

    }

    fun getShapeById(id: String): NewShape {
        val cacheShape: NewShape? = shapeMap[id]
        return cacheShape?.clone() as NewShape
    }
}

fun main() {
    ShapeCache.loadCache()
    val cloneShape: NewShape = ShapeCache.getShapeById("2")
    println(cloneShape.type)
}