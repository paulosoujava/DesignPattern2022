package com.paulo.desginpattern.behaviour.observer.example

class Email {
     fun enviar(observer: Observer, message: String) {
        println("--------------------------------")
        println(
            """
            Email: ${observer.getEmail()}
            Enviado para: ${observer.getName()}
            Mensagem: $message
            """
        )
    }
}