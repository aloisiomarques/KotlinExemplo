package org.sistema

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Database {
    private const val URL = "jdbc:postgresql://localhost:5432/db_loja"
    private const val USER = "usr_admin"
    private const val PASSWORD = "senha1234"

    fun getConnection(): Connection {
        return try {
            DriverManager.getConnection(URL, USER, PASSWORD)
        } catch (e: SQLException) {
            e.printStackTrace()
            throw RuntimeException("Erro ao conectar ao banco de dados")
        }
    }
}
