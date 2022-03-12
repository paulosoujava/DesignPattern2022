package com.paulo.desginpattern.creational.builder.realExample

class Director(private val builder: BuilderStepPDF) {

    fun trocar(builder: BuilderStepPDF) {
        when (builder) {
            is BuilderA3 -> BuilderA3()
            else -> BuilderA4()
        }
    }

    fun getPDF() = builder.gerarPDF()
}