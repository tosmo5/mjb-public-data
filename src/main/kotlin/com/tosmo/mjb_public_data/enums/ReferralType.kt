package com.tosmo.mjb_public_data.enums

/**
 * 引荐分类
 *
 * @author Thomas Miao
 */
enum class ReferralType(val code: Int) {
    /**
     * 未定义
     */
    UNDEFINED(0),

    /**
     * 顾客引荐顾客
     */
    CUSTOMER_REFER_CUSTOMER(1),

    /**
     * 员工引荐顾客
     */
    EMPLOYEE_REFER_CUSTOMER(2),

    /**
     * 员工引荐员工
     */
    EMPLOYEE_REFER_EMPLOYEE(3)

    ;

    companion object {

        private val mCodeMap = buildMap {
            val enums = ReferralType.values()
            putAll(enums.map { it.code to it })
            require(size == enums.size) { "有重复项" }
        }

        /**
         * 根据[code]返回值
         */
        fun of(code: Int): ReferralType {
            return requireNotNull(mCodeMap[code]) { "${code}无效" }
        }

        fun valueOf(ordinale: Int): ReferralType {
            return ReferralType.values()[ordinale]
        }
    }
}