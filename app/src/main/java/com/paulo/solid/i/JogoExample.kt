package com.paulo.solid.i

/*
Nunca jamais, force uma clase a implementar algo que ela nao vai usar
Exemplo errado abaixo
 */
interface Aves{
    fun localizacao( lat: Long, log: Long)
    fun altitude(alt: Long)
    fun renderizar()
}
class Papagaio: Aves{
    override fun localizacao(lat: Long, log: Long) = TODO()
    override fun altitude(alt: Long) = TODO()
    override fun renderizar() = TODO()
}
class Pinguim: Aves{
    override fun localizacao(lat: Long, log: Long) = TODO()
    // OPSSSSS PINGUM NAO VOA AQUI ESTA O ERRO
    override fun altitude(alt: Long) = TODO()
    override fun renderizar() = TODO()
}
// Isso viola o ISP e o LSP também
//VAMAOS A SOLUCAO 'especializacao'
interface GameAves{
    fun localizacao( lat: Long, log: Long)
     fun renderizar()
}
interface AvesQueVoam: GameAves{
    fun altitude(alt: Long)
}

class NewPapagaio: AvesQueVoam{
    override fun localizacao(lat: Long, log: Long) = TODO()
    override fun altitude(alt: Long) = TODO()
    override fun renderizar() = TODO()
}
class NewPinguim: GameAves{
    override fun localizacao(lat: Long, log: Long) = TODO()
    override fun renderizar() = TODO()
}