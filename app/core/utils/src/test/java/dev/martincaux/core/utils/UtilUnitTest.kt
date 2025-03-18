package dev.martincaux.core.utils

import android.icu.util.ULocale
import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import io.mockk.mockk
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.Locale

class UtilUnitTest {

    private var logger: Logger = Logger(StaticConfig())
    private lateinit var uLocale: ULocale
    private val defaultLocale = Locale.getDefault()

    @Before
    fun setUp() {
        Locale.setDefault(defaultLocale)
        uLocale = mockk()
    }

    @Test
    fun `formatPrice returns formatted price with FR Locale`() {
        // Arrange
        Locale.setDefault(Locale.FRANCE)
        val price = 50000.00
        val expectedFormattedPrice = "50 000 €"

        // Act
        val result = formatPrice(price, logger)

        // Assert
        assertEquals(expectedFormattedPrice, result)
    }

    @Test
    fun `formatPrice returns formatted price with UK Locale`() {
        // Arrange
        Locale.setDefault(Locale.UK)
        val price = 50000.00
        val expectedFormattedPrice = "£50,000"

        // Act
        val result = formatPrice(price, logger)

        // Assert
        assertEquals(expectedFormattedPrice, result)
    }

    @Test
    fun `formatPrice returns formatted price with US Locale`() {
        // Arrange
        Locale.setDefault(Locale.US)
        val price = 50000.00
        val expectedFormattedPrice = "$50,000"

        // Act
        val result = formatPrice(price, logger)

        // Assert
        assertEquals(expectedFormattedPrice, result)
    }

    @After
    fun tearDown() {
        Locale.setDefault(defaultLocale)
    }
}

