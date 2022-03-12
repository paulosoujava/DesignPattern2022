package com.paulo.desginpattern.creational.builder.realExample

interface BuilderStepPDF {
   fun configFooter()
   fun configMargin()
   fun configOrientationPage()
   fun configEncode()
    fun gerarPDF(): GeradorPDF
}