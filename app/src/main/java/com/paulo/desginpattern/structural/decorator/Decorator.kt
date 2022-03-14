package com.paulo.desginpattern.structural.decorator

/*
O Decorator é um padrão de projeto estrutural que permite que você acople novos
comportamentos para objetos ao colocá-los de invólucros de objetos que contém
os comportamentos
 */

//A interface componente define iperações que podem ser alteradas por decoradores
interface DataSource {
    fun writeData(data: Any)
    fun readData(): Any
}

/*
Componentes concretos fornecem uma implementação padrão para as operações.
Pode haver diversas variações dessas classes em um programa
 */
class FileDataSource(path:String) : DataSource {
    override fun readData(): Any {
        TODO("Not yet implemented")
    }

    override fun writeData(data: Any) {
        TODO("Not yet implemented")
    }
}

/*
A classe Decorador base segue a mesma interface que os outros componentes
O propósito primário dessa classe é definir a interface que envolve todos os
decoradores concretos.
A implementação padrão do código de envolvimento pode também incluir um campo
para armazenar um componente envolvido e os meios para inicializá-lo
 */
open class DataSourceDecorator(private val dataSource: DataSource) : DataSource {
    override fun writeData(data: Any) {
        dataSource.writeData(data)
    }

    override fun readData(): Any {
        return dataSource.readData()
    }

}

/*
Decoradores concretos devem chamar métodos no objeto envolvido, mas podem adicionar
algo próprio paa o resultado. Os decoradores podem executar o comportamento adicional
tanto antes como depois da chamada ao objeto envolvido
 */

class EncryptionDecorator(dataSource: DataSource) : DataSourceDecorator(dataSource) {
    override fun writeData(data: Any) {
        super.writeData(data)
        /*
         1 - Encriptar os dados passados
         2 - Passar dados encriptados para o método writeData do objeto envolvido
         */
    }

    override fun readData(): Any {
        return super.readData()
        /*
        1 - Obter os dados do métodos readData do objeto envolvido.
        2 - Tentar decfrá-lo se for encriptado
        3 - Retornar o resultado
         */
    }
}

// Você pode envolver objetos em diversas camadas de decoradores
class CompressionDecorator(dataSource: DataSource) : DataSourceDecorator(dataSource){
    override fun writeData(data: Any) {
        super.writeData(data)
        /*
         1 - Encriptar os dados passados
         2 - Passar dados encriptados para o método writeData do objeto envolvido
         */
    }

    override fun readData(): Any {
        return super.readData()
        /*
        1 - Obter os dados do métodos readData do objeto envolvido.
        2 - Tentar decfrá-lo se for encriptado
        3 - Retornar o resultado
         */
    }
}

fun main() {

    val dumb ="any_valid_data_goe_here"
    var source = FileDataSource("somefile.dat")
    source.writeData(dumb)

    // O arquivo alvo foi escrito com dados simples
    val compress = CompressionDecorator(source)
    compress.writeData(dumb)
    //o arquivo alvo foi escrito com dados comprimidos

    val encrypt = EncryptionDecorator(source)
    // a variável fonte agora contém isso:
    // Encryption / Compression / FileDataSource
    encrypt.writeData(dumb)

    /*
    O arquivo foi escrito com dados comprimidos e encriptados
     */
}

/*
Opção 2. Código cliente que usa uma fonte de dados externa
Objetos SalaryManager não sabem e nem se importam sobre as
especificações de armazenamento de dados. Eles trabalham
com uma fonte de dados pré configurada recebida pelo configurador da aplicação
 */

class SalaryManager(private val source: DataSource){
    fun load(): Any {
        return source.readData()
    }
    fun save(){
        source.writeData("any_data")
    }
    // ... outros métodos úteis
}
/*
A aplicação pode montar diferentes pilhas de decoradores no tempo de execução,
dependendo da configuração ou ambiente
 */
class ApplicationConfigurator {
    fun configurationExample(data: DataSource) {
        val source = FileDataSource("salary.dat")
        val sourceDecorator: DataSource = if( data is EncryptionDecorator)
          EncryptionDecorator(source)
        else
            CompressionDecorator(source)

        val logger = SalaryManager(source)
        val salary = logger.load()
    }
}