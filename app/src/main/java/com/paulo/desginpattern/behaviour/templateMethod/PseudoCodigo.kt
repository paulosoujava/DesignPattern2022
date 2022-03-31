package com.paulo.desginpattern.behaviour.templateMethod

/*
O Template Method é um padrão de projeto comportamental que define o esqueleto de um algoritmo na
 superclasse mas deixa as subclasses sobrescreverem etapas específicas do algoritmo sem modificar
 sua estrutura.


 // A classe abstrata define um método padrão que contém um
// esqueleto de algum algoritmo composto de chamadas, geralmente
// para operações abstratas primitivas. Subclasses concretas
// implementam essas operações, mas deixam o método padrão em si
// intacto.
class GameAI is
    // O método padrão define o esqueleto de um algoritmo.
    method turn() is
        collectResources()
        buildStructures()
        buildUnits()
        attack()

    // Algumas das etapas serão implementadas diretamente na
    // classe base.
    method collectResources() is
        foreach (s in this.builtStructures) do
            s.collect()

    // E algumas delas podem ser definidas como abstratas.
    abstract method buildStructures()
    abstract method buildUnits()

    // Uma classe pode ter vários métodos padrão.
    method attack() is
        enemy = closestEnemy()
        if (enemy == null)
            sendScouts(map.center)
        else
            sendWarriors(enemy.position)

    abstract method sendScouts(position)
    abstract method sendWarriors(position)

// Classes concretas têm que implementar todas as operações
// abstratas da classe base, mas não podem sobrescrever o método
// padrão em si.
class OrcsAI extends GameAI is
    method buildStructures() is
        if (there are some resources) then
            // Construir fazendas, depois quartéis, e então uma
            // fortaleza.

    method buildUnits() is
        if (there are plenty of resources) then
            if (there are no scouts)
                // Construir peão, adicionar ele ao grupo de
                // scouts (batedores).
            else
                // Construir um bruto, adicionar ele ao grupo
                // dos guerreiros.

    // ...

    method sendScouts(position) is
        if (scouts.length > 0) then
            // Enviar batedores para posição.


    method sendWarriors(position) is
        if (warriors.length > 5) then
            // Enviar guerreiros para posição.

// As subclasses também podem sobrescrever algumas operações com
// uma implementação padrão.
class MonstersAI extends GameAI is
    method collectResources() is
        // Monstros não coletam recursos.

    method buildStructures() is
        // Monstros não constroem estruturas.

    method buildUnits() is
        // Monstros não constroem unidades.


 */