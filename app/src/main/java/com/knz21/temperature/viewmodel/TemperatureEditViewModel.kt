package com.knz21.temperature.viewmodel

import android.view.View
import com.knz21.temperature.common.Type
import com.knz21.temperature.contract.TemperatureContract

class TemperatureEditViewModel(val contract: TemperatureContract, val type: Type) {
    fun onClickLeft(v: View) {
        contract.minus(type)
    }
    fun onClickRight(v: View) {
        contract.plus(type)
    }
}