package com.knz21.temperature.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.knz21.temperature.R
import com.knz21.temperature.common.Type
import com.knz21.temperature.contract.TemperatureContract
import com.knz21.temperature.databinding.ActivityTemperatureBinding
import com.knz21.temperature.model.Temperature
import com.knz21.temperature.viewmodel.TemperatureEditViewModel
import com.knz21.temperature.viewmodel.TemperatureViewModel

class TemperatureActivity : AppCompatActivity(), TemperatureContract {
    private val temperature = Temperature()
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityTemperatureBinding>(this, R.layout.activity_temperature)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)
        FirebaseAnalytics.getInstance(this).logEvent(FirebaseAnalytics.Event.APP_OPEN, null)
        binding.celsius = TemperatureViewModel(temperature, Type.Celsius)
        binding.fahrenheit = TemperatureViewModel(temperature, Type.Fahrenheit)
        binding.kelvin = TemperatureViewModel(temperature, Type.Kelvin)
        binding.celsiusEdit.binding.viewModel = TemperatureEditViewModel(this, Type.Celsius)
        binding.fahrenheitEdit.binding.viewModel = TemperatureEditViewModel(this, Type.Fahrenheit)
        binding.kelvinEdit.binding.viewModel = TemperatureEditViewModel(this, Type.Kelvin)
    }

    override fun plus(type: Type) {
        nextValue(type, 1).let {
            temperature.saveValue(type, it)
            setText(type, it.toString())
        }
    }

    override fun minus(type: Type) {
        nextValue(type, -1).let {
            temperature.saveValue(type, it)
            setText(type, it.toString())
        }
    }

    private fun nextValue(type: Type, step: Int): Float = (currentValue(type) + step).toDouble().let {
        (if (step > 0) Math.floor(it) else Math.ceil(it)).toFloat()
    }

    private fun currentValue(type: Type): Float = when (type) {
        is Type.Celsius -> binding.celsiusEdit.getValue()
        is Type.Fahrenheit -> binding.fahrenheitEdit.getValue()
        is Type.Kelvin -> binding.kelvinEdit.getValue()
    }

    private fun setText(type: Type, text: String) {
        when (type) {
            is Type.Celsius -> {
                binding.celsiusEdit.setText(text)
                binding.fahrenheitEdit.setText(temperature.getDisplayValue(Type.Fahrenheit))
                binding.kelvinEdit.setText(temperature.getDisplayValue(Type.Kelvin))
            }
            is Type.Fahrenheit -> {
                binding.celsiusEdit.setText(temperature.getDisplayValue(Type.Celsius))
                binding.fahrenheitEdit.setText(text)
                binding.kelvinEdit.setText(temperature.getDisplayValue(Type.Kelvin))
            }
            is Type.Kelvin -> {
                binding.celsiusEdit.setText(temperature.getDisplayValue(Type.Celsius))
                binding.fahrenheitEdit.setText(temperature.getDisplayValue(Type.Fahrenheit))
                binding.kelvinEdit.setText(text)
            }
        }
    }
}
