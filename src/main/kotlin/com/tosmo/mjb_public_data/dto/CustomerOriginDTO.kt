package com.tosmo.mjb_public_data.dto

data class CustomerOriginDTO(
    /**
     * 编号
     */
    val id: Long,
    /**
     * 机构编号
     */
    var organId: Long,
    /**
     * 序号
     */
    var serialNo: Int,
    /**
     * 来源名称，长10
     */
    var name: String,
    /**
     * 描述，长100
     */
    var description: String
)
