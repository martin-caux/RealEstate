package dev.martincaux.core.utils

import androidx.test.ext.junit.runners.AndroidJUnit4
import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Locale

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class UtilInstrumentedTest {

    private var logger: Logger = Logger(StaticConfig())
    private val defaultLocale = Locale.getDefault()

    @Before
    fun setUp() {
        Locale.setDefault(defaultLocale)
    }

    @Test
    fun formatAreaFRLocale() {
        // Arrange
        Locale.setDefault(Locale.FRANCE)
        val area = 150.00
        val expectedFormattedPrice = "150 m²"

        // Act
        val result = formatArea(area, logger)

        // Assert
        assertEquals(expectedFormattedPrice, result)
    }

    @Test
    fun formatAreaUKLocale() {
        // Arrange
        Locale.setDefault(Locale.UK)
        val area = 150.00
        val expectedFormattedPrice = "150 m²"

        // Act
        val result = formatArea(area, logger)

        // Assert
        assertEquals(expectedFormattedPrice, result)
    }

    @Test
    fun formatAreaUSLocale() {
        // Arrange
        Locale.setDefault(Locale.US)
        val area = 150.00
        val expectedFormattedPrice = "150 ft²"

        // Act
        val result = formatArea(area, logger)

        // Assert
        assertEquals(expectedFormattedPrice, result)
    }

    @After
    fun tearDown() {
        Locale.setDefault(defaultLocale)
    }
}