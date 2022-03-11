package com.paulo.desginpattern.structural.bridge

/*
O Bridge é um padrão de projeto estrutural uqe permite que você divida uma classe
grande ou um conjunto de classes intimamente ligadas em duas hierarquias separadas abstraçao
e implementaçao, que podem ser desenvolvidas independentemente umas das outras

 A abstraçao define a innterface para a parte controle das duas hierarquias de classe
 ELa mantém uma referência a um objeto da hirarquia de implementação e delega todo o trabalho
 real para esse objeto
 */

open class RemoteControl(open val device: Device) {

    fun togglePower(){
        if(device.isEnabled()){
            device.disable()
        }else{
            device.enable()
        }
    }

    fun volumeDown(){
        device.setVolume((device.getVolume() - 10))
    }
    fun volumeUp(){
        device.setVolume((device.getVolume() + 10))
    }
    fun channelUp(){
         device.setChannel((device.getChannel() + 1))
    }
    fun channelDown(){
        device.setChannel((device.getChannel() - 1))
    }
}
/*
Voce pode estender classes a partir dessa hierarquia
abastraçao idependentemente das classes de dispositivo
 */
class AdvanceRemoteControl(override val device: Device) : RemoteControl(device){
    fun mute(){
        device.setVolume(0)
    }
}
/*
A interface implementacao declara metodos comuns a todas as
classes concretas de implementacao, ela nao precisa coincidir
com a interface de abstracao, na verdade as duas interfaces podem
ser inteiramente diferentes, tipicamente a interface de implementacao
fornece apenas operacoes primitivas enquanto que a abstracao define operacoes de alto nivel
baseada naquelas primitivas
 */
interface Device {
    fun isEnabled():Boolean
    fun enable()
    fun disable()
    fun getVolume()
    fun setVolume(vol: Int)
    fun setChannel(ch: Int)
    fun getChannel()
}

//TOdos os dispositivos seguem a mesma interface
class Tv : Device{
    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun enable() {
        TODO("Not yet implemented")
    }

    override fun disable() {
        TODO("Not yet implemented")
    }

    override fun getVolume() {
        TODO("Not yet implemented")
    }

    override fun setVolume(vol: Int) {
        TODO("Not yet implemented")
    }

    override fun setChannel(ch: Int) {
        TODO("Not yet implemented")
    }

    override fun getChannel() {
        TODO("Not yet implemented")
    }

}

class Radio : Device{
    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun enable() {
        TODO("Not yet implemented")
    }

    override fun disable() {
        TODO("Not yet implemented")
    }

    override fun getVolume() {
        TODO("Not yet implemented")
    }

    override fun setVolume(vol: Int) {
        TODO("Not yet implemented")
    }

    override fun setChannel(ch: Int) {
        TODO("Not yet implemented")
    }

    override fun getChannel() {
        TODO("Not yet implemented")
    }

}

//Codigo cliente
fun main() {
    val tv = Tv()
    val remote = RemoteControl(tv)
    remote.togglePower()

    val radio = Radio()

    val advRemote = AdvanceRemoteControl(radio)
    advRemote.togglePower()
    advRemote.mute()


}












