package com.paulo.desginpattern.behaviour.strategy

/*
A class behaviour or algorithm can be changed at run time
Object contain algorithm logic
COntext object tha cn handle algorithm objects
Useful when we want to be able to add functionality without changing program structure
 */

class Printer(private val stringFormatterStrategy: (String) -> String?){
    fun printString(string: String){
        println(stringFormatterStrategy(string))
    }
}

val lowerCaseFormatter = {it: String -> it.lowercase()}
val upperCaseFormatter = {it: String -> it.uppercase()}

fun main() {
    val input = "LOREM bla bal Upsu"
    val lower = Printer(lowerCaseFormatter)
    lower.printString(input)

    val upper = Printer(upperCaseFormatter)
    upper.printString(input)
}