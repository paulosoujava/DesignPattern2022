package com.paulo.desginpattern.behaviour.iterator.exampleGuru

class Facebook(cache: List<Profile>?) : SocialNetwork {
    private var profiles: List<Profile>? = null
    fun requestProfileFromFacebook(profileEmail: String): Profile? {
        // Here would be a POST request to one of the Facebook API endpoints.
        // Instead, we emulates long network connection, which you would expect
        // in the real life...
        simulateNetworkLatency()
        println("Facebook: Loading profile '$profileEmail' over the network...")

        // ...and return test data.
        return findProfile(profileEmail)
    }

    fun requestProfileFriendsFromFacebook(
        profileEmail: String,
        contactType: String
    ): List<String>? {
        // Here would be a POST request to one of the Facebook API endpoints.
        // Instead, we emulates long network connection, which you would expect
        // in the real life...
        simulateNetworkLatency()
        println("Facebook: Loading '$contactType' list of '$profileEmail' over the network...")

        // ...and return test data.
        val profile: Profile? = findProfile(profileEmail)
        return if (profile != null) {
            profile.getContacts(contactType)
        } else null
    }

    private fun findProfile(profileEmail: String): Profile? {
        for (profile in profiles!!) {
            if (profile.email == profileEmail) {
                return profile
            }
        }
        return null
    }

    private fun simulateNetworkLatency() {
        try {
            Thread.sleep(2500)
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }

    override fun createFriendsIterator(profileEmail: String?): ProfileIterator? {
        return FacebookIterator(this, "friends", profileEmail!!)
    }

    override fun createCoworkersIterator(profileEmail: String?): ProfileIterator? {
        return FacebookIterator(this, "coworkers", profileEmail!!)
    }

    init {
        if (cache != null) {
            profiles = cache
        } else {
            profiles = ArrayList()
        }
    }
}