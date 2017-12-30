package com.knz21.temperature.view

import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.knz21.temperature.R
import com.knz21.temperature.databinding.ViewTemperatureEditBinding

class TemperatureEditView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                                    defStyleAttr: Int = 0, defStyleRes: Int = 0) :
        LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    internal val binding: ViewTemperatureEditBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_temperature_edit, this, true)

    fun getValue(): Float = binding.temperatureText.text.charToFloat()

    private fun CharSequence.charToFloat(): Float = try {
        toString().toFloat()
    } catch (e: NumberFormatException) {
        0f
    }
}

@BindingAdapter("text")
fun TemperatureEditView.setText(text: String) {
    binding.temperatureText.text = text
}
