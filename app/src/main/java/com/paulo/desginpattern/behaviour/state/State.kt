package com.paulo.desginpattern.behaviour.state

/*
An objecct changes its behaviour based on an internal state
At any moment, there's a finite number of states a program can ne in
State can be encapsulated in an object
 */

sealed class AuthorizationState
object Unauthorized: AuthorizationState()
class Authorized(val username: String): AuthorizationState()

class AuthorizationPresenter{
    private var state: AuthorizationState = Unauthorized

    val isAuthorized: Boolean
    get() = when(state){
        is Authorized -> true
        is Unauthorized -> false
    }

    val username: String
    get(){
        return when ( val state: AuthorizationState = this.state){
            is Authorized -> state.username
            is Unauthorized -> "Unknown"
        }
    }
    fun loginUser(username: String){
        state = Authorized(username)
    }
    fun logoutUser(){
        state = Unauthorized
    }

    override fun toString()= "User $username is logged in: $isAuthorized"
}

fun main() {
    val authorizationPresenter = AuthorizationPresenter()
    authorizationPresenter.loginUser("admin")
    println(authorizationPresenter)

    println("Check state ${authorizationPresenter.isAuthorized}")
    println("Check state ${authorizationPresenter.username} == admin")

    authorizationPresenter.logoutUser()
    println("Check state ${authorizationPresenter.isAuthorized}")
    println("Check state ${authorizationPresenter.username} == Unknown")

}