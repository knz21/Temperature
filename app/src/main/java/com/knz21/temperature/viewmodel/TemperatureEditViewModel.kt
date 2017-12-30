package com.knz21.temperature.viewmodel

import android.view.View
import com.knz21.temperature.common.Type
import com.knz21.temperature.contract.TemperatureContract

class TemperatureEditViewModel(val contract: TemperatureContract, val type: Type) {
    @Suppress("unused_parameter")
    fun onClickLeft(v: View) {
        contract.minus(type)
    }

    @Suppress("unused_parameter")
    fun onClickRight(v: View) {
        contract.plus(type)
    }
}