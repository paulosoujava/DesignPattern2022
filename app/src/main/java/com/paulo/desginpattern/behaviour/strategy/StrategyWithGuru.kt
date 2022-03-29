package com.paulo.desginpattern.behaviour.strategy

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * Common interface for all strategies.
 */
interface PayStrategy {
    fun pay(paymentAmount: Int): Boolean
    fun collectPaymentDetails()
}

/**
 * Concrete strategy. Implements PayPal payment method.
 */
class PayByPayPal : PayStrategy {
    private val READER: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    private var email: String? = null
    private var password: String? = null
    private var signedIn = false

    companion object {
        private val DATA_BASE: MutableMap<String?, String> = HashMap()

        init {
            DATA_BASE["amanda1985"] = "amanda@ya.com"
            DATA_BASE["qwerty"] = "john@amazon.eu"
        }
    }

    /**
     * Collect customer's data.
     */
    override fun collectPaymentDetails() {
        try {
            while (!signedIn) {
                print("Enter the user's email: ")
                email = READER.readLine()
                print("Enter the password: ")
                password = READER.readLine()
                if (verify()) {
                    println("Data verification has been successful.")
                } else {
                    println("Wrong email or password!")
                }
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

    private fun verify(): Boolean {
        setSignedIn(email == DATA_BASE[password])
        return signedIn
    }

    /**
     * Save customer data for future shopping attempts.
     */
    override fun pay(paymentAmount: Int): Boolean {
        return if (signedIn) {
            println("Paying $paymentAmount using PayPal.")
            true
        } else {
            false
        }
    }

    private fun setSignedIn(signedIn: Boolean) {
        this.signedIn = signedIn
    }
}

/**
 * Concrete strategy. Implements credit card payment method.
 */
class PayByCreditCard : PayStrategy {
    private val READER: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    private var card: CreditCard? = null

    /**
     * Collect credit card data.
     */
    override fun collectPaymentDetails() {
        try {
            print("Enter the card number: ")
            val number: String = READER.readLine()
            print("Enter the card expiration date 'mm/yy': ")
            val date: String = READER.readLine()
            print("Enter the CVV code: ")
            val cvv: String = READER.readLine()
            card = CreditCard(number, date, cvv)

            // Validate credit card number...
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

    /**
     * After card validation we can charge customer's credit card.
     */
    override fun pay(paymentAmount: Int): Boolean {
        return if (cardIsPresent()) {
            println("Paying $paymentAmount using Credit Card.")
            card!!.amount = card!!.amount - paymentAmount
            true
        } else {
            false
        }
    }

    private fun cardIsPresent(): Boolean {
        return card != null
    }
}

/**
 * Dummy credit card class.
 */
class CreditCard internal constructor(
    private val number: String,
    private val date: String,
    private val cvv: String
) {
    var amount = 100000

}

/**
 * Order class. Doesn't know the concrete payment method (strategy) user has
 * picked. It uses common strategy interface to delegate collecting payment data
 * to strategy object. It can be used to save order to database.
 */
class Order {
    var totalCost = 0
        set(cost) {
            field += cost
        }
    var isClosed = false
        private set

    fun processOrder(strategy: PayStrategy) {
        strategy.collectPaymentDetails()
        // Here we could collect and store payment data from the strategy.
    }

    fun setClosed() {
        isClosed = true
    }
}

/**
 * World first console e-commerce application.
 */
object Demo {
    private val priceOnProducts: MutableMap<Int, Int> = HashMap()
    private val reader: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    private val order = Order()
    private var strategy: PayStrategy? = null
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        while (!order.isClosed) {
            var cost: Int
            var continueChoice: String
            do {
                print(
                    "Please, select a product:" + "\n" +
                            "1 - Mother board" + "\n" +
                            "2 - CPU" + "\n" +
                            "3 - HDD" + "\n" +
                            "4 - Memory" + "\n"
                )
                val choice: Int = reader.readLine().toInt()
                cost = (priceOnProducts[choice])!!
                print("Count: ")
                val count: Int = reader.readLine().toInt()
                order.totalCost = cost * count
                print("Do you wish to continue selecting products? Y/N: ")
                continueChoice = reader.readLine()
            } while (continueChoice.equals("Y", ignoreCase = true))
            if (strategy == null) {
                println(
                    ("Please, select a payment method:" + "\n" +
                            "1 - PalPay" + "\n" +
                            "2 - Credit Card")
                )
                val paymentMethod: String = reader.readLine()

                // Client creates different strategies based on input from user,
                // application configuration, etc.
                if ((paymentMethod == "1")) {
                    strategy = PayByPayPal()
                } else {
                    strategy = PayByCreditCard()
                }
            }

            // Order object delegates gathering payment data to strategy object,
            // since only strategies know what data they need to process a
            // payment.
            order.processOrder(strategy!!)
            print("Pay " + order.totalCost + " units or Continue shopping? P/C: ")
            val proceed: String = reader.readLine()
            if (proceed.equals("P", ignoreCase = true)) {
                // Finally, strategy handles the payment.
                if (strategy!!.pay(order.totalCost)) {
                    println("Payment has been successful.")
                } else {
                    println("FAIL! Please, check your data.")
                }
                order.setClosed()
            }
        }
    }

    init {
        priceOnProducts[1] = 2200
        priceOnProducts[2] = 1850
        priceOnProducts[3] = 1100
        priceOnProducts[4] = 890
    }
}