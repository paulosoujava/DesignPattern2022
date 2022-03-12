package com.paulo.desginpattern.creational.factoryMethod

/*
Provides a way to access functionality without caring about implementation
Separation of concerns
Allows for testability
 */
sealed class Country {
    object Canada : Country()
}

object Spain : Country()
object Greece : Country()
object Brazil : Country()
data class Usa(val someProperty: String) : Country()

class Currency(
    val code: String
)

object CurrencyFactory {
    fun currencyForCountry(country: Country): Currency =
        when (country) {
            is Greece -> Currency("EUR")
            is Spain -> Currency("EUR")
            is Usa -> Currency("USD")
            is Country.Canada -> Currency("CAD")
            else -> Currency("REAL")
        }
}

fun main() {
    val geekCurrency: String = CurrencyFactory.currencyForCountry(Greece).code
    println("Greek  currency $geekCurrency")
    val brCurrency: String = CurrencyFactory.currencyForCountry(Brazil).code
    println("Brazil  currency $brCurrency")
}