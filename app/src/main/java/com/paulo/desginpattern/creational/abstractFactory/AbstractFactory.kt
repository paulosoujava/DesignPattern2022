package com.paulo.desginpattern.creational.abstractFactory

import com.paulo.desginpattern.creational.factoryMethod.Button

/*
Também conhecido como: Fabrica abstrata
O Abstract Factory é um padrão de projeto criacional que permite
que voce produza familias de objetos relacionados sem ter que especificar suas classes concretas
 */
interface  Vehicle{
    fun modelo(): String
    fun description()

}
interface Carro : Vehicle{
    fun portas(): String

}

class CarrroEsportivo : Carro {
    override fun portas()  = "5 PORTAS"

    override fun modelo()="GHYZ Turbo 9000Cv"

    override  fun description(){
        println(" Desc::Carro Esportivo -> ${portas()} - ${modelo()}")
    }
}

class CarroClassico : Carro {
    override fun portas()="DUAS PORTAS"

    override fun modelo() ="V2"

    override fun description(){
        println(" Desc::Carro Classico  -> ${portas()} - ${modelo()}")
    }
}

interface Moto : Vehicle {
    fun velocidade():String
}

class MotoEsportiva : Moto {
    override fun velocidade()= "1500Cc"
    override fun modelo()="Custom Rover "
    override fun description(){
        println(" Desc:: Moto Esportiva -> ${velocidade()} - ${modelo()}")
    }
}

class MotoClassica : Moto {
    override fun velocidade()= "400Cc"

    override fun modelo()="Old Classic Rover "

    override fun description(){
        println(" Desc:: Moto Classica -> ${velocidade()} - ${modelo()}")
    }
}

interface VehicleFactory {
    fun criarCarro(): Carro
    fun criarMoto(): Moto
}

object ModeloClassicos: VehicleFactory{
    override fun criarCarro() = CarroClassico()
    override fun criarMoto() = MotoClassica()
}

object ModelosEsportivos : VehicleFactory{
    override fun criarCarro() = CarrroEsportivo()
    override fun criarMoto() = MotoEsportiva()

}

fun main() {
    val listVehicle = listOf(
        ModeloClassicos.criarCarro(),
        ModelosEsportivos.criarCarro(),
        ModeloClassicos.criarMoto(),
        ModelosEsportivos.criarMoto(),

    )

    listVehicle.forEach { it.description()   }
}

/*
Pseudo código
A interface fabrica asbtrata declara um conjunto de metodos que retorna diferentes produtos abstratos
Estes produtos sao chamados uma familia e estao relacionados por um tema ou conceito
de alto nivel. Produtos de uma familia sao geralmetne capazes de colaborar entre si
uma familia de produtos pode ter varias variantes, mas os produtos de uma variante sao incompativeis
com os produtos de outra varante

 */
interface GUIFactory {
    fun createButton(): Button1
    fun createCheckbox():Checkbox1
}

/*
AS fabricas concretas produzem uma familia de produtos que pertencem a uma unica variante
A fabrica garante que os produtos resultatntes sejam compativeis, assinaturas dos metodos
fabrica retornam um produto abstrato enquanto que dentro do etodo um produto
concreto é instanciado
 */
class WinFactory : GUIFactory{
    override fun createButton() = WinButton()
    override fun createCheckbox() = WinCheckbox()

}

//Cada fabrica concreta tem uma variante de produto correspondente
class MAcFactory : GUIFactory {
    override fun createButton() = MacButton()
    override fun createCheckbox() = MacCheckbox()
}

/*
Cada produto distindo de uma familia de produtos deve ter uma interface base
todas as variantes do produto devem implementar essa interface
 */
interface Button1{
    fun paint()
}
//Produtos concretos sao criados por fabricas cocretas correspondentes
class WinButton: Button1{
    //renderiza estilo windows
    override fun paint() =TODO("Not yet implemented")
}
class MacButton: Button1{
    //renderiza estilo MAc
    override fun paint() =TODO("Not yet implemented")
}
/*
Aqui esta a interface base de outro produto, todos os produtos
 podem interagir entre si, mas a interacao apropriada só é prossivel entre produtos da mesma
 variante concreta
 */
interface Checkbox1{
    fun paint()
}
class WinCheckbox: Checkbox1{
    //renderiza estilo windows
    override fun paint() =TODO("Not yet implemented")
}
class MacCheckbox: Checkbox1{
    //renderiza estilo MAc
    override fun paint() =TODO("Not yet implemented")
}
/*
O Codigo cliente trabalha com fabrica e produtos apenas atraves de tipos abstratos:
GUIFactory, Button1, Checkbox1
isso poermite que voce passe qualquer subclasse fabrica ou de produto para o codigo cliente sem quebra-lo
 */

class Application(private val factory: GUIFactory) {

   private lateinit var  button: Button1

    fun createUI(){
        this.button = factory.createButton()
    }
    fun paint(){
        this.button.paint()
    }
}
//A aplicacao seleciona o tipo de fabrica dependendo da atual configuracao do ambiente e cria o
// widget no tempo de execucao (geralmente no estagio de inicializacao)

fun fakeInitialization() = "MAC"
fun main2(){
    val factory = when( fakeInitialization() ){
        "MAC" ->{
             MAcFactory()
        }
        else ->
             WinFactory()
    }
    val aplication = Application(factory)
    aplication.createUI()
    aplication.paint()

}