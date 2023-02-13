package com.apresentation.use.entities

import jakarta.persistence.*

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //IDENTITY:usado quando se quer gerar valores unicos para
    var id: Long,                                        // a chave primária, deixando o banco fazer isso.

    @Column(name = "name", nullable= false, length = 30)
    var name: String,

    @Column(name = "description", nullable= false, length = 100)
    var description: String,

    @Column(name = "price", nullable= false, length = 10)
    var price: Double
) {
    // Construtor sem argumentos, não entendi o motivo dele aqui ainda...
    // Segundo o GPT: para melhorar a comunicação com outras bibliotecas e frameworks.

    constructor() : this(0,"","",0.0)
}