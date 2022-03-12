package com.paulo.desginpattern.creational.factoryMethod.realExample

class BancoCaixa {

    private lateinit var boleto: Boleto

    fun gerarBoleto(vencimento: Vencimento, valor: Float): Boleto {
        boleto = when (vencimento) {
            Vencimento.DEZ -> BancoCaixaBoleto10Dias(valor)
            Vencimento.VINTE -> BancoCaixaBoleto20Dias(valor)
            Vencimento.TRINA -> BancoCaixaBoleto30Dias(valor)
        }

        println("""
            Boleto gerado com sucesso no valor de R$ $valor
            Juros:: ${boleto.calculaJuros()}
            Desc:: ${boleto.calculaDesconto()}
            Multa:: ${boleto.calculaJuros()}
            """)

        return boleto
    }
}