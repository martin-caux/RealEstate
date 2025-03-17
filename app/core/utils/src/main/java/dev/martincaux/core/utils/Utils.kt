package dev.martincaux.core.utils

import android.icu.util.LocaleData
import android.icu.util.ULocale
import android.os.Build
import co.touchlab.kermit.Logger
import java.text.NumberFormat
import java.util.Locale

fun formatPrice(price: Double, logger: Logger): String {
    logger.withTag("formatPrice")
    val currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault())
    currencyFormat.minimumFractionDigits = 0
    currencyFormat.maximumFractionDigits = 2
    val formattedPrice = currencyFormat.format(price)
    logger.d { "unformattedPrice : $price - formattedPrice : $formattedPrice" }
    return formattedPrice
}

fun formatArea(area: Double, logger: Logger): String {
    logger.withTag("formatArea")
    val unit = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        val measurementSystem = LocaleData.getMeasurementSystem(ULocale.getDefault())
        when (measurementSystem) {
            LocaleData.MeasurementSystem.SI -> AreaUnit.SQ_METERS
            LocaleData.MeasurementSystem.US -> AreaUnit.SQ_FEET
            LocaleData.MeasurementSystem.UK -> AreaUnit.SQ_METERS
            else -> AreaUnit.SQ_METERS
        }
    } else {
        AreaUnit.SQ_METERS
    }
    val formattedArea = String.format(locale = Locale.getDefault(), "%.0f ${unit.value}", area)

    logger.d { "unformattedArea : $area - formattedArea : $formattedArea" }
    return formattedArea
}

inline fun <T1 : Any, T2 : Any, R : Any> anyNotNull(p1: T1?, p2: T2?, block: (T1?, T2?) -> R?): R? {
    return if (p1 != null || p2 != null) block(p1, p2) else null
}

enum class AreaUnit(val value: String) {
    SQ_METERS("m²"),
    SQ_FEET("ft²")
}