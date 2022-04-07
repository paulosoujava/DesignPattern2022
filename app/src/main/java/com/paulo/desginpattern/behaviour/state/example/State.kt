package com.paulo.desginpattern.behaviour.state.example

interface State {
    fun sucessoAoPager()
    fun cancelarPedido()
    fun despacharPedido()
}