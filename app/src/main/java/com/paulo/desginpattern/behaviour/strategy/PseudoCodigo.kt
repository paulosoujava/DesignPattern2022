package com.paulo.desginpattern.behaviour.strategy

/*
O Strategy é um padrão de projeto comportamental que permite que você defina uma família de algoritmos,
coloque-os em classes separadas, e faça os objetos deles intercambiáveis.

// A interface estratégia declara operações comuns a todas as
// versões suportadas de algum algoritmo. O contexto usa essa
// interface para chamar o algoritmo definido pelas estratégias
// concretas.
interface Strategy is
    method execute(a, b)

// Estratégias concretas implementam o algoritmo enquanto seguem
// a interface estratégia base. A interface faz delas
// intercomunicáveis no contexto.
class ConcreteStrategyAdd implements Strategy is
    method execute(a, b) is
        return a + b

class ConcreteStrategySubtract implements Strategy is
    method execute(a, b) is
        return a - b

class ConcreteStrategyMultiply implements Strategy is
    method execute(a, b) is
        return a * b

// O contexto define a interface de interesse para clientes.
class Context is
    // O contexto mantém uma referência para um dos objetos
    // estratégia. O contexto não sabe a classe concreta de uma
    // estratégia. Ele deve trabalhar com todas as estratégias
    // através da interface estratégia.
    private strategy: Strategy

    // Geralmente o contexto aceita uma estratégia através do
    // construtor, e também fornece um setter para que a
    // estratégia possa ser trocado durante o tempo de execução.
    method setStrategy(Strategy strategy) is
        this.strategy = strategy

    // O contexto delega algum trabalho para o objeto estratégia
    // ao invés de implementar múltiplas versões do algoritmo
    // por conta própria.
    method executeStrategy(int a, int b) is
        return strategy.execute(a, b)


// O código cliente escolhe uma estratégia concreta e passa ela
// para o contexto. O cliente deve estar ciente das diferenças
// entre as estratégia para que faça a escolha certa.
class ExampleApplication is
    method main() is
        Cria um objeto contexto.

        Lê o primeiro número.
        Lê o último número.
        Lê a ação desejada da entrada do usuário

        if (action == addition) then
            context.setStrategy(new ConcreteStrategyAdd())

        if (action == subtraction) then
            context.setStrategy(new ConcreteStrategySubtract())

        if (action == multiplication) then
            context.setStrategy(new ConcreteStrategyMultiply())

        result = context.executeStrategy(First number, Second number)

        Imprimir resultado.

 */