package dev.martincaux.property.detail.presentation

import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.martincaux.property.common.uimodel.PropertyDetailUi
import dev.martincaux.property.detail.domain.model.DetailDomain
import dev.martincaux.property.detail.presentation.mapper.toUi
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
class DetailPresentationInstrumentedTest {
    private val defaultLocale = Locale.getDefault()

    @Before
    fun setUp() {
        Locale.setDefault(defaultLocale)
    }

    @Test
    fun detailDomainToUiWithFRLocale() {
        Locale.setDefault(Locale.FRANCE)
        // Arrange
        val detailDomain = DetailDomain(
            id = 1,
            city = "Paris",
            area = 100.0,
            rooms = 2,
            bedrooms = 1,
            price = 150000.0,
            professional = "TestProfessional1",
            propertyType = "TestPropertyType1",
            offerType = 1,
            imageUrl = "TestUrl"
        )
        val expectedPropertyDetailUi = PropertyDetailUi(
            id = 1,
            city = "Paris",
            area = 100.0,
            formattedArea = "100 m²",
            rooms = 2,
            bedrooms = 1,
            price = 150000.0,
            formattedPrice = "150 000 €",
            professional = "TestProfessional1",
            propertyType = "TestPropertyType1",
            offerType = 1,
            imageUrl = "TestUrl"
        )

        // Act
        val result = detailDomain.toUi()

        // Assert
        assertEquals(expectedPropertyDetailUi, result)
    }

    @Test
    fun detailDomainToUiWithUKLocale() {
        Locale.setDefault(Locale.UK)
        // Arrange
        val listDomain = DetailDomain(
            id = 1,
            city = "Paris",
            area = 100.0,
            rooms = 2,
            bedrooms = 1,
            price = 150000.0,
            professional = "TestProfessional1",
            propertyType = "TestPropertyType1",
            offerType = 1,
            imageUrl = "TestUrl"
        )
        val expectedPropertyDetailUi = PropertyDetailUi(
            id = 1,
            city = "Paris",
            area = 100.0,
            formattedArea = "100 m²",
            rooms = 2,
            bedrooms = 1,
            price = 150000.0,
            formattedPrice = "£150,000",
            professional = "TestProfessional1",
            propertyType = "TestPropertyType1",
            offerType = 1,
            imageUrl = "TestUrl"
        )

        // Act
        val result = listDomain.toUi()

        // Assert
        assertEquals(expectedPropertyDetailUi, result)
    }

    @Test
    fun detailDomainToUiWithUSLocale() {
        Locale.setDefault(Locale.US)
        // Arrange
        val listDomain = DetailDomain(
            id = 1,
            city = "Paris",
            area = 100.0,
            rooms = 2,
            bedrooms = 1,
            price = 150000.0,
            professional = "TestProfessional1",
            propertyType = "TestPropertyType1",
            offerType = 1,
            imageUrl = "TestUrl"
        )
        val expectedPropertyDetailUi = PropertyDetailUi(
            id = 1,
            city = "Paris",
            area = 100.0,
            formattedArea = "100 ft²",
            rooms = 2,
            bedrooms = 1,
            price = 150000.0,
            formattedPrice = "$150,000",
            professional = "TestProfessional1",
            propertyType = "TestPropertyType1",
            offerType = 1,
            imageUrl = "TestUrl"
        )

        // Act
        val result = listDomain.toUi()

        // Assert
        assertEquals(expectedPropertyDetailUi, result)
    }

    @After
    fun tearDown() {
        Locale.setDefault(defaultLocale)
    }
}