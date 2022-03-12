package com.paulo.desginpattern.creational.builder.realExample

class BuilderA3() : BuilderStepPDF{
    private val geradorPDF: GeradorPDF = GeradorPDF()

    override fun configFooter() {
        geradorPDF.footerHeight = 10
        geradorPDF.hasFooter = true

    }

    override fun configMargin() {
        geradorPDF. marginTop = 5
        geradorPDF. marginBottom = 5
        geradorPDF. marginRight = 10
        geradorPDF. marginLeft = 10
    }

    override fun configOrientationPage() {
        geradorPDF.pageOrientation = "portrait"
        geradorPDF. unit = "mm"
    }

    override fun configEncode() {
        geradorPDF. pageColor = "#FFFEE"
        geradorPDF. encode = "UTF-16"
    }


    override fun gerarPDF(): GeradorPDF {
        return geradorPDF
    }
}