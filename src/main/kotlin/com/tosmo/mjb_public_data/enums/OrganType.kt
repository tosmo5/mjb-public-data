package com.tosmo.mjb_public_data.enums

/**
 * 机构单位类型
 *
 * @author Thomas Miao
 */
enum class OrganType(val code: Int) {
    /**
     * 未定义
     */
    UNDEFINED(0),
    /**
     * 公司
     */
    COMPANY(1),

    /**
     * 区域公司
     */
    REGIONAL(2),

    /**
     * 分公司
     */
    FILIALE(3),

    /**
     * 加盟商
     */
    FRANCHISEE(4)
    ;

    companion object {
        private val mCodeMap = buildMap {
            val enums = OrganType.values()
            putAll(enums.map { it.code to it })
            require(size == enums.size) { "有重复项" }
        }

        /**
         * 根据[code]返回值
         */
        fun of(code: Int): OrganType {
            return requireNotNull(mCodeMap[code]) { "${code}无效" }
        }
    }
}