package com.tosmo.mjb_public_data.enums

import java.util.*
import kotlin.reflect.KClass

/**
 *
 * @author Thomas Miao
 */
enum class ValueType(
    val code: Int,
    val valueValueKClass: KClass<*>
) {
    /**
     * [Boolean]
     */
    BOOLEAN(1, Boolean::class),

    /**
     * [Int]
     */
    INT(2, Int::class),

    /**
     * [Long]
     */
    LONG(3, Long::class),

    /**
     * [Float]
     */
    FLOAT(4, Float::class),

    /**
     * [Double]
     */
    DOUBLE(5, Double::class),

    /**
     * [String]
     */
    STRING(6, String::class),

    /**
     * [Date]
     */
    DATE(7, Date::class)
    ;

    companion object {

        private val mCodeMap = buildMap {
            val enums = ValueType.values()
            putAll(enums.map { it.code to it })
            require(size == enums.size) { "有重复项" }
        }

        /**
         * 根据[code]返回值
         */
        fun of(code: Int): ValueType {
            return requireNotNull(mCodeMap[code]) { "${code}无效" }
        }

        fun valueOfAny(v: Any): ValueType {
            return when (v) {
                is Boolean -> BOOLEAN
                is Int -> INT
                is Long -> LONG
                is Float -> FLOAT
                is Double -> DOUBLE
                is String -> STRING
                is Date -> DATE
                else -> throw UnsupportedOperationException("不支持类型：${v::class}")
            }
        }
    }
}