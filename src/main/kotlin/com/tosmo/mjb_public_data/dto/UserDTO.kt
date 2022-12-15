package com.tosmo.mjb_public_data.dto

import com.tosmo.ktils.serializer.LocalTimeAsStringSerializer
import kotlinx.serialization.Serializable
import java.time.LocalTime

@Serializable
data class UserDTO(
    /**
     * 用户编号
     */
    var id: Long,
    /**
     * 用户名
     */
    var username: String,
    /**
     * 昵称
     */
    var nickname: String,
    /**
     * 登录开始时间
     */
    @Serializable(LocalTimeAsStringSerializer::class)
    var loginTimeStart: LocalTime,
    /**
     * 登录结束时间
     */
    @Serializable(LocalTimeAsStringSerializer::class)
    var loginTimeEnd: LocalTime,
    /**
     * 所属机构集合
     */
    var companies: List<SimpleOrganDTO>,
    /**
     * 是否为原始账号
     */
    val isOriginal: Boolean
) : java.io.Serializable
