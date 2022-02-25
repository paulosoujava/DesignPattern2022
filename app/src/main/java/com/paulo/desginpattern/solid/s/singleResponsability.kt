package com.paulo.desginpattern.solid.s
/*
Princípio da Responsabilidade Única
Uma classe deve ter um, e somente um, motivo para mudar
 */

fun String.isEmailValid() = this.contains('@')
fun String.isPasswordValid() = this.length > 4


class Login(val email: String, val password: String)

// responsavel unica de autenticacao
class AuthenticationService(private val login: Login) {
    fun validateLogin(): Boolean {
        return login.email.isEmailValid() && login.password.isPasswordValid()
    }
}