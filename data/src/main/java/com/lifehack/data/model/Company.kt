package com.lifehack.data.model

import java.io.Serializable

open class Company(
    val id: Int? = null,
    val name: String? = null,
    val img: String? = null
) : Serializable