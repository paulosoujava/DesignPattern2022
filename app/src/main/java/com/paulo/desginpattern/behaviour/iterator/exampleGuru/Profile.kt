package com.paulo.desginpattern.behaviour.iterator.exampleGuru

class Profile(val email: String, val name: String, vararg contacts: String) {
    private val contacts: MutableMap<String, MutableList<String>> = HashMap()
    fun getContacts(contactType: String): List<String> {
        if (!contacts.containsKey(contactType)) {
            contacts[contactType] = ArrayList()
        }
        return contacts[contactType]!!
    }

    init {

        // Parse contact list from a set of "friend:email@gmail.com" pairs.
        for (contact in contacts) {
            val parts = contact.split(":").toTypedArray()
            var contactType = "friend"
            var contactEmail: String
            if (parts.size == 1) {
                contactEmail = parts[0]
            } else {
                contactType = parts[0]
                contactEmail = parts[1]
            }
            if (!this.contacts.containsKey(contactType)) {
                this.contacts[contactType] = ArrayList()
            }
            this.contacts[contactType]!!.add(contactEmail)
        }
    }
}