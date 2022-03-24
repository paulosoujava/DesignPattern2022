package com.paulo.desginpattern.behaviour.iterator.exampleGuru


interface SocialNetwork {
    fun createFriendsIterator(profileEmail: String?): ProfileIterator?
    fun createCoworkersIterator(profileEmail: String?): ProfileIterator?
}