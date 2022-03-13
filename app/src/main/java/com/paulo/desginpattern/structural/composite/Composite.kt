package com.paulo.desginpattern.structural.composite

import com.paulo.desginpattern.creational.prototype.Circle

/*
Composite é um padarão de projeto estrutural que permite que
você componha objetos em estrutura de arvores e então trabalhe
com essa estrutura como se ela fossem objetos individuais
 */

// A interface componente declara operações comuns para ambos os objetos simples e
// complexos de uma composição
interface Graphic{
    fun move(x:Int, y:Int)
    fun draw()
}
/*
A classe folha representa objetos finais de uma composição
Um objeto folha não pode ter quaisquer sub-objetos
Geralmente, são os objetos folha que fazem o verdadeiro trabalho, enquanto
que os objetos composite somente delegam para seus sub componentes
 */
class Dot(val x:Int, val y:Int) : Graphic {
    var xX: Int = 0
    var yY: Int = 0
    override fun move(x: Int, y: Int) {
        this.xX += x
        this.yY += y
    }

    override fun draw() {
        //desenhar um ponto X, Y
    }
}
class Circle(val x:Int, val y:Int) : Graphic {
    var xX: Int = 0
    var yY: Int = 0
    override fun move(x: Int, y: Int) {
        this.xX += x
        this.yY += y
    }

    override fun draw() {
        //desenhar um ponto X, Y
    }
}
/*
A classe composite representa componente complexos que podem
ter filhos, Objetos composite geralmente delegam o verdadeiro trabalho
para seus filhos e então soman o resultado
 */
class CompoundGraphic : Graphic {
    var children = mutableListOf<Graphic>()

    /*
    um objeto compostie pode adicionar ou remover outros
    componentes ( tanto simples como complexos) para ou de lista de filhos
     */


    fun add(child: Graphic){
        // adiciona um filho para o vetor de filhos
        children.add(child)
    }
    fun remove(child: Graphic){
        children.remove(child)
    }

    override fun move(x: Int, y: Int) {
        children.forEach {
            it.move(x,y)
        }
    }

    override fun draw() {
        /*
        1 - Para cada componente filho:
            - Desenhe o componente.
            - Atualize o retângulo limitante
        2 - Desenhe um retângulo tracejando usando as limitantes


        O codigo cliente trabalha com todos os componentes através de suas interfaces base.
        Dessa forma o código cliente pode suportar componentes folha simples e composites complexos

         */
    }
}
class ImageEditor {
    var all = CompoundGraphic()

    fun load(){
        all.add( Dot(1,2))
        all.add( Circle(1,2))

        //combina componentes selecionados em um componente composite complexo

        fun groupSelected( components: CompoundGraphic){
            val group = CompoundGraphic()
                CompoundGraphic().children.forEach{
                group.add(it)
                all.remove(it)
            }
            all.add(group)
                //todos os componentes serão desenhados
            all.draw()
        }
    }
}