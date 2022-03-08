package com.paulo.desginpattern.creational.prototipe

/*
Prototype tbm conhecido como, protótipo, clone
É um padrão criacional que permite copiar objetos existentes
sem fazer seu código ficar dependente de suas classes
 */
//Prototipo base
// O construtor do prototipo, um objeto novo é inicializado com valores do objeto existente
// a operaçao de clonagem retorna uma das subclasses Shape
abstract class Shape() {
    var x: Int = 0
    var y: Int = 0
    var color: String = ""
    abstract fun clone(): Shape
}
//Prototipo concreto. O metodo de clonagem cria um novo objeto e passa ele ao construtor até o
// contrutor terminar, ele tem um referencia ao clone fresco, portanto ninguém tem acesso ao clone
//parcilamente construido, isso faz com que o clone resultante seja consistente

class Rectangle(private val source: Rectangle? = null) : Shape() {
    var width = 0
    var height = 0

    init {
        this.width = source?.width ?: 0
        this.height = source?.height ?: 0
    }

    override fun clone(): Shape {
        return Rectangle(this)
    }

}

class Circle(private val source: Circle? = null) : Shape() {

    var radius: Int = source?.radius ?: 0


    override fun clone(): Shape {
        return Circle(this)
    }
}

//Em algum lugar dentro do código cliente
fun main() {
    val listOfShape = mutableListOf<Shape>()

    val circle = Circle()
    circle.x = 10
    circle.y = 10
    circle.radius = 20
    listOfShape.add(circle)

    val circleAnother = circle.clone()
    listOfShape.add(circleAnother)
    // circleAnother contem uma copia exata do objeto circle

    val rectangle = Rectangle()
    rectangle.width = 10
    rectangle.height = 10
    listOfShape.add(rectangle)
    val anotherRec = rectangle.clone()
    listOfShape.add(anotherRec)

    businessLogic(listOfShape)
}

fun businessLogic( listOfShapePass: List<Shape>) {
    val listOfShapeCopy = mutableListOf<Shape>()
    /*
    o prototipo arrasa porque permite que vc produza um copia de um objeto sem saber
    coisa alguma sobre seu tipo
     */
    /*
    por exemplo nos nao sabemos os elementos exatos na listOfShape, tudo que sabemos
    é que eles sao todos shapes mas graças ao polimorfismo quando nos chamamos o métofo
    clone em um shape o programa checa sua classe real e executa os metodos de clonagem
    apropriado definido naquela classe é por isso que obtemos clones apropriados ao inves de um conjnto
    de objetos shape simples

     */

    listOfShapePass.forEach {
        listOfShapeCopy.add(it.clone())
    }
    // a listOfShapeCopy conte cópias os filhos do vetor de shape
}
