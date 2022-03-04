package com.paulo.solid.o

// Começamos pelo jeito errado
class ContratoClt {
    fun salario(): Float = 0f
}

class Estagio {
    fun bolsaDeAuxilio(): Float = 0f
}

class FolhaDePagamento {
    private var saldo: Float = 0f

    fun calcular(contrato: Any) {
        if (contrato is ContratoClt) {
            saldo = contrato.salario()
        } else if (contrato is Estagio) {
            saldo = contrato.bolsaDeAuxilio()
        }
    }
}

/*
Para se aplicar a regra de negocio na FolhaDePAgamento precisamos ver de que tipo
é se a empresa decidir colocar mas tipos de pagamento tais como:
PJ / Cooperado, voce é obrigado a alterar o calcular da FolhaDePAgamento
quebrando assim o Open Closed do SOLID, não se adiciona novos comportamentos
a classe deve estar FECHADA para alteracao e ABERTA para extencao
Separe o comportamento 'extensivel' por tras de uma interface, inverta as dependencias
que alias é um principio tbm depency invertion

Vamos a Forma correta

 */
interface Remuneravel {
    fun remuneracao(): Float
}

class RemuneracaoCLT : Remuneravel {
    override fun remuneracao() = TODO()
}

class RemuneracaoEstagio : Remuneravel {
    override fun remuneracao() = TODO()
}

class RemuneracaoPJ : Remuneravel {
    override fun remuneracao() = TODO()
}

class NovaFolhaDePagamento {
    private var saldo: Float = 0f

    fun calcular(remuneravel: Remuneravel) {
        saldo = remuneravel.remuneracao()
    }
}
/*
COm isto isolamos o comportamento para que cada um seja responsavel por seu calculo,
podemo adicionar N tipos de 'remuneravel' isso é um design patter chamado strategy
 */