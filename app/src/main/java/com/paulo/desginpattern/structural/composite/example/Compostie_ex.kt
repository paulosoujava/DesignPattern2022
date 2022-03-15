package com.paulo.desginpattern.structural.composite.example

/*
Compose objects into tree structures
works the core functionality can  be represented as a tree
manipulate many objects as a single one
 */

open class Equipment(
    open val price: Int,
    open val name: String
)

open class Composite(name: String) : Equipment(0, name) {
    private val equipments = ArrayList<Equipment>()

    override val price: Int
        get() = equipments.sumOf { it.price }

    fun add(equipment: Equipment) = apply { equipments.add(equipment) }
}

class Computer : Composite("PC")
class Processor : Equipment(100, "Processor")
class HardDrive : Equipment(250, "Hard Drive")
class Memory : Composite("Memory")
class ROM : Equipment(100, "Read Only Memory")
class RAM : Equipment(75, "Read Access Memory")


fun main() {
    val memory = Memory()
        .add(ROM())
        .add(RAM())
    val pc = Computer()
        .add(memory)
        .add(Processor())
         .add(HardDrive())

    println("PC price ${pc.price}")
}