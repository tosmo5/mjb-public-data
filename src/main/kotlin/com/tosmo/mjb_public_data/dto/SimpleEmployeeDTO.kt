package com.tosmo.mjb_public_data.dto

import kotlinx.serialization.Serializable

@Serializable
data class SimpleEmployeeDTO(
    val id: Long,
    val name: String
)
