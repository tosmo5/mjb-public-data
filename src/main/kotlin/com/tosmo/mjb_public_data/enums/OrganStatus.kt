package com.tosmo.mjb_public_data.enums

/**
 *
 * @author Thomas Miao
 */
enum class OrganStatus(val code: Int) {
    /**
     * 未定义
     */
    UNDEFINED(0),

    /**
     * 未初始化
     */
    UNINITIALIZED(1),

    /**
     * 可用状态
     */
    AVAILABLE(2),

    /**
     * 被锁定
     */
    LOCKED(3)

    ;

    companion object {

        private val mCodeMap = buildMap {
            val enums = OrganStatus.values()
            putAll(enums.map { it.code to it })
            require(size == enums.size) { "有重复项" }
        }

        /**
         * 根据[code]返回值
         */
        fun of(code: Int): OrganStatus {
            return requireNotNull(mCodeMap[code]) { "${code}无效" }
        }
    }
}