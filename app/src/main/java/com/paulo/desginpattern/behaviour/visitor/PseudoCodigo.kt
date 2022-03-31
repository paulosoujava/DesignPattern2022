package com.paulo.desginpattern.behaviour.visitor

/*
O Visitor é um padrão de projeto comportamental que permite que você separe algoritmos dos objetos
 nos quais eles operam.

 // O elemento interface declara um método `accept` que toma a
// interface do visitante base como um argumento.
interface Shape is
    method move(x, y)
    method draw()
    method accept(v: Visitor)

// Cada classe concreta de elemento deve implementar o método
// `accept` de tal maneira que ele chama o método visitante que
// corresponde com a classe do elemento.
class Dot implements Shape is
    // ...

    // Observe que nós estamos chamando `visitDot`, que coincide
    // com o nome da classe atual. Dessa forma nós permitimos
    // que o visitante saiba a classe do elemento com o qual ele
    // trabalha.
    method accept(v: Visitor) is
        v.visitDot(this)

class Circle implements Shape is
    // ...
    method accept(v: Visitor) is
        v.visitCircle(this)

class Rectangle implements Shape is
    // ...
    method accept(v: Visitor) is
        v.visitRectangle(this)

class CompoundShape implements Shape is
    // ...
    method accept(v: Visitor) is
        v.visitCompoundShape(this)


// A interface visitante declara um conjunto de métodos
// visitantes que correspondem com as classes elemento. A
// assinatura de um método visitante permite que o visitante
// identifique a classe exata do elemento com o qual ele está
// lidando.
interface Visitor is
    method visitDot(d: Dot)
    method visitCircle(c: Circle)
    method visitRectangle(r: Rectangle)
    method visitCompoundShape(cs: CompoundShape)

// Visitantes concretos implementam várias versões do mesmo
// algoritmo, que pode trabalhar com todas as classes elemento
// concretas.
//
// Você pode usufruir do maior benefício do padrão Visitor
// quando estiver usando ele com uma estrutura de objeto
// complexa, tal como uma árvore composite. Neste caso, pode ser
// útil armazenar algum estado intermediário do algoritmo
// enquanto executa os métodos visitantes sobre vários objetos
// da estrutura.
class XMLExportVisitor implements Visitor is
    method visitDot(d: Dot) is
        // Exporta a ID do dot (ponto) e suas coordenadas de
        // centro.

    method visitCircle(c: Circle) is
        // Exporta a ID do circle (círculo), coordenadas do
        // centro, e raio.


    method visitRectangle(r: Rectangle) is
        // Exporta a ID do retângulo, coordenadas do topo à
        // esquerda, largura e altura.

    method visitCompoundShape(cs: CompoundShape) is
        // Exporta a ID da forma bem como a lista de ID dos seus
        // filhos.


// O código cliente pode executar operações visitantes sobre
// quaisquer conjuntos de elementos sem saber suas classes
// concretas. A operação accept (aceitar) direciona a chamada
// para a operação apropriada no objeto visitante.
class Application is
    field allShapes: array of Shapes

    method export() is
        exportVisitor = new XMLExportVisitor()

        foreach (shape in allShapes) do
            shape.accept(exportVisitor)
 */