package org.sistema.view

import org.sistema.controller.PessoaController


class MainView {
    private val pessoaController = PessoaController()

    fun exibirMenu() {
        while (true) {
            println("1. Cadastrar Pessoa")
            println("2. Alterar Pessoa")
            println("3. Excluir Pessoa")
            println("4. Listar Pessoas")
            println("5. Sair")

            when (readln().toInt()) {
                1 -> cadastrarPessoa()
                2 -> alterarPessoa()
                3 -> excluirPessoa()
                4 -> listarPessoas()
                5 -> return
                else -> println("Opção inválida!")
            }
        }
    }

    private fun cadastrarPessoa() {
        println("Nome: ")
        val nome = readln()
        println("Idade: ")
        val idade = readln().toInt()
        pessoaController.cadastrarPessoa(nome, idade)
    }

    private fun alterarPessoa() {
        println("ID: ")
        val id = readln().toInt()
        println("Novo Nome: ")
        val nome = readln()
        println("Nova Idade: ")
        val idade = readln().toInt()
        pessoaController.alterarPessoa(id, nome, idade)
    }

    private fun excluirPessoa() {
        println("ID: ")
        val id = readln().toInt()
        pessoaController.excluirPessoa(id)
    }

    private fun listarPessoas() {
        pessoaController.listarPessoas()
    }
}
