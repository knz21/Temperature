package com.knz21.temperature.common

private const val ROUND_DIGIT = 100
private const val CEIL_FLOOR_DIGIT = 10

fun Float.decimalPlus(value: Float): Float =
        (Math.round(this * ROUND_DIGIT) + Math.round(value * ROUND_DIGIT)).toFloat() / ROUND_DIGIT

fun Float.round(): Float = Math.round(this * ROUND_DIGIT).toFloat() / ROUND_DIGIT

fun Float.isDecimal(): Boolean = Math.abs(this).let { it > 0 && it < 1 }

fun Float.hasTruncation(): Boolean = toString().split(".")[1].length > 1

fun Float.ceilOrFloor(isCeil: Boolean): Float = (this * CEIL_FLOOR_DIGIT).toDouble()
        .let { if (isCeil) Math.ceil(it) else Math.floor(it) }.toFloat() / CEIL_FLOOR_DIGIT

fun Float.validValue(type: Type): Float = if (type.isValid(this)) this else type.getAbsoluteZero()
