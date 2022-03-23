package com.paulo.desginpattern.behaviour.chainOfResponsability

/*CHAIN OF RESPONSIBILITY

Também conhecido como: CoR, Corrente de responsabilidade, Corrente de comando, Chain of command
“O Chain of Responsibility é um padrão de projeto comportamental que permite que você passe
 pedidos por uma corrente de handlers. Ao receber um pedido, cada
  handler decide se processa o pedido ou o passa adiante para o próximo
  handler na corrente.


// A interface do handler declara um método para a construção da
// corrente de handlers. Ela também declara um método para
// executar um pedido.
interface ComponentWithContextualHelp is
    method showHelp()


// A classe base para componentes simples.
abstract class Component implements ComponentWithContextualHelp is
    field tooltipText: string

    // O contêiner do componente age como o próximo elo na
    // corrente de handlers.
    protected field container: Container

    // O componente mostra um tooltip (dica de contexto) se há
    // algum texto de ajuda assinalado a ele. Do contrário ele
    // passa a chamada adiante ao contêiner, se ele existir.
    method showHelp() is
        if (tooltipText != null)
            // Mostrar dica de contexto.
        else
            container.showHelp()


// Contêineres podem conter tanto componentes simples como
// outros contêineres como filhos. As relações da corrente são
// definidas aqui. A classe herda o comportamento showHelp de
// sua mãe.
abstract class Container extends Component is
    protected field children: array of Component

    method add(child) is
        children.add(child)
        child.container = this


// Componentes primitivos estão de bom tamanho com a
// implementação de ajuda padrão.
class Button extends Component is
    // ...

// Mas componentes complexos podem sobrescrever a implementação
// padrão. Se o texto de ajuda não pode ser fornecido de uma
// nova maneira, o componente pode sempre chamar a implementação
// base (veja a classe Component).
class Panel extends Container is
    field modalHelpText: string

    method showHelp() is
        if (modalHelpText != null)
            // Mostra uma janela modal com texto de ajuda.
        else
            super.showHelp()

// ...o mesmo que acima...
class Dialog extends Container is
    field wikiPageURL: string

    method showHelp() is
        if (wikiPageURL != null)
            // Abre a página de ajuda do wiki.
        else
            super.showHelp()


// Código cliente.
class Application is
    // Cada aplicação configura a corrente de forma diferente.
    method createUI() is
        dialog = new Dialog("Budget Reports")
        dialog.wikiPageURL = "http://..."
        panel = new Panel(0, 0, 400, 800)
        panel.modalHelpText = "This panel does..."
        ok = new Button(250, 760, 50, 20, "OK")
        ok.tooltipText = "This is an OK button that..."
        cancel = new Button(320, 760, 50, 20, "Cancel")
        // ...
        panel.add(ok)
        panel.add(cancel)
        dialog.add(panel)

    // Imagine o que acontece aqui.
    method onF1KeyPress() is
        component = this.getComponentAtMouseCoords()
        component.showHelp()

 */