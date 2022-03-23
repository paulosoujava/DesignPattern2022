package com.paulo.desginpattern.structural.facade.realExample

import com.paulo.desginpattern.structural.facade.realExample.BitrateReader.convert
import com.paulo.desginpattern.structural.facade.realExample.BitrateReader.read
import com.paulo.desginpattern.structural.facade.realExample.CodecFactory.extract
import java.io.File

class MPEG4CompressionCodec1 : Codec {
    var type = "mp4"
}
class OggCompressionCodec1 : Codec {
    var type = "ogg"
}
object CodecFactory1 {
    fun extract(file: VideoFile): Codec {
        val type = file.codecType
        return if (type == "mp4") {
            println("CodecFactory: extracting mpeg audio...")
            MPEG4CompressionCodec()
        } else {
            println("CodecFactory: extracting ogg audio...")
            OggCompressionCodec()
        }
    }
}
object BitrateReader1 {
    fun read(file: VideoFile, codec: Codec?): VideoFile {
        println("BitrateReader: reading file...")
        return file
    }

    fun convert(buffer: VideoFile, codec: Codec?): VideoFile {
        println("BitrateReader: writing file...")
        return buffer
    }
}

class AudioMixer1 {
    fun fix(result: VideoFile?): File {
        println("AudioMixer: fixing audio...")
        return File("tmp")
    }
}
class VideoConversionFacade1 {
    fun convertVideo(fileName: String?, format: String): File {
        println("VideoConversionFacade: conversion started.")
        val file = VideoFile(fileName!!)
        val sourceCodec = extract(file)
        val destinationCodec: Codec
        destinationCodec = if (format == "mp4") {
            MPEG4CompressionCodec()
        } else {
            OggCompressionCodec()
        }
        val buffer = read(file, sourceCodec)
        val intermediateResult = convert(buffer, destinationCodec)
        val result = AudioMixer().fix(intermediateResult)
        println("VideoConversionFacade: conversion completed.")
        return result
    }
}

fun main() {
    val converter = VideoConversionFacade()
    val mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4")
    // ...
}