package com.apresentation.use.entities

import jakarta.persistence.*

@Entity
@Table(name = "category")
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    @Column(name = "name", nullable= false, length = 30)
    var name: String = "",

    @Column(name = "description", nullable= false, length = 100)
    var description: String = "",
)