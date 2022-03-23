package com.paulo.desginpattern.creational.abstractFactory.guru

/**
 * Abstract Factory assumes that you have several families of products,
 * structured into separate class hierarchies (Button/Checkbox). All products of
 * the same family have the common interface.
 *
 * This is the common interface for buttons family.
 */
interface Button {
    fun paint()
}

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is a MacOS variant of a button.
 */
class MacOSButton : Button {
    override fun paint() {
        println("You have created MacOSButton.")
    }
}

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is another variant of a button.
 */
class WindowsButton : Button {
    override fun paint() {
        println("You have created WindowsButton.")
    }
}

/**
 * Checkboxes is the second product family. It has the same variants as buttons.
 */
interface Checkbox {
    fun paint()
}

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is a variant of a checkbox.
 */
class MacOSCheckbox : Checkbox {
    override fun paint() {
        println("You have created MacOSCheckbox.")
    }
}

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is another variant of a checkbox.
 */
class WindowsCheckbox : Checkbox {
    override fun paint() {
        println("You have created WindowsCheckbox.")
    }
}

/**
 * Abstract factory knows about all (abstract) product types.
 */
interface GUIFactory {
    fun createButton(): Button?
    fun createCheckbox(): Checkbox?
}

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
class MacOSFactory : GUIFactory {
    override fun createButton(): Button? {
        return MacOSButton()
    }

    override fun createCheckbox(): Checkbox? {
        return MacOSCheckbox()
    }
}

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
class WindowsFactory : GUIFactory {
    override fun createButton(): Button? {
        return WindowsButton()
    }

    override fun createCheckbox(): Checkbox? {
        return WindowsCheckbox()
    }
}

/**
 * Factory users don't care which concrete factory they use since they work with
 * factories and products through abstract interfaces.
 */
class Application(factory: GUIFactory) {
    private val button: Button?
    private val checkbox: Checkbox?
    fun paint() {
        button!!.paint()
        checkbox!!.paint()
    }

    init {
        button = factory.createButton()
        checkbox = factory.createCheckbox()
    }
}

/**
 * Demo class. Everything comes together here.
 */
object Demo {
    /**
     * Application picks the factory type and creates it in run time (usually at
     * initialization stage), depending on the configuration or environment
     * variables.
     */
    private fun configureApplication(): Application {
        val app: Application
        val factory: GUIFactory
        val osName = System.getProperty("os.name").toLowerCase()
        if (osName.contains("mac")) {
            factory = MacOSFactory()
            app = Application(factory)
        } else {
            factory = WindowsFactory()
            app = Application(factory)
        }
        return app
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val app = configureApplication()
        app.paint()
    }
}