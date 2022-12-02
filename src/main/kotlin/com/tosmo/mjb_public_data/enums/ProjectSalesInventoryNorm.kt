package com.tosmo.mjb_public_data.enums

/**
 * 允许开项操作的库存判断标准
 *
 * @author Thomas Miao
 */
enum class ProjectSalesInventoryNorm(val code: Int) {
    /**
     * 未定义
     */
    UNDEFINED(0),

    /**
     * 根据最低开项库存判断
     */
    MIN_ALLOW_SALE_INVENTORY(1),

    /**
     * 根据最低开项库存和占用库存判断
     */
    EXTRA_WITH_OCCUPIED_INVENTORY(2)

    ;


    companion object {
        private val mCodeMap = buildMap {
            val enums = ProjectSalesInventoryNorm.values()
            putAll(enums.map { it.code to it })
            require(size == enums.size) { "有重复项" }
        }

        /**
         * 根据[code]返回值
         */
        fun of(code: Int): ProjectSalesInventoryNorm {
            return requireNotNull(mCodeMap[code]) { "${code}无效" }
        }
    }
}