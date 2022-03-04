package com.paulo.solid.d

class ConnectionDBSQL

class PasswordReminder() {
    private var dbConnection: ConnectionDBSQL = ConnectionDBSQL()
}
/*
Acima deixamos que a classe PasswordReminder instancia a ConnectionDBSQL
ao qual nos conecta com o banco de dados do MySQL, deixando assim
um alto grau de acomplamento, damos a responsabilidade a classe
PasswordReminder em criar a instancia de ConnectionDBSQL e se tivessemos
que reaproveitar esta classe em outro sistema  com um outro banco não daria,
acomplamos demais
Jeito Correto:
 */

interface DBConnection {
    fun connect()
}

class MySQL : DBConnection {
    override fun connect() = TODO()
}

class Postgres : DBConnection {
    override fun connect() = TODO()
}

class Oracle : DBConnection {
    override fun connect() = TODO()
}

class LembrarSenha(ConnectionDBSQL: DBConnection)
/*
Prontinho agora passamos uma abstracao de conecao ao banco sendo que não me interessa
qual o banco vamos usar desde que tenha o que eu precisoc
 */