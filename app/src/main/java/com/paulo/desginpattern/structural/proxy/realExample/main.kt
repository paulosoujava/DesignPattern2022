package com.paulo.desginpattern.structural.proxy.realExample
/*
Proxy de cache
Neste exemplo, o padrão Proxy ajuda a implementar a inicialização preguiçosa e o cache em uma
biblioteca de terceiros de integração ineficiente do YouTube.
O proxy é inestimável quando você precisa adicionar alguns comportamentos adicionais
a uma classe cujo código não pode ser alterado.
O Proxy é um padrão de projeto estrutural que permite que você forneça um substituto ou um
 espaço reservado para outro objeto. Um proxy controla o acesso ao objeto original,
 permitindo que você faça algo ou antes ou depois do pedido chegar ao objeto original.
 */
object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val naiveDownloader = YouTubeDownloader(ThirdPartyYouTubeClass())
        val smartDownloader = YouTubeDownloader(YouTubeCacheProxy())
        val naive = test(naiveDownloader)
        val smart = test(smartDownloader)
        print("Time saved by caching proxy: " + (naive - smart) + "ms")
    }

    private fun test(downloader: YouTubeDownloader): Long {
        val startTime = System.currentTimeMillis()

        // User behavior in our app:
        downloader.renderPopularVideos()
        downloader.renderVideoPage("catzzzzzzzzz")
        downloader.renderPopularVideos()
        downloader.renderVideoPage("dancesvideoo")
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz")
        downloader.renderVideoPage("someothervid")
        val estimatedTime = System.currentTimeMillis() - startTime
        print(
            """
                Time elapsed: ${estimatedTime}ms
                
                """.trimIndent()
        )
        return estimatedTime
    }
}