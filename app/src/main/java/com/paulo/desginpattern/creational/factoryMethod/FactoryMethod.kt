package com.paulo.desginpattern.creational.factoryMethod
/*
Também conhecido como: Método Fábrica, Cosntrutor Virtual
É um padrão criacional para criar objetos em uma super classe,
mas permite que as subclasses alterem o tipo de objetos que serão criados
 */




/*
A classe criadora declara o método fábrica que deve retornar um objeto
de uma classe produto. As subclasses da criadora geralmente fornecem a
implementação desse método
 */
abstract class Dialog {

    fun render() {
        //chame o metodo fabrica para criar um objeto produto
        val okButton = createButton()
        println("Renderizando o ${okButton.onClick()} ${okButton.render()}")
    }

    //
    /*
     a criadora pode tbm oferecer alguma implementacao padrao do factory method

    Observe que apesar do seu nome, a principla responsabilidade da criadora nao é criar
    produtos. ELa geralmente contem alguma logica de negocio central que depende
    dos objetos produto retornados pelo metodo fabrica
    As subclasses podem mudar indiretamente essa logica de negocio ao sobrescreverem o metodo
    fabrica e retornarem um tipo diferente de produto dele
     */
    abstract fun createButton(): Button
}

//criadores concretos sobrescrevem o metodo fabrica para mudar o tipo de produto resultante
class WindowsDialog : Dialog() {
    override fun createButton(): Button = WindowsButton()
}

class WebDialog : Dialog() {
    override fun createButton(): Button = HtmlButton()
}

// a interface do produto declara as operacoes que todos os produtos concretos devem implementar
interface Button {
    fun render()
    fun onClick()
}

// Produtos concretos fornecem varias implementacoes da interface do produto
class HtmlButton : Button {
    override fun render() {
        TODO("Not yet implemented")
    }

    override fun onClick() {
        TODO("Not yet implemented")
    }
}

class WindowsButton : Button {
    //rednderiza no estilo windows
    override fun render() {
        TODO("Not yet implemented")
    }

    //vincula o click ao sist. nativo
    override fun onClick() {
        TODO("Not yet implemented")
    }
}

fun readApplication() = "WIN"

fun main() {
    //a aplicacao seleciona um tipo de criador dependendo da
    //configuraçao atual ou definicoes de ambiente
    val dialog = when (readApplication()) {
        "WIN" -> {
            WindowsDialog()
        }
        else -> {
            WebDialog()
        }
    }
    /*
    O codigo cliente trabalha com uma isntancia de uma criador concreto
    ainda que com  sua interface base, Desde que o clicente continue trabalhando com a criadora
    atraves da interface base, voce pode passar qualquer subclasse da criadora

    */
    dialog.render()
}