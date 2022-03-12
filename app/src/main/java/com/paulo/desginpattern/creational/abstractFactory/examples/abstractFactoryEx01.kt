package com.paulo.desginpattern.creational.abstractFactory

import java.lang.IllegalArgumentException

// Provides a way to access functionality without caring about implementation
// one level of abstraction over the factory pattern
// separation of concerns
// allow for testability

interface DataSource

class DatabaseDataSource : DataSource
class NetworkDataSource : DataSource

abstract class DataSourceFactory {
    abstract fun makeDataSource(): DataSource
    companion object {
        inline fun <reified T: DataSource> createFactory(): DataSourceFactory =
            when(T::class){
                DatabaseDataSource::class -> DatabaseFactory()
                NetworkDataSource::class -> NetworkFactory()
                else -> throw  IllegalArgumentException("Arghhh")
            }
    }
}

class NetworkFactory : DataSourceFactory() {
    override fun makeDataSource(): DataSource  = NetworkDataSource()


}

class DatabaseFactory : DataSourceFactory() {
    override fun makeDataSource(): DataSource = DatabaseDataSource()
}

fun main() {
    val datasourceFactory = DataSourceFactory.createFactory<DatabaseDataSource>()
    val datasource = datasourceFactory.makeDataSource()
    println("Created datasource ${datasource is DatabaseDataSource }")

    val datasourceFactoryNet = DataSourceFactory.createFactory<NetworkDataSource>()
    val datasourceNet = datasourceFactoryNet.makeDataSource()
    println("Created NetworkDataSource ${datasourceNet is NetworkDataSource }")
}

