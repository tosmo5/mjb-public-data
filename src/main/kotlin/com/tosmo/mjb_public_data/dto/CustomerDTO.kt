package com.tosmo.mjb_public_data.dto

import com.tosmo.ktils.serializer.DateAsStringSerializer
import com.tosmo.mjb_public_data.enums.Gender
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class CustomerDTO(
    /**
     * 编号
     */
    var id: Long,
    /**
     * 顶层机构编号
     */
    var topOrgan: SimpleOrganDTO,
    /**
     * 进入时的机构编号
     */
    var entryOrgan: SimpleOrganDTO,
    /**
     * 姓名，长20
     */
    var name: String,
    /**
     * 姓名简称，长60
     */
    var nameBrief: String,
    /**
     * 手机号，长11
     */
    var phone: String,
    /**
     * 性别
     */
    var gender: Gender,
    /**
     * 引荐顾客
     */
    var referalCustomer: SimpleCustomerDTO?,
    /**
     * 引荐员工
     */
    var referalEmployee: SimpleEmployeeDTO?,
    /**
     * 身份证号，长18
     */
    var idCardNo: String,
    /**
     * 生日
     */
    @Serializable(DateAsStringSerializer::class)
    var birthday: Date?,
    /**
     * 电话，长13
     */
    var telephone: String,
    /**
     * 地址，长50
     */
    var address: String,
    /**
     * 工作，长20
     */
    var job: String,
    /**
     * 邮编
     */
    var postcode: Int,
    /**
     * 电子邮箱，长50
     */
    var email: String,
    /**
     * qq
     */
    var qq: Int,
    /**
     * 微信号，长20
     */
    var wechat: String,
    /**
     * 备注，长100
     */
    var remark: String
) : java.io.Serializable
