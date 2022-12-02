package com.tosmo.mjb_public_data.enums

/**
 *
 * @author Thomas Miao
 */
enum class EmployeeStatus(val code: Int) {
    UNDEFINED(0),

    /**
     * 新员工
     */
    NEW(1),

    /**
     * 正式员工
     */
    REGULAR(2),

    /**
     * 离职员工
     */
    FORMER(3)
    ;

    companion object {

        private val mCodeMap = buildMap {
            val enums = EmployeeStatus.values()
            putAll(enums.map { it.code to it })
            require(size == enums.size) { "有重复项" }
        }

        /**
         * 根据[code]返回值
         */
        fun of(code: Int): EmployeeStatus {
            return requireNotNull(mCodeMap[code]) { "${code}无效" }
        }
    }
}