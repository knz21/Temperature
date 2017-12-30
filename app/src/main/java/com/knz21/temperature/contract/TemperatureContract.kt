package com.knz21.temperature.contract

import com.knz21.temperature.common.Type

interface TemperatureContract {
    fun plus(type: Type)
    fun minus(type: Type)
}