package com.paulo.desginpattern.structural.adapter

/*
Converts the interface of a class into another interface the client expects
Convert data from one format int another
Used extensively in android
 */

data class  DisplayDataType( val index: Float, val data: String)

class DataDisplay{
    fun displayData( data: DisplayDataType){
        println("Data is displayed ${data.index} - ${data.data}")
    }
}

data class DatabaseData(val position: Int, val amount: Int)

class DatabaseGenerator{
    fun generateData(): List<DatabaseData>{
        val list = arrayListOf<DatabaseData>()
        list.add( DatabaseData(1,2))
        list.add( DatabaseData(2,23))
        list.add( DatabaseData(3,4))
        list.add( DatabaseData(4,5))

        return list
    }
}


interface DatabaseDataConverter{
    fun convertData(data: List<DatabaseData>): List<DisplayDataType>
}

class DataDisplayAdapter(val display: DataDisplay): DatabaseDataConverter{
    override fun convertData(data: List<DatabaseData>): List<DisplayDataType> {
        val returnList = arrayListOf<DisplayDataType>()
        data.forEach {
            val ddt = DisplayDataType(it.position.toFloat(), it.amount.toString())
            returnList.add(ddt)
            display.displayData(ddt)
        }
        return returnList
    }
}

fun main() {
    val generate = DatabaseGenerator()
    val generatedData = generate.generateData()
    val adapter = DataDisplayAdapter(DataDisplay())
    val convertData = adapter.convertData(generatedData)
}