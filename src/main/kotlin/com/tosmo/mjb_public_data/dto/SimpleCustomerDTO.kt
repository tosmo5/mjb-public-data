package com.tosmo.mjb_public_data.dto

import kotlinx.serialization.Serializable

@Serializable
data class SimpleCustomerDTO(
    var id: Long,
    var name: String
)
