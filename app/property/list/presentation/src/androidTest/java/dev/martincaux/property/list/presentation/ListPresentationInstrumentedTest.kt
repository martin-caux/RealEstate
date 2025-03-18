package dev.martincaux.property.list.presentation

import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.martincaux.property.common.uimodel.PropertyItemUi
import dev.martincaux.property.list.domain.model.ListDomain
import dev.martincaux.property.list.domain.model.PropertyItemDomain
import dev.martincaux.property.list.presentation.mapper.toUi
import dev.martincaux.property.list.presentation.uimodel.PropertyListUi
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
class ListPresentationInstrumentedTest {

    private val defaultLocale = Locale.getDefault()

    @Before
    fun setUp() {
        Locale.setDefault(defaultLocale)
    }

    @Test
    fun listDomainToUiWithFRLocale() {
        Locale.setDefault(Locale.FRANCE)
        // Arrange
        val listDomain = ListDomain(
            properties = listOf(
                PropertyItemDomain(
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
                ),
                PropertyItemDomain(
                    id = 2,
                    city = "Londres",
                    area = 120.0,
                    rooms = 2,
                    bedrooms = 1,
                    price = 500000.0,
                    professional = "TestProfessional2",
                    propertyType = "TestPropertyType2",
                    offerType = 1,
                    imageUrl = "TestUrl2"
                ),
                PropertyItemDomain(
                    id = 3,
                    city = "Berlin",
                    area = 300.0,
                    rooms = 2,
                    bedrooms = 1,
                    price = 300000.0,
                    professional = "TestProfessional3",
                    propertyType = "TestPropertyType3",
                    offerType = 1,
                    imageUrl = "TestUrl3"
                )
            ),
            propertyCount = 3
        )
        val expectedPropertyListUi = PropertyListUi(
            properties = listOf(
                PropertyItemUi(
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
                ),
                PropertyItemUi(
                    id = 2,
                    city = "Londres",
                    area = 120.0,
                    formattedArea = "120 m²",
                    rooms = 2,
                    bedrooms = 1,
                    price = 500000.0,
                    formattedPrice = "500 000 €",
                    professional = "TestProfessional2",
                    propertyType = "TestPropertyType2",
                    offerType = 1,
                    imageUrl = "TestUrl2"
                ),
                PropertyItemUi(
                    id = 3,
                    city = "Berlin",
                    area = 300.0,
                    formattedArea = "300 m²",
                    rooms = 2,
                    bedrooms = 1,
                    price = 300000.0,
                    formattedPrice = "300 000 €",
                    professional = "TestProfessional3",
                    propertyType = "TestPropertyType3",
                    offerType = 1,
                    imageUrl = "TestUrl3"
                )
            ),
            propertyCount = 3
        )

        // Act
        val result = listDomain.toUi()

        // Assert
        assertEquals(expectedPropertyListUi, result)
    }

    @Test
    fun listDomainToUiWithUKLocale() {
        Locale.setDefault(Locale.UK)
        // Arrange
        val listDomain = ListDomain(
            properties = listOf(
                PropertyItemDomain(
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
                ),
                PropertyItemDomain(
                    id = 2,
                    city = "Londres",
                    area = 120.0,
                    rooms = 2,
                    bedrooms = 1,
                    price = 500000.0,
                    professional = "TestProfessional2",
                    propertyType = "TestPropertyType2",
                    offerType = 1,
                    imageUrl = "TestUrl2"
                ),
                PropertyItemDomain(
                    id = 3,
                    city = "Berlin",
                    area = 300.0,
                    rooms = 2,
                    bedrooms = 1,
                    price = 300000.0,
                    professional = "TestProfessional3",
                    propertyType = "TestPropertyType3",
                    offerType = 1,
                    imageUrl = "TestUrl3"
                )
            ),
            propertyCount = 3
        )
        val expectedPropertyListUi = PropertyListUi(
            properties = listOf(
                PropertyItemUi(
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
                ),
                PropertyItemUi(
                    id = 2,
                    city = "Londres",
                    area = 120.0,
                    formattedArea = "120 m²",
                    rooms = 2,
                    bedrooms = 1,
                    price = 500000.0,
                    formattedPrice = "£500,000",
                    professional = "TestProfessional2",
                    propertyType = "TestPropertyType2",
                    offerType = 1,
                    imageUrl = "TestUrl2"
                ),
                PropertyItemUi(
                    id = 3,
                    city = "Berlin",
                    area = 300.0,
                    formattedArea = "300 m²",
                    rooms = 2,
                    bedrooms = 1,
                    price = 300000.0,
                    formattedPrice = "£300,000",
                    professional = "TestProfessional3",
                    propertyType = "TestPropertyType3",
                    offerType = 1,
                    imageUrl = "TestUrl3"
                )
            ),
            propertyCount = 3
        )

        // Act
        val result = listDomain.toUi()

        // Assert
        assertEquals(expectedPropertyListUi, result)
    }

    @Test
    fun listDomainToUiWithUSLocale() {
        Locale.setDefault(Locale.US)
        // Arrange
        val listDomain = ListDomain(
            properties = listOf(
                PropertyItemDomain(
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
                ),
                PropertyItemDomain(
                    id = 2,
                    city = "Londres",
                    area = 120.0,
                    rooms = 2,
                    bedrooms = 1,
                    price = 500000.0,
                    professional = "TestProfessional2",
                    propertyType = "TestPropertyType2",
                    offerType = 1,
                    imageUrl = "TestUrl2"
                ),
                PropertyItemDomain(
                    id = 3,
                    city = "Berlin",
                    area = 300.0,
                    rooms = 2,
                    bedrooms = 1,
                    price = 300000.0,
                    professional = "TestProfessional3",
                    propertyType = "TestPropertyType3",
                    offerType = 1,
                    imageUrl = "TestUrl3"
                )
            ),
            propertyCount = 3
        )
        val expectedPropertyListUi = PropertyListUi(
            properties = listOf(
                PropertyItemUi(
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
                ),
                PropertyItemUi(
                    id = 2,
                    city = "Londres",
                    area = 120.0,
                    formattedArea = "120 ft²",
                    rooms = 2,
                    bedrooms = 1,
                    price = 500000.0,
                    formattedPrice = "$500,000",
                    professional = "TestProfessional2",
                    propertyType = "TestPropertyType2",
                    offerType = 1,
                    imageUrl = "TestUrl2"
                ),
                PropertyItemUi(
                    id = 3,
                    city = "Berlin",
                    area = 300.0,
                    formattedArea = "300 ft²",
                    rooms = 2,
                    bedrooms = 1,
                    price = 300000.0,
                    formattedPrice = "$300,000",
                    professional = "TestProfessional3",
                    propertyType = "TestPropertyType3",
                    offerType = 1,
                    imageUrl = "TestUrl3"
                )
            ),
            propertyCount = 3
        )

        // Act
        val result = listDomain.toUi()

        // Assert
        assertEquals(expectedPropertyListUi, result)
    }

    @After
    fun tearDown() {
        Locale.setDefault(defaultLocale)
    }
}