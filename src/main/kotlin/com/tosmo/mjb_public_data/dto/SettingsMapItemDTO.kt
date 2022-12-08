package com.tosmo.mjb_public_data.dto

import com.tosmo.ktils.TimeUtils
import com.tosmo.mjb_public_data.enums.ValueType
import kotlinx.serialization.Serializable

@Serializable
data class SettingsMapItemDTO(
    /**
     * 设置项名称
     */
    val name: String,
    /**
     * 键
     */
    val key: String,
    /**
     * 字符串形式的值
     */
    val stringValue: String,
    /**
     * 值的类型
     */
    val valueType: ValueType,
    /**
     * 描述
     */
    val description: String
) : java.io.Serializable {

    /**
     * 实际的value
     */
    val value: Any?
        get() = if (stringValue.isEmpty()) null else when (valueType) {
            ValueType.BOOLEAN -> stringValue.toBoolean()
            ValueType.INT -> stringValue.toInt()
            ValueType.LONG -> stringValue.toLong()
            ValueType.FLOAT -> stringValue.toFloat()
            ValueType.DOUBLE -> stringValue.toDouble()
            ValueType.STRING -> stringValue
            ValueType.DATE -> TimeUtils.parseDate(stringValue)
        }
}