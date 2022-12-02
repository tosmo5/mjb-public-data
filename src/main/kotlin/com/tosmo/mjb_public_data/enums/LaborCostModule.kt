package com.tosmo.mjb_public_data.enums

/**
 * 手工费提成模式
 */
enum class LaborCostModule(val code: Int) {
    UNDEFINED(0),
    /**
     * 按比例
     */
    RATE(1),

    /**
     * 按固定金额
     */
    AMOUNT(2)

    ;

    companion object {

        private val mCodeMap = buildMap {
            val enums = LaborCostModule.values()
            putAll(enums.map { it.code to it })
            require(size == enums.size) { "有重复项" }
        }

        /**
         * 根据[code]返回值
         */
        fun of(code: Int): LaborCostModule {
            return requireNotNull(mCodeMap[code]) { "${code}无效" }
        }
    }
}