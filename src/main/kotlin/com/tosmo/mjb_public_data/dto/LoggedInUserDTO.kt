package com.tosmo.mjb_public_data.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoggedInUserDTO(
    /**
     * 用户编号
     */
    val userId: Long,
    /**
     * 用户名
     */
    val username: String,
    /**
     * 昵称
     */
    val nickname: String,
    /**
     * 公司集合
     */
    val companies: List<OrganInfoDTO>
) : java.io.Serializable
