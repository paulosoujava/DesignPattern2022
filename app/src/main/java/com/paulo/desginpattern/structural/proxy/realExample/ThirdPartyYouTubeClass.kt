package com.paulo.desginpattern.structural.proxy.realExample

class ThirdPartyYouTubeClass : ThirdPartyYouTubeLib {
    override fun popularVideos(): HashMap<String?, Video?> {
        connectToServer("http://www.youtube.com")

        val randomVideos = HashMap<String?, Video?>()
        randomVideos["random_url"] = Video("1", "Random_Title" )


        return randomVideos
    }

    override fun getVideo(videoId: String?): Video? {
        connectToServer("http://www.youtube.com/$videoId")
        return getSomeVideo(videoId)
    }

    // -----------------------------------------------------------------------
    // Fake methods to simulate network activity. They as slow as a real life.
    private fun random(min: Int, max: Int): Int {
        return min + (Math.random() * (max - min + 1)).toInt()
    }

    private fun experienceNetworkLatency() {
        val randomLatency = random(5, 10)
        for (i in 0 until randomLatency) {
            try {
                Thread.sleep(100)
            } catch (ex: InterruptedException) {
                ex.printStackTrace()
            }
        }
    }

    private fun connectToServer(server: String) {
        print("Connecting to $server... ")
        experienceNetworkLatency()
        print(
            """
                Connected!
                
                """.trimIndent()
        )
    }

    private val randomVideos: HashMap<String?, Video?>
        private get() {
            print("Downloading populars... ")
            experienceNetworkLatency()
            val hmap: HashMap<String?, Video?> = HashMap<String?, Video?>()
            hmap["catzzzzzzzzz"] = Video("sadgahasgdas", "Catzzzz.avi")
            hmap["mkafksangasj"] = Video("mkafksangasj", "Dog play with ball.mp4")
            hmap["dancesvideoo"] = Video("asdfas3ffasd", "Dancing video.mpq")
            hmap["dlsdk5jfslaf"] = Video("dlsdk5jfslaf", "Barcelona vs RealM.mov")
            hmap["3sdfgsd1j333"] = Video("3sdfgsd1j333", "Programing lesson#1.avi")
            print(
                """
                       Done!
                       
                       """.trimIndent()
            )
            return hmap
        }

    private fun getSomeVideo(videoId: String?): Video? {
        print("Downloading video... ")
        experienceNetworkLatency()
        val video = videoId?.let { Video(it, "Some video title") }
        print(
            """
                Done!
                
                """.trimIndent()
        )
        return video
    }
}