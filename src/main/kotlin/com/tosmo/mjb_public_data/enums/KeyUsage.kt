package com.tosmo.mjb_public_data.enums

/**
 *
 * @author Thomas Miao
 */
enum class KeyUsage(val code: Int) {
    UNDEFINED(0),

    /**
     * 设置-子公司基础设置
     */
    SETUP_FILIALE_BASE(101),

    /**
     * 设置-订单确认设置
     */
    SETUP_ORDER_CONFIRMATION(102),

    /**
     * 老顾客分红
     */
    SETUP_REGULAR_DIVIDEND(103),

    /**
     * 积分标准设置
     */
    SETUP_POINT_NORM(104),

    /**
     * 消费返现设置
     */
    SETUP_CONSUMPTION_CASH_BACK(105),

    /**
     * 订单声明
     */
    SETUP_ORDER_DECLARATION(106)

    ;

    companion object {

        private val mCodeMap = buildMap {
            val enums = KeyUsage.values()
            putAll(enums.map { it.code to it })
            require(size == enums.size) { "有重复项" }
        }

        /**
         * 根据[code]返回值
         */
        fun of(code: Int): KeyUsage {
            return requireNotNull(mCodeMap[code]) { "${code}无效" }
        }
    }
}