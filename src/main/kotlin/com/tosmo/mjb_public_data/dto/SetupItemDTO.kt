package com.tosmo.mjb_public_data.dto

import com.tosmo.ktils.serializer.DateAsStringSerializer
import com.tosmo.mjb_public_data.enums.ValueType
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.serialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure
import kotlinx.serialization.json.*
import java.util.*

/**
 * 设置项传输实体
 */
@Serializable(SetupItemDTO.Serializer::class)
data class SetupItemDTO(
    /**
     * 设置项名称
     */
    var name: String,
    /**
     * 键
     */
    var key: String,
    /**
     * 值
     */
    var value: Any?,
    /**
     * 值的类型
     */
    var valueType: ValueType,
    /**
     * 描述
     */
    var description: String
) : java.io.Serializable {

    internal class Serializer : KSerializer<SetupItemDTO> {

        override val descriptor: SerialDescriptor =
            buildClassSerialDescriptor("com.tosmo.mjb_public_data.dto.SetupItemDTO2") {
                element("name", serialDescriptor<String>())
                element("key", serialDescriptor<String>())
                element("value", buildClassSerialDescriptor("Any"))
                element("valueType", serialDescriptor<ValueType>())
                element("description", serialDescriptor<String>())
            }


        override fun deserialize(decoder: Decoder): SetupItemDTO {
            return decoder.decodeStructure(descriptor) {
                val name = decodeStringElement(descriptor, 0)
                val key = decodeStringElement(descriptor, 1)
                val type = decodeSerializableElement(descriptor, 3, serializer<ValueType>())
                val description = decodeStringElement(descriptor, 4)
                val value: Any? = 2.let { index ->
                    runCatching {
                        when (type) {
                            ValueType.BOOLEAN -> decodeBooleanElement(descriptor, index)
                            ValueType.INT -> decodeIntElement(descriptor, index)
                            ValueType.LONG -> decodeLongElement(descriptor, index)
                            ValueType.FLOAT -> decodeFloatElement(descriptor, index)
                            ValueType.DOUBLE -> decodeDoubleElement(descriptor, index)
                            ValueType.STRING -> decodeStringElement(descriptor, index)
                            ValueType.DATE -> decodeSerializableElement(descriptor, index, DateAsStringSerializer)
                        }
                    }.getOrDefault(null)
                }
                SetupItemDTO(name, key, value, type, description)
            }
        }

        override fun serialize(encoder: Encoder, value: SetupItemDTO) {
            encoder.encodeStructure(descriptor) {
                encodeStringElement(descriptor, 0, value.name)
                encodeStringElement(descriptor, 1, value.key)
                value.value?.let {
                    val index = 2
                    when (value.valueType) {
                        ValueType.BOOLEAN -> encodeBooleanElement(descriptor, index, it.toString().toBoolean())
                        ValueType.INT -> encodeIntElement(descriptor, index, it.toString().toInt())
                        ValueType.LONG -> encodeLongElement(descriptor, index, it.toString().toLong())
                        ValueType.FLOAT -> encodeFloatElement(descriptor, index, it.toString().toFloat())
                        ValueType.DOUBLE -> encodeDoubleElement(descriptor, index, it.toString().toDouble())
                        ValueType.STRING -> encodeStringElement(descriptor, index, it.toString())
                        ValueType.DATE -> encodeSerializableElement(
                            descriptor, index, DateAsStringSerializer, it as Date
                        )
                    }
                }
                encodeSerializableElement(descriptor, 3, serializer<ValueType>(), value.valueType)
                encodeStringElement(descriptor, 4, value.description)
            }
        }
    }
}
