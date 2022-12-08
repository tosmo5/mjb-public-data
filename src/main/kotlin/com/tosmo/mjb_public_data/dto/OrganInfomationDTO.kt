package com.tosmo.mjb_public_data.dto

import com.tosmo.mjb_public_data.enums.OrganType
import kotlinx.serialization.Serializable

@Serializable
data class OrganInfomationDTO(
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
    val subunits: List<OrganInfomationDTO> = emptyList()
) : java.io.Serializable
