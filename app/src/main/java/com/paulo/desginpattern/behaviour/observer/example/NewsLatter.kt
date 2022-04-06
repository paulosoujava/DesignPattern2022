package com.paulo.desginpattern.behaviour.observer.example

class NewsLatter: Subject {

    private val observers = mutableListOf<Observer>()
    private val messages = mutableListOf<String>()

    /*Adiciona um objeto a lista de observers a serem notificados
      quando uma nova mensagem for inserida na newsletter. */
    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    /*Remove um objeto a lista de observers a serem notificados
      quando uma nova mensagem for inserida na newsletter. */
    override fun removerObserver(observer: Observer) {
        observers.remove(observer)
    }
    //Notifica todos os observer sobre a nova mensagem da newsletter.
    override fun notifyObservers() {
        observers.forEach {
            it.update(messages.last())
        }
    }
    /*Adiciona uma nova mensagem a newsletter e solicita que todos
         os observers sejam notificados */
    fun addMessage(message: String){
        messages.add(message)
        notifyObservers()
    }
}