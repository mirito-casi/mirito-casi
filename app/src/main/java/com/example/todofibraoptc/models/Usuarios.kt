package com.example.todofibraoptc.models

data class Usuarios(
    val regional: String,
    val grupomtto: String,
    val proyecto: String,
    val nombres: String,
    val apellidos: String,
    val email: String,
    val pasword: String
){
    override fun toString(): String {
        return nombres
    }
}
