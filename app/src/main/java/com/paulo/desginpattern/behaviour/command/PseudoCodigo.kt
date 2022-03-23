package com.paulo.desginpattern.behaviour.command

/*
O Command é um padrão de projeto comportamental que transforma um pedido em um objeto independente
que contém toda a informação sobre o pedido. Essa transformação permite que você parametrize métodos
com diferentes pedidos, atrase ou coloque a execução do pedido em uma fila, e suporte operações que
não podem ser feitas.

// A classe comando base define a interface comum para todos
// comandos concretos.
abstract class Command is
    protected field app: Application
    protected field editor: Editor
    protected field backup: text

    constructor Command(app: Application, editor: Editor) is
        this.app = app
        this.editor = editor

    // Faz um backup do estado do editor.
    method saveBackup() is
        backup = editor.text

    // Restaura o estado do editor.
    method undo() is
        editor.text = backup

    // O método de execução é declarado abstrato para forçar
    // todos os comandos concretos a fornecer suas próprias
    // implementações. O método deve retornar verdadeiro ou
    // falso dependendo se o comando muda o estado do editor.
    abstract method execute()


// Comandos concretos vêm aqui.
class CopyCommand extends Command is
    // O comando copy (copiar) não é salvo no histórico já que
    // não muda o estado do editor.
    method execute() is
        app.clipboard = editor.getSelection()
        return false

class CutCommand extends Command is
    // O comando cut (cortar) muda o estado do editor, portanto
    // deve ser salvo no histórico. E ele será salvo desde que o
    // método retorne verdadeiro.
    method execute() is
        saveBackup()
        app.clipboard = editor.getSelection()
        editor.deleteSelection()
        return true

class PasteCommand extends Command is
    method execute() is
        saveBackup()
        editor.replaceSelection(app.clipboard)
        return true

// A operação undo (desfazer) também é um comando.
class UndoCommand extends Command is
    method execute() is
        app.undo()
        return false


// O comando global history (histórico) é apenas uma pilha.
class CommandHistory is
    private field history: array of Command

    // Último a entrar...
    method push(c: Command) is
        // Empurra o comando para o fim do vetor do histórico.

    // ...primeiro a sair.
    method pop():Command is
        // Obter o comando mais recente do histórico.


// A classe do editor tem verdadeiras operações de edição de
// texto. Ela faz o papel de destinatária: todos os comandos
// acabam delegando a execução para os métodos do editor.
class Editor is
    field text: string

    method getSelection() is
        // Retorna o texto selecionado.

    method deleteSelection() is
        // Deleta o texto selecionado.

    method replaceSelection(text) is
        // Insere os conteúdos da área de transferência na
        // posição atual.


// A classe da aplicação define as relações de objeto. Ela age
// como uma remetente: quando alguma coisa precisa ser feita,
// ela cria um objeto comando e executa ele.
class Application is
    field clipboard: string
    field editors: array of Editors
    field activeEditor: Editor
    field history: CommandHistory

    // O código que assinala comandos para objetos UI pode se
    // parecer como este.
    method createUI() is
        // ...
        copy = function() { executeCommand(
            new CopyCommand(this, activeEditor)) }
        copyButton.setCommand(copy)
        shortcuts.onKeyPress("Ctrl+C", copy)

        cut = function() { executeCommand(
            new CutCommand(this, activeEditor)) }
        cutButton.setCommand(cut)
        shortcuts.onKeyPress("Ctrl+X", cut)

        paste = function() { executeCommand(
            new PasteCommand(this, activeEditor)) }
        pasteButton.setCommand(paste)
        shortcuts.onKeyPress("Ctrl+V", paste)

        undo = function() { executeCommand(
            new UndoCommand(this, activeEditor)) }
        undoButton.setCommand(undo)
        shortcuts.onKeyPress("Ctrl+Z", undo)

    // Executa um comando e verifica se ele foi adicionado ao
    // histórico.
    method executeCommand(command) is
        if (command.execute)
            history.push(command)

    // Pega o comando mais recente do histórico e executa seu
    // método undo(desfazer). Observe que nós não sabemos a
    // classe desse comando. Mas nós não precisamos saber, já
    // que o comando sabe como desfazer sua própria ação.
    method undo() is
        command = history.pop()
        if (command != null)
            command.undo()
 */