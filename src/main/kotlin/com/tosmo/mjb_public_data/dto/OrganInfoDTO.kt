package com.tosmo.mjb_public_data.dto

import com.tosmo.mjb_public_data.enums.OrganType
import kotlinx.serialization.Serializable

@Deprecated("", ReplaceWith("SimpleOrganDTO"))
@Serializable
data class OrganInfoDTO(
    /**
     * 机构编号
     */
    val id: Long,
    /**
     * 机构类型
     */
    val type: OrganType,
    /**
     * 机构名称
     */
    val name: String,
    /**
     * 信用代码
     */
    val creaditCode: String,
    /**
     * 下级机构
     */
    val subunits: List<OrganInfoDTO> = emptyList()
) : java.io.Serializable
