package com.paulo.desginpattern.behaviour.observer.example

interface Subject {
    fun registerObserver(observer: Observer)
    fun removerObserver(observer: Observer)
    fun notifyObservers()
}