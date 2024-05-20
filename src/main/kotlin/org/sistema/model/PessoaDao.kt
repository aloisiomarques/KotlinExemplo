package org.sistema.model

import org.sistema.Database
import java.sql.Connection
import java.sql.SQLException

class PessoaDAO {
    private val connection: Connection = Database.getConnection()

    init {
        criarTabela()
    }

    private fun criarTabela() {
        val sql = """
            CREATE TABLE IF NOT EXISTS pessoa (
                id SERIAL PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                idade INT NOT NULL
            )
        """.trimIndent()
        connection.createStatement().use { it.execute(sql) }
    }

    fun cadastrarPessoa(pessoa: Pessoa) {
        val sql = "INSERT INTO pessoa (nome, idade) VALUES (?, ?)"
        try {
            connection.prepareStatement(sql).use { statement ->
                statement.setString(1, pessoa.nome)
                statement.setInt(2, pessoa.idade)
                statement.executeUpdate()
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun alterarPessoa(pessoa: Pessoa) {
        val sql = "UPDATE pessoa SET nome = ?, idade = ? WHERE id = ?"
        try {
            connection.prepareStatement(sql).use { statement ->
                statement.setString(1, pessoa.nome)
                statement.setInt(2, pessoa.idade)
                statement.setInt(3, pessoa.id)
                statement.executeUpdate()
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun excluirPessoa(id: Int) {
        val sql = "DELETE FROM pessoa WHERE id = ?"
        try {
            connection.prepareStatement(sql).use { statement ->
                statement.setInt(1, id)
                statement.executeUpdate()
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun listarPessoas(): List<Pessoa> {
        val sql = "SELECT * FROM pessoa"
        val pessoas = mutableListOf<Pessoa>()
        try {
            connection.createStatement().use { statement ->
                val resultSet = statement.executeQuery(sql)
                while (resultSet.next()) {
                    val pessoa = Pessoa(
                        id = resultSet.getInt("id"),
                        nome = resultSet.getString("nome"),
                        idade = resultSet.getInt("idade")
                    )
                    pessoas.add(pessoa)
                }
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return pessoas
    }
}
