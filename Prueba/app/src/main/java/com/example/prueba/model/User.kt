package com.example.prueba.model

import java.io.Serializable

//Constructor primario
class User(var correo: String?=null, var pass: String?=null, var perfil: String?=null): Serializable{

    var direccion: String?=null
    var telefono:Int?=null

    //Constructor secundario
    constructor(correo: String?, pass: String?, perfil: String?, direccion:String?, telefono:Int?): this(correo, pass, perfil) {
        this.direccion=direccion
        this.telefono=telefono
    }
}