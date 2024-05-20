package org.sistema.controller

import org.sistema.model.Pessoa
import org.sistema.model.PessoaDAO


class PessoaController {
    private val pessoaDAO = PessoaDAO()

    fun cadastrarPessoa(nome: String, idade: Int) {
        val pessoa = Pessoa(nome = nome, idade = idade)
        pessoaDAO.cadastrarPessoa(pessoa)
        println("Pessoa cadastrada: $pessoa")
    }

    fun alterarPessoa(id: Int, nome: String, idade: Int) {
        val pessoa = Pessoa(id = id, nome = nome, idade = idade)
        pessoaDAO.alterarPessoa(pessoa)
        println("Pessoa alterada: $pessoa")
    }

    fun excluirPessoa(id: Int) {
        pessoaDAO.excluirPessoa(id)
        println("Pessoa excluída com ID $id")
    }

    fun listarPessoas() {
        val pessoas = pessoaDAO.listarPessoas()
        if (pessoas.isEmpty()) {
            println("Nenhuma pessoa cadastrada.")
        } else {
            println("Lista de pessoas cadastradas:")
            pessoas.forEach { println(it) }
        }
    }
}
