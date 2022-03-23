package com.paulo.desginpattern.creational.factoryMethod.guru


/**
 * Common interface for all buttons.
 */
interface Button {
    fun render()
    fun onClick()
}

/**
 * HTML button implementation.
 */
class HtmlButton : Button {
    override fun render() {
        println("<button>Test Button</button>")
        onClick()
    }

    override fun onClick() {
        println("Click! Button says - 'Hello World!'")
    }
}

/**
 * Windows button implementation.
 */
class WindowsButton : Button {
    override fun render() {
        TODO("Not yet implemented")
    }

    /*
    var panel: javax.swing.JPanel = javax.swing.JPanel()
    var frame: javax.swing.JFrame = javax.swing.JFrame()
    var button: javax.swing.JButton? = null
    override fun render() {
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE)
        val label: javax.swing.JLabel = javax.swing.JLabel("Hello World!")
        label.setOpaque(true)
        label.setBackground(Color(235, 233, 126))
        label.setFont(Font("Dialog", Font.BOLD, 44))
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER)
        panel.setLayout(FlowLayout(FlowLayout.CENTER))
        frame.getContentPane().add(panel)
        panel.add(label)
        onClick()
        panel.add(button)
        frame.setSize(320, 200)
        frame.setVisible(true)
        onClick()
    }
 */
    override fun onClick() {
        /*
             button = javax.swing.JButton("Exit")
             button.addActionListener(object : ActionListener() {
                 fun actionPerformed(e: java.awt.event.ActionEvent?) {
                     frame.setVisible(false)
                     System.exit(0)
                 }
             })
             */
    }

}

/**
 * Base factory class. Note that "factory" is merely a role for the class. It
 * should have some core business logic which needs different products to be
 * created.
 */
abstract class Dialog {
    fun renderWindow() {
        // ... other code ...
        val okButton = createButton()
        okButton.render()
    }

    /**
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    abstract fun createButton(): Button
}

/**
 * HTML Dialog will produce HTML buttons.
 */
class HtmlDialog : Dialog() {
    override fun createButton(): Button {
        return HtmlButton()
    }
}

/**
 * Windows Dialog will produce Windows buttons.
 */
class WindowsDialog : Dialog() {
    override fun createButton(): Button {
        return WindowsButton()
    }
}

/**
 * Demo class. Everything comes together here.
 */
object Demo {
    private var dialog: Dialog? = null
    @JvmStatic
    fun main(args: Array<String>) {
        configure()
        runBusinessLogic()
    }

    /**
     * The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
    fun configure() {
        if (System.getProperty("os.name") == "Windows 10") {
            dialog = WindowsDialog()
        } else {
            dialog = HtmlDialog()
        }
    }

    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
    fun runBusinessLogic() {
        dialog!!.renderWindow()
    }
}