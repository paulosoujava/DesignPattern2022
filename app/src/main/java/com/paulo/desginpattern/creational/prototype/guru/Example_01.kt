package com.paulo.desginpattern.creational.prototype.guru

import java.util.*

abstract class Shape {
    var x = 0
    var y = 0
    var color: String? = null

    constructor() {}
    constructor(target: Shape?) {
        if (target != null) {
            x = target.x
            y = target.y
            color = target.color
        }
    }

    abstract fun clone(): Shape
    override fun equals(object2: Any?): Boolean {
        if (object2 !is Shape) return false
        val shape2 = object2
        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color)
    }
}
class Circle : Shape {
    var radius = 0

    constructor() {}
    constructor(target: Circle?) : super(target) {
        if (target != null) {
            radius = target.radius
        }
    }

    override fun clone(): Shape {
        return Circle(this)
    }

    override fun equals(object2: Any?): Boolean {
        if (object2 !is Circle || !super.equals(object2)) return false
        return object2.radius == radius
    }
}
class Rectangle : Shape {
    var width = 0
    var height = 0

    constructor() {}
    constructor(target: Rectangle?) : super(target) {
        if (target != null) {
            width = target.width
            height = target.height
        }
    }

    override fun clone(): Shape {
        return Rectangle(this)
    }

    override fun equals(object2: Any?): Boolean {
        if (object2 !is Rectangle || !super.equals(object2)) return false
        val shape2 = object2
        return shape2.width == width && shape2.height == height
    }
}
object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val shapes: MutableList<Shape> = ArrayList()
        val shapesCopy: MutableList<Shape> = ArrayList()
        val circle = Circle()
        circle.x = 10
        circle.y = 20
        circle.radius = 15
        circle.color = "red"
        shapes.add(circle)
        val anotherCircle = circle.clone() as Circle
        shapes.add(anotherCircle)
        val rectangle = Rectangle()
        rectangle.width = 10
        rectangle.height = 20
        rectangle.color = "blue"
        shapes.add(rectangle)
        cloneAndCompare(shapes, shapesCopy)
    }

    private fun cloneAndCompare(shapes: List<Shape>, shapesCopy: MutableList<Shape>) {
        for (shape in shapes) {
            shapesCopy.add(shape.clone())
        }
        for (i in shapes.indices) {
            if (shapes[i] !== shapesCopy[i]) {
                println("$i: Shapes are different objects (yay!)")
                if (shapes[i].equals(shapesCopy[i])) {
                    println("$i: And they are identical (yay!)")
                } else {
                    println("$i: But they are not identical (booo!)")
                }
            } else {
                println("$i: Shape objects are the same (booo!)")
            }
        }
    }
}


class BundledShapeCache {
    private val cache: MutableMap<String, Shape> = HashMap()
    fun put(key: String, shape: Shape): Shape {
        cache[key] = shape
        return shape
    }

    operator fun get(key: String): Shape {
        return cache[key]!!.clone()
    }

    init {
        val circle = Circle()
        circle.x = 5
        circle.y = 7
        circle.radius = 45
        circle.color = "Green"
        val rectangle = Rectangle()
        rectangle.x = 6
        rectangle.y = 9
        rectangle.width = 8
        rectangle.height = 10
        rectangle.color = "Blue"
        cache["Big green circle"] = circle
        cache["Medium blue rectangle"] = rectangle
    }
}
object Demo2 {
    @JvmStatic
    fun main(args: Array<String>) {
        val cache = BundledShapeCache()
        val shape1 = cache["Big green circle"]
        val shape2 = cache["Medium blue rectangle"]
        val shape3 = cache["Medium blue rectangle"]
        if (shape1 !== shape2 && !shape1.equals(shape2)) {
            println("Big green circle != Medium blue rectangle (yay!)")
        } else {
            println("Big green circle == Medium blue rectangle (booo!)")
        }
        if (shape2 !== shape3) {
            println("Medium blue rectangles are two different objects (yay!)")
            if (shape2.equals(shape3)) {
                println("And they are identical (yay!)")
            } else {
                println("But they are not identical (booo!)")
            }
        } else {
            println("Rectangle objects are the same (booo!)")
        }
    }
}