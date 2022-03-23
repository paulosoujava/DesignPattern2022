package com.paulo.desginpattern.structural.facade

import java.io.File

/*
Também conhecido como: FAchada
Ele fornece uma interface simplificada para uma biblioteca, um framework, ou qualquer conjunto
complexo de classes
 */

/*
Essas são algumas classes de um framework complexo de um conversor de vídeo
de terceiros. Nós não controlamos aquele código, por tanto não podemos, simplifica-lo
 */
class Video
class OggCompressionCodec
class MPE4CompressionCodec
class AudioMixer {
    fun fix(result: Any): String = TODO()
}

object BitrateReader {
    fun read(filename: String, sourceCodec: Any) {}
    fun converter(buffer: Unit, destinationCodec: Any): Any {
        return TODO()
    }
}

//Nós criamos uma classe fachada para esconder a complexidade do framework
//atrás de uma interface simples.
//É uma troca entre funcionalidade e simplicidade
class VideoConverter {
    fun converter(filename: String, format: String): File {
        val file = VideFile(filename)
        val sourceCodec = CodecFactory.extract(file)
        val destinationCodec = if (format != "mp4") {
            OggCompressionCodec()
        } else {
            MPE4CompressionCodec()
        }
        val buffer = BitrateReader.read(filename, sourceCodec)
        var result = BitrateReader.converter(buffer, destinationCodec)
        result = (AudioMixer()).fix(result)

        return File(result)
    }
}
//As classes da aplicação dependem de um bilhão de classes
// fornecidas por um framework, vocÊ só precisa reescrever a classe fachada
fun main() {
    val convertor = VideoConverter()
    val mp4 = convertor.converter("funny-cats-video.ogg", "mp4")
    //mp4.save()
}

object CodecFactory {
    fun extract(file: VideFile): Any {
        return TODO()
    }

}

class VideFile(filename: String) {

}
