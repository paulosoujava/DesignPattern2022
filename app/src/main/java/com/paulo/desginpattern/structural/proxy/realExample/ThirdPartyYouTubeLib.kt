package com.paulo.desginpattern.structural.proxy.realExample

interface ThirdPartyYouTubeLib {
    fun popularVideos(): HashMap<String?, Video?>
    fun getVideo(videoId: String?): Video?
}