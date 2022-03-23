package com.paulo.desginpattern.creational.flyweight

import java.util.*

// A Java program to demonstrate working of
// FlyWeight Pattern with example of Counter
// Strike Game


// A common interface for all players
internal interface Player {
    fun assignWeapon(weapon: String?)
    fun mission()
}

// Terrorist must have weapon and mission
internal class Terrorist() : Player {
    // Intrinsic Attribute
    private val TASK = "PLANT A BOMB"

    // Extrinsic Attribute
    private var weapon: String? = null
    override fun assignWeapon(weapon: String?) {
        // Assign a weapon
        this.weapon = weapon
    }

    override fun mission() {
        //Work on the Mission
        println(
            "Terrorist with weapon "
                    + weapon + "|" + " Task is " + TASK
        )
    }
}

// CounterTerrorist must have weapon and mission
internal class CounterTerrorist() : Player {
    // Intrinsic Attribute
    private val TASK = "DIFFUSE BOMB"

    // Extrinsic Attribute
    private var weapon: String? = null
    override fun assignWeapon(weapon: String?) {
        this.weapon = weapon
    }

    override fun mission() {
        println(
            ("Counter Terrorist with weapon "
                    + weapon + "|" + " Task is " + TASK)
        )
    }
}

// Class used to get a player using HashMap (Returns
// an existing player if a player of given type exists.
// Else creates a new player and returns it.
internal object PlayerFactory {
    /* HashMap stores the reference to the object
       of Terrorist(TS) or CounterTerrorist(CT).  */
    private val hm = HashMap<String, Player?>()

    // Method to get a player
    fun getPlayer(type: String): Player? {
        var p: Player? = null

        /* If an object for TS or CT has already been
           created simply return its reference */if (hm.containsKey(type)) p =
            hm[type] else {
            /* create an object of TS/CT  */
            when (type) {
                "Terrorist" -> {
                    println("Terrorist Created")
                    p = Terrorist()
                }
                "CounterTerrorist" -> {
                    println("Counter Terrorist Created")
                    p = CounterTerrorist()
                }
                else -> println("Unreachable code!")
            }

            // Once created insert it into the HashMap
            hm[type] = p
        }
        return p
    }
}

// Driver class
object CounterStrike {
    // All player types and weapon (used by getRandPlayerType()
    // and getRandWeapon()
    private val playerType = arrayOf("Terrorist", "CounterTerrorist")
    private val weapons = arrayOf("AK-47", "Maverick", "Gut Knife", "Desert Eagle")

    // Driver code
    @JvmStatic
    fun main(args: Array<String>) {
        /* Assume that we have a total of 10 players
           in the game. */
        for (i in 0..9) {
            /* getPlayer() is called simply using the class
               name since the method is a static one */
            val p = PlayerFactory.getPlayer(randPlayerType)

            /* Assign a weapon chosen randomly uniformly
               from the weapon array  */p!!.assignWeapon(randWeapon)

            // Send this player on a mission
            p.mission()
        }
    }// Will return an integer between [0,2)

    // return the player stored at index 'randInt'
    // Utility methods to get a random player type and
    // weapon
    val randPlayerType: String
        get() {
            val r = Random()

            // Will return an integer between [0,2)
            val randInt = r.nextInt(playerType.size)

            // return the player stored at index 'randInt'
            return playerType[randInt]
        }

    // Will return an integer between [0,5)
    val randWeapon: String
        // Return the weapon stored at index 'randInt'
        get() {
            val r = Random()

            // Will return an integer between [0,5)
            val randInt = r.nextInt(weapons.size)

            // Return the weapon stored at index 'randInt'
            return weapons[randInt]
        }
}