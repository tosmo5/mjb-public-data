package com.tosmo.mjb_public_data.enums

enum class Gender(val code: Int, val zhName: String) {
    UNDEFINDE(0, "未知"),
    WOMAN(1, "女"),
    MAN(2, "男")
    ;

    companion object {

        private val mCodeMap = buildMap {
            val enums = Gender.values()
            putAll(enums.map { it.code to it })
            require(size == enums.size) { "有重复项" }
        }

        /**
         * 根据[code]返回值
         */
        fun of(code: Int): Gender {
            return requireNotNull(mCodeMap[code]) { "${code}无效" }
        }

        fun valueOfZh(zhName: String): Gender {
            return when (zhName) {
                WOMAN.zhName -> WOMAN
                MAN.zhName -> MAN
                UNDEFINDE.zhName -> UNDEFINDE
                else -> throw IllegalArgumentException("不支持${zhName}性别")
            }
        }
    }

    override fun toString(): String {
        return zhName
    }
}