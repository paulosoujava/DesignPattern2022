package com.paulo.desginpattern.behaviour.iterator.exampleGuru

class LinkedInIterator(linkedIn: LinkedIn, type: String, email: String) :
    ProfileIterator {
    private val linkedIn: LinkedIn
    private val type: String
    private val email: String
    private var currentPosition = 0
    private val emails: MutableList<String> = ArrayList()
    private val contacts: MutableList<Profile?> = ArrayList()
    private fun lazyLoad() {
        if (emails.size == 0) {
            val profiles: List<String>? = linkedIn.requestRelatedContactsFromLinkedInAPI(
                email, type
            )
            if (profiles != null) {
                for (profile in profiles) {
                    emails.add(profile)
                    contacts.add(null)
                }
            }
        }
    }

    override fun hasNext(): Boolean {
        lazyLoad()
        return currentPosition < emails.size
    }

    override val next: Profile?
        get() {
            if (!hasNext()) {
                return null
            }
            val friendEmail = emails[currentPosition]
            var friendContact: Profile? = contacts[currentPosition]
            if (friendContact == null) {
                friendContact = linkedIn.requestContactInfoFromLinkedInAPI(friendEmail)
                contacts[currentPosition] = friendContact
            }
            currentPosition++
            return friendContact
        }

    override fun reset() {
        currentPosition = 0
    }

    init {
        this.linkedIn = linkedIn
        this.type = type
        this.email = email
    }
}