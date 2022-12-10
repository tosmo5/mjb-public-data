package com.tosmo.mjb_public_data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CustomerGradeDTO(
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
     * 等级名称，长15
     */
    var name: String,
    /**
     * 名称别名，长15
     */
    var alias: String,
    /**
     * 项目折扣系数
     */
    var projectDiscountFactor: Float,
    /**
     * 产品折扣系数
     */
    var productDiscountFactor: Float
) : java.io.Serializable
