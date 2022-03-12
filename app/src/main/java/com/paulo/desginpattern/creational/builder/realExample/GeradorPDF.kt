package com.paulo.desginpattern.creational.builder.realExample

data class GeradorPDF(
    var pageOrientation: String = "portrait",
    var unit: String = "mm",
    var pageSizeX: Int = 210,
    var pageSizeY: Int = 210,
    var marginTop: Int = 10,
    var marginBottom: Int = 10,
    var marginRight: Int = 20,
    var marginLeft: Int = 20,
    var hasHeader: Boolean = false,
    var headerHeight: Int = 0,
    var hasFooter: Boolean = false,
    var footerHeight: Int = 0,
    var pageColor: String = "#FFF",
    var encode: String = "UTF-8"
)