package com.tosmo.mjb_public_data.dto

import com.tosmo.mjb_public_data.enums.OrganType
import kotlinx.serialization.Serializable

@Serializable
data class SimpleOrganDTO(
    val id: Long,
    val name: String,
    val organType: OrganType,
    val subunits: List<SimpleOrganDTO> = emptyList()
)