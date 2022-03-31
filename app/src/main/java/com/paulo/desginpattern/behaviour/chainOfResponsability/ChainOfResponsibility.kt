package com.paulo.desginpattern.behaviour.chainOfResponsability

/*
Define a chain of handler to process a request
Each handler contanis a reference to the next handler
Each handler decides to process the request AND /OR pass it on
Request can be of different types
 */

interface HandlerChain {
    fun addHeader(inputHeader: String): String
}

class AuthenticationHeader(val token: String?, var next: HandlerChain? = null) : HandlerChain {
    override fun addHeader(inputHeader: String)="$inputHeader\nAuthorization: $token"
        .let{next?.addHeader(it) ?: it}
}

class ContentTypeHeader(val contentType: String, var next: HandlerChain? = null): HandlerChain{
    override fun addHeader(inputHeader: String)="$inputHeader\nContentType: $contentType"
        .let{next?.addHeader(it) ?: it}
}

class CBodyPayloadHeader(val body: String, val next: HandlerChain? = null): HandlerChain{
    override fun addHeader(inputHeader: String)="$inputHeader\nBody: $body"
        .let{next?.addHeader(it) ?: it}
}

fun main() {
    val authenticationHeader = AuthenticationHeader("123123")
    val contentTypeHeader = ContentTypeHeader("json")
    val bodyPayloadHeader = CBodyPayloadHeader("Body:{\"username\" = \"paulo\"}")

    authenticationHeader.next = contentTypeHeader
    contentTypeHeader.next = bodyPayloadHeader

    val messageWithAuthentication = authenticationHeader.addHeader("Headers with authentication")
    println(messageWithAuthentication)

    println("----------")
    val messageWithoutAuthentication = contentTypeHeader.addHeader("Header without authentication")
    println(messageWithoutAuthentication)
}