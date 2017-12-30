package com.knz21.temperature.model

import com.knz21.temperature.common.Type

private const val BASE_CELSIUS: Float = 25f

class Temperature {
    private var base: Float = BASE_CELSIUS

    fun getDisplayValue(type: Type): String = type.calcDisplayValue(base).toString()

    fun saveValue(type: Type, value: Float) {
        base = type.calcBaseValue(value)
    }
}