package com.knz21.temperature.viewmodel

import com.knz21.temperature.common.Type
import com.knz21.temperature.model.Temperature

class TemperatureViewModel(val temperature: Temperature, val type: Type) {

    val value: String get() = temperature.getDisplayValue(type)
}