package com.paulo.desginpattern.structural.proxy.realExample


class YouTubeCacheProxy : ThirdPartyYouTubeLib {
    private val youtubeService: ThirdPartyYouTubeLib
    private var cachePopular = HashMap<String?, Video?>()
    private val cacheAll = HashMap<String?, Video?>()
    override fun popularVideos(): HashMap<String?, Video?> {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos()
        } else {
            println("Retrieved list from cache.")
        }
        return cachePopular
    }

    override fun getVideo(videoId: String?): Video? {
        var video = cacheAll[videoId]
        if (video == null) {
            video = youtubeService.getVideo(videoId)
            cacheAll[videoId] = video
        } else {
            println("Retrieved video '$videoId' from cache.")
        }
        return video
    }

    fun reset() {
        cachePopular.clear()
        cacheAll.clear()
    }

    init {
        youtubeService = ThirdPartyYouTubeClass()
    }
}