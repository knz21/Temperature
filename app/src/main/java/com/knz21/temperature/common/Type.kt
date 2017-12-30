package com.knz21.temperature.common

private const val F_FREEZING: Int = 32
private const val K_FREEZING: Float = 273.15f
private const val RATIO: Float = 1.8f
private const val ROUND_DIGIT = 100

sealed class Type {
    object Celsius : Type()
    object Fahrenheit : Type()
    object Kelvin : Type()

    fun calcDisplayValue(base: Float): Float = when (this) {
        is Celsius -> base
        is Fahrenheit -> base.celsiusToFahrenheit()
        is Kelvin -> base.celsiusToKelvin()
    }.round()

    fun calcBaseValue(value: Float): Float = when (this) {
        is Celsius -> value
        is Fahrenheit -> value.fahrenheitToCelsius()
        is Kelvin -> value.kelvinToCelsius()
    }.round()

    private fun Float.kelvinToCelsius(): Float = this - K_FREEZING
    private fun Float.celsiusToFahrenheit(): Float = this * RATIO + F_FREEZING
    private fun Float.celsiusToKelvin(): Float = this + K_FREEZING
    private fun Float.fahrenheitToCelsius(): Float = (this - F_FREEZING) / RATIO
    private fun Float.round(): Float = Math.round(this * ROUND_DIGIT).toFloat() / ROUND_DIGIT
}