package com.paulo.desginpattern.behaviour.observer

/*
Observer
Também conhecido como: Observador, Assinante do evento, Event-Subscriber, Escutador, Listener

// A classe publicadora base inclui o código de gerenciamento de
// inscrições e os métodos de notificação.
class EventManager is
    private field listeners: hash map of event types and listeners

    method subscribe(eventType, listener) is
        listeners.add(eventType, listener)

    method unsubscribe(eventType, listener) is
        listeners.remove(eventType, listener)

    method notify(eventType, data) is
        foreach (listener in listeners.of(eventType)) do
            listener.update(data)

// O publicador concreto contém a verdadeira lógica de negócio
// que é de interesse para alguns assinantes. Nós podemos
// derivar essa classe a partir do publicador base, mas isso nem
// sempre é possível na vida real devido a possibilidade do
// publicador concreto já ser uma subclasse. Neste caso, você
// pode remendar a lógica de inscrição com a composição, como
// fizemos aqui.
class Editor is
    public field events: EventManager
    private field file: File

    constructor Editor() is
        events = new EventManager()

    // Métodos da lógica de negócio podem notificar assinantes
    // acerca de mudanças.
    method openFile(path) is
        this.file = new File(path)
        events.notify("open", file.name)

    method saveFile() is
        file.write()
        events.notify("save", file.name)

    // ...


// Aqui é a interface do assinante. Se sua linguagem de
// programação suporta tipos funcionais, você pode substituir
// toda a hierarquia do assinante por um conjunto de funções.
interface EventListener is
    method update(filename)

// Assinantes concretos reagem a atualizações emitidas pelo
// publicador a qual elas estão conectadas.
class LoggingListener implements EventListener is
    private field log: File
    private field message: string

    constructor LoggingListener(log_filename, message) is
        this.log = new File(log_filename)
        this.message = message

    method update(filename) is
        log.write(replace('%s',filename,message))

class EmailAlertsListener implements EventListener is
    private field email: string
    private field message: string

    constructor EmailAlertsListener(email, message) is
        this.email = email
        this.message = message

    method update(filename) is
        system.email(email, replace('%s',filename,message))


// Uma aplicação pode configurar publicadores e assinantes
// durante o tempo de execução.
class Application is
    method config() is
        editor = new Editor()

        logger = new LoggingListener(
            "/path/to/log.txt",
            "Someone has opened the file: %s")
        editor.events.subscribe("open", logger)

        emailAlerts = new EmailAlertsListener(
            "admin@example.com",
            "Someone has changed the file: %s")
        editor.events.subscribe("save", emailAlerts)
 */