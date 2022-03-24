package com.paulo.desginpattern.behaviour.iterator.exampleGuru

class LinkedIn(cache: List<Profile>?) : SocialNetwork {
    private var contacts: List<Profile>? = null
    fun requestContactInfoFromLinkedInAPI(profileEmail: String): Profile? {
        // Here would be a POST request to one of the LinkedIn API endpoints.
        // Instead, we emulates long network connection, which you would expect
        // in the real life...
        simulateNetworkLatency()
        println("LinkedIn: Loading profile '$profileEmail' over the network...")

        // ...and return test data.
        return findContact(profileEmail)
    }

    fun requestRelatedContactsFromLinkedInAPI(
        profileEmail: String,
        contactType: String
    ): List<String>? {
        // Here would be a POST request to one of the LinkedIn API endpoints.
        // Instead, we emulates long network connection, which you would expect
        // in the real life.
        simulateNetworkLatency()
        println("LinkedIn: Loading '$contactType' list of '$profileEmail' over the network...")

        // ...and return test data.
        val profile: Profile? = findContact(profileEmail)
        return if (profile != null) {
            profile.getContacts(contactType)
        } else null
    }

    private fun findContact(profileEmail: String): Profile? {
        for (profile in contacts!!) {
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
        return LinkedInIterator(this, "friends", profileEmail!!)
    }

    override fun createCoworkersIterator(profileEmail: String?): ProfileIterator? {
        return LinkedInIterator(this, "coworkers", profileEmail!!)
    }

    init {
        if (cache != null) {
            contacts = cache
        } else {
            contacts = ArrayList()
        }
    }
}
