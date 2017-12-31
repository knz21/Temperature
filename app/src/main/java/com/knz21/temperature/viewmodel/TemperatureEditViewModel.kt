package com.knz21.temperature.viewmodel

import android.view.View
import com.knz21.temperature.common.Type
import com.knz21.temperature.contract.TemperatureContract

class TemperatureEditViewModel(val contract: TemperatureContract, val type: Type) {
    @Suppress("unused_parameter")
    fun minus10(v: View) {
        contract.plus(type, -10f)
    }

    @Suppress("unused_parameter")
    fun minus(v: View) {
        contract.plus(type, -1f)
    }

    @Suppress("unused_parameter")
    fun minus01(v: View) {
        contract.plus(type, -0.1f)
    }

    @Suppress("unused_parameter")
    fun plus01(v: View) {
        contract.plus(type, 0.1f)
    }

    @Suppress("unused_parameter")
    fun plus(v: View) {
        contract.plus(type)
    }

    @Suppress("unused_parameter")
    fun plus10(v: View) {
        contract.plus(type, 10f)
    }
}