package com.paulo.desginpattern.structural.adapter.realExample

class PagFacilAdapter: PagFacil(), Gateway {
    //nao é necessario implementar métodos aqui, a classe PagFacil já os implementa (Herança)
    // repare que os métodos da classe PagFacil são identicos a interface Gateway
}