package dev.martincaux.property.detail.data

import dev.martincaux.property.detail.data.mapper.DetailMapper
import dev.martincaux.property.detail.data.response.DetailResponse
import dev.martincaux.property.detail.domain.model.DetailDomain
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

@ExperimentalCoroutinesApi
class DetailMapperTest {

    private var mapper: DetailMapper = DetailMapper()

    @Test
    fun `map returns DetailDomain when DetailResponse is a complete response`() = runTest {
        // Arrange
        val itemId = 1
        val detailData = DetailResponse(
            id = itemId,
            city = "Paris",
            area = 100.0,
            rooms = 2,
            bedrooms = 1,
            price = 150000.0,
            professional = "TestProfessional",
            propertyType = "TestPropertyType",
            offerType = 1,
            url = "TestUrl"
        )
        val expectedDetailDomain = DetailDomain(
            id = itemId,
            city = "Paris",
            area = 100.0,
            rooms = 2,
            bedrooms = 1,
            price = 150000.0,
            professional = "TestProfessional",
            propertyType = "TestPropertyType",
            offerType = 1,
            imageUrl = "TestUrl"
        )

        // Act
        val result = mapper.map(detailData)

        // Assert
        assertEquals(expectedDetailDomain, result)
    }

    @Test
    fun `map returns DetailDomain when DetailResponse has missing optional fields`() = runTest {
        // Arrange
        val itemId = 1
        val detailData = DetailResponse(
            id = itemId,
            city = "Paris",
            area = 100.0,
            rooms = 2,
            price = 150000.0,
            professional = "TestProfessional",
            propertyType = "TestPropertyType",
            offerType = 1
        )
        val expectedDetailDomain = DetailDomain(
            id = itemId,
            city = "Paris",
            area = 100.0,
            rooms = 2,
            price = 150000.0,
            professional = "TestProfessional",
            propertyType = "TestPropertyType",
            offerType = 1,
            bedrooms = null,
            imageUrl = null
        )

        // Act
        val result = mapper.map(detailData)

        // Assert
        assertEquals(expectedDetailDomain, result)
    }

    @Test
    fun `map returns null when DetailResponse has missing mandatory fields`() = runTest {
        // Arrange
        val itemId = 1
        val detailData = DetailResponse(
            id = itemId,
            area = 100.0,
            rooms = 2,
            bedrooms = 1,
            price = 150000.0,
            professional = "TestProfessional",
            propertyType = "TestPropertyType",
            offerType = 1,
            url = "TestUrl"
        )
        // Act
        val result = mapper.map(detailData)

        // Assert
        assertNull(null, result)
    }
}