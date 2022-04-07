package com.paulo.desginpattern.behaviour.state.example

class Pedido {

    val aguardando: State
    val cancelado: State
    val pago: State
    val enviado: State

    var estadoAtual: State

    init {
        aguardando = AguardandoPagamentoState(this)
        cancelado = CanceladoState(this)
        pago = PagoState(this)
        enviado = EnviadoState(this)
        estadoAtual = aguardando
    }

    fun actualState() = when(estadoAtual){
        is AguardandoPagamentoState -> "Aguardando pagamento"
        is CanceladoState -> " Pagamento cancelado"
        is PagoState -> "Pedido pago"
        is EnviadoState -> "Pedido enviado"
        else -> "Error ao processar pedido"
    }
}