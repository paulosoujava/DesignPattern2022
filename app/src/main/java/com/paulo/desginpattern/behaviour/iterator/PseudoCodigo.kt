package com.paulo.desginpattern.behaviour.iterator
/*
O Iterador é um padrão de projeto comportamental que permite a passagem sequencial através de uma
estrutura de dados complexa sem expor seus detalhes internos.

// A interface da coleção deve declarar um método fábrica para
// produzir iteradores. Você pode declarar vários métodos se há
// diferentes tipos de iteração disponíveis em seu programa.
interface SocialNetwork is
    method createFriendsIterator(profileId):ProfileIterator
    method createCoworkersIterator(profileId):ProfileIterator


// Cada coleção concreta é acoplada a um conjunto de classes
// iterador concretas que ela retorna. Mas o cliente não é, uma
// vez que a assinatura desses métodos retorna interfaces de
// iterador.
class Facebook implements SocialNetwork is
    // ...o grosso do código da coleção deve vir aqui...

    // Código de criação do iterador.
    method createFriendsIterator(profileId) is
        return new FacebookIterator(this, profileId, "friends")
    method createCoworkersIterator(profileId) is
        return new FacebookIterator(this, profileId, "coworkers")


// A interface comum a todos os iteradores.
interface ProfileIterator is
    method getNext():Profile
    method hasMore():bool


// A classe iterador concreta.
class FacebookIterator implements ProfileIterator is
    // O iterador precisa de uma referência para a coleção que
    // ele percorre.
    private field facebook: Facebook
    private field profileId, type: string

    // Um objeto iterador percorre a coleção independentemente
    // de outros iteradores. Portanto ele tem que armazenar o
    // estado de iteração.
    private field currentPosition
    private field cache: array of Profile

    constructor FacebookIterator(facebook, profileId, type) is
        this.facebook = facebook
        this.profileId = profileId
        this.type = type

    private method lazyInit() is
        if (cache == null)
            cache = facebook.socialGraphRequest(profileId, type)

    // Cada classe iterador concreta tem sua própria
    // implementação da interface comum do iterador.
    method getNext() is
        if (hasMore())
            currentPosition++
            return cache[currentPosition]

    method hasMore() is
        lazyInit()
        return currentPosition < cache.length


// Aqui temos outro truque útil: você pode passar um iterador
// para uma classe cliente ao invés de dar acesso a ela à uma
// coleção completa. Dessa forma, você não expõe a coleção ao
// cliente.
//
// E tem outro benefício: você pode mudar o modo que o cliente
// trabalha com a coleção no tempo de execução ao passar a ele
// um iterador diferente. Isso é possível porque o código
// cliente não é acoplado às classes iterador concretas.
class SocialSpammer is
    method send(iterator: ProfileIterator, message: string) is
        while (iterator.hasMore())
            profile = iterator.getNext()
            System.sendEmail(profile.getEmail(), message)


// A classe da aplicação configura coleções e iteradores e então
// os passa ao código cliente.
class Application is
    field network: SocialNetwork
    field spammer: SocialSpammer

    method config() is
        if working with Facebook
            this.network = new Facebook()
        if working with LinkedIn
            this.network = new LinkedIn()
        this.spammer = new SocialSpammer()

    method sendSpamToFriends(profile) is
        iterator = network.createFriendsIterator(profile.getId())
        spammer.send(iterator, "Very important message")

    method sendSpamToCoworkers(profile) is
        iterator = network.createCoworkersIterator(profile.getId())
        spammer.send(iterator, "Very important message")
 */