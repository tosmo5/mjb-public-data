package com.tosmo.mjb_public_data.enums

/**
 * 项目的类型
 *
 * @author Thomas Miao
 */
enum class ProjectType(val code: Int) {
    UNDEFINED(0),

    /**
     * 经典的普通项目
     */
    CLASSICAL(1),

    /**
     * 组合项目
     */
    UNION(2)
    ;

    companion object {
        private val mCodeMap = buildMap {
            val enums = ProjectType.values()
            putAll(enums.map { it.code to it })
            require(size == enums.size) { "有重复项" }
        }

        /**
         * 根据[code]返回值
         */
        fun of(code: Int): ProjectType {
            return requireNotNull(mCodeMap[code]) { "${code}无效" }
        }
    }
}