package com.paulo.desginpattern.creational.builder

/*
Usar o padrão Builder só faz sentido quando seus produtos são
bem complexos e requerem configuracoes extensiva Os dois produtos
a seguir sao relacionados embora nao tenham uma inrterface comun
 */
class Car
/*
um carro pode ter um GPS, computador de bordo, e alguns assentos diferente
modelos (esporte, SUV, conversivel) podem ter diferentes funcionalidades instalada
ou equipadas
 */

class Manual

/*
Cada carro deve ter um manual do usuario correspondente a configuracao
do carro e descreve todas as funcionalidades
a interface builder especifica metodos para criar as diferentes partes de objetos produto
 */
interface Builder {
    fun reset()
    fun setSeats()
    fun setEngine()
    fun setTripComputer()
    fun setGPS()
}

/*
as classes concretas seguem a interface do builder e fornencem implementacoes especificas das
etapas de construcao seu programa pode ter algumas variacoes de builder
cada uma implementada de forma diferente
 */
class CarBuilder : Builder {
    lateinit var car: Car
    /*
    uma instancia do builder deve conter um objeto produto em branco na qual ela usa para montagem futura
     */

    init {
        this.reset()
    }

    // lima o objeto sendo construido
    override fun reset() {
        this.car = Car()
    }

    // todas as etapas da instancia trabalham com a mesma instancia de produto
    override fun setSeats() {
        TODO("define o numero de assentos")
    }

    override fun setEngine() {
        TODO("instala o motor")
    }

    override fun setTripComputer() {
        TODO("intala o computador de bordo")
    }

    override fun setGPS() {
        TODO("instala o GPS")
    }


/*
Builders concretos devem fornecer seus proprios metodos
para recuperar os resultados. Isso é porque vários tipos de
builders podem criar produtos interamente diferentes que nem sempre seguem
a mesma interface. POrtanto tais metodos nao podem ser declarados na interface
do builder( ao menos nao em uma linguagem de programacao de tipo estatico)

Geralmente apos retornar o resultado final para o cliente
espera-se que uma instancia de builder comece a produzir outro produto. É por isso que é
uma pratica comum chamar o metodo reset no final do corpo do metodo 'getProduct'
Contudo esse comportamento nao é obrigatorio e voce pode fazer seu builder esperar
por uma chamada explicita do reset a partir do código cliente antes de se livrar de
seu resultado anterior
 */

    fun getProduct(): Car {
        val product = this.car
        this.reset()
        return product
    }

}

/*
    ao contrario dos outros padroes criacionais, o Builder permite que vc contrua produtos
    que nao seguem uma interface comum
     */
class CarManualBuilder : Builder {

    lateinit var manual: Manual

    init {
        this.reset()
    }

    override fun reset() {
        this.manual = Manual()
    }

    override fun setSeats() {
        TODO("Documenta as funcionalidades deste metodo")
    }

    override fun setEngine() {
        TODO("Documenta as funcionalidades deste metodo")
    }

    override fun setTripComputer() {
        TODO("Documenta as funcionalidades deste metodo")
    }

    override fun setGPS() {
        TODO("Documenta as funcionalidades deste metodo")
    }
    fun getProduct(): Manual {
        val product = this.manual
        this.reset()
        return product
    }
}

/*
O Diretor é apenas responsavel por executar as etapas de contrucao em uma sequencia em particular.
Issso ajuda quando produzido produtos de acrodo com uma ordem especifica ou configuracao
A rigor a classe diretor é opcional ja que o cliente pode controlar os builders diretamente
 */
class Director(val builder: Builder) {
    /*
      o diretor trabalha com qualquer instancia builder que o
        o codigo cliente passar a ele, dessa forma o codigo cliente pode
        alterar o tipo final do produto recem momntado
     */


    /*
     O diretor pode construir diversas variacoes do produto usando as mesmas etapas de construcao
     */
    fun constructSport(builder: Builder) {
        builder.reset()
        builder.setEngine()
        builder.setGPS()
        builder.setSeats()
        builder.setTripComputer()
    }

    fun constructSUV(builder: Builder) {
        builder.reset()
        builder.setEngine()
        builder.setGPS()
    }
    /*
    O codigo cliente cria um objeto builder, passa ele para o diretor e entao inicia o processo de construcao
    O resultado final e recuperado do objeto builder
     */
}


fun main() {
    val builder = CarBuilder()
    val director = Director(builder)

    director.constructSUV(builder)
    val car = builder.getProduct()

    val manualBuilder = CarManualBuilder()
    director.constructSUV(manualBuilder)
    /*
    O produto final é frequentemente retornado de um objeto builder
    uma vez que o diretor não está ciente e não é dependente de builders e produtos concretos
     */
    val manual = manualBuilder.getProduct()
}