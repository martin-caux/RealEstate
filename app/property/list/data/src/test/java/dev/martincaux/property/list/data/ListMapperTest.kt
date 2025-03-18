package dev.martincaux.property.list.data

import dev.martincaux.property.list.data.mapper.ListMapper
import dev.martincaux.property.list.data.response.ListItemDTO
import dev.martincaux.property.list.data.response.ListResponse
import dev.martincaux.property.list.domain.model.ListDomain
import dev.martincaux.property.list.domain.model.PropertyItemDomain
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class ListMapperTest {

    private var mapper: ListMapper = ListMapper()

    @Test
    fun `map returns ListDomain when ListResponse is a complete response`() = runTest {
        // Arrange
        val listData = ListResponse(
            itemsList = listOf(
                ListItemDTO(
                    id = 1,
                    city = "Paris",
                    area = 100.0,
                    rooms = 2,
                    bedrooms = 1,
                    price = 150000.0,
                    professional = "TestProfessional1",
                    propertyType = "TestPropertyType1",
                    offerType = 1,
                    url = "TestUrl"
                ),
                ListItemDTO(
                    id = 2,
                    city = "Londres",
                    area = 100.0,
                    rooms = 2,
                    bedrooms = 1,
                    price = 150000.0,
                    professional = "TestProfessional2",
                    propertyType = "TestPropertyType2",
                    offerType = 1,
                    url = "TestUrl2"
                ),
                ListItemDTO(
                    id = 3,
                    city = "Berlin",
                    area = 100.0,
                    rooms = 2,
                    bedrooms = 1,
                    price = 150000.0,
                    professional = "TestProfessional3",
                    propertyType = "TestPropertyType3",
                    offerType = 1,
                    url = "TestUrl3"
                )
            ),
            totalCount = 3
        )
        val expectedListDomain = ListDomain(
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
                    area = 100.0,
                    rooms = 2,
                    bedrooms = 1,
                    price = 150000.0,
                    professional = "TestProfessional2",
                    propertyType = "TestPropertyType2",
                    offerType = 1,
                    imageUrl = "TestUrl2"
                ),
                PropertyItemDomain(
                    id = 3,
                    city = "Berlin",
                    area = 100.0,
                    rooms = 2,
                    bedrooms = 1,
                    price = 150000.0,
                    professional = "TestProfessional3",
                    propertyType = "TestPropertyType3",
                    offerType = 1,
                    imageUrl = "TestUrl3"
                )
            ),
            propertyCount = 3
        )

        // Act
        val result = mapper.map(listData)

        // Assert
        assertEquals(expectedListDomain, result)
    }

    @Test
    fun `map returns ListDomain when some ListResponse items have missing optional fields`() =
        runTest {
            // Arrange
            val listData = ListResponse(
                itemsList = listOf(
                    ListItemDTO(
                        id = 1,
                        city = "Paris",
                        area = 100.0,
                        price = 150000.0,
                        professional = "TestProfessional1",
                        propertyType = "TestPropertyType1",
                        offerType = 1,
                        url = "TestUrl",
                    ),
                    ListItemDTO(
                        id = 2,
                        city = "Londres",
                        area = 100.0,
                        rooms = 2,
                        bedrooms = 1,
                        price = 150000.0,
                        professional = "TestProfessional2",
                        propertyType = "TestPropertyType2",
                        offerType = 1,
                    ),
                    ListItemDTO(
                        id = 3,
                        city = "Berlin",
                        area = 100.0,
                        price = 150000.0,
                        professional = "TestProfessional3",
                        propertyType = "TestPropertyType3",
                        offerType = 1,
                    )
                ),
                totalCount = 3
            )
            val expectedListDomain = ListDomain(
                properties = listOf(
                    PropertyItemDomain(
                        id = 1,
                        city = "Paris",
                        area = 100.0,
                        rooms = null,
                        bedrooms = null,
                        price = 150000.0,
                        professional = "TestProfessional1",
                        propertyType = "TestPropertyType1",
                        offerType = 1,
                        imageUrl = "TestUrl"
                    ),
                    PropertyItemDomain(
                        id = 2,
                        city = "Londres",
                        area = 100.0,
                        rooms = 2,
                        bedrooms = 1,
                        price = 150000.0,
                        professional = "TestProfessional2",
                        propertyType = "TestPropertyType2",
                        offerType = 1,
                        imageUrl = null
                    ),
                    PropertyItemDomain(
                        id = 3,
                        city = "Berlin",
                        area = 100.0,
                        rooms = null,
                        bedrooms = null,
                        price = 150000.0,
                        professional = "TestProfessional3",
                        propertyType = "TestPropertyType3",
                        offerType = 1,
                        imageUrl = null
                    )
                ),
                propertyCount = 3
            )

            // Act
            val result = mapper.map(listData)

            // Assert
            assertEquals(expectedListDomain, result)
        }

    @Test
    fun `map returns ListDomain with empty list when some ListResponse items have missing mandatory fields`() =
        runTest {
            // Arrange
            val listData = ListResponse(
                itemsList = listOf(
                    ListItemDTO(
                        id = 1,
                        city = "Paris",
                        area = 100.0,
                        rooms = 2,
                        bedrooms = 1,
                        price = 150000.0,
                        professional = "TestProfessional1",
                        propertyType = "TestPropertyType1",
                        offerType = 1,
                        url = "TestUrl"
                    ),
                    ListItemDTO(
                        id = 2,
                        city = "Londres",
                        area = 100.0,
                        rooms = 2,
                        bedrooms = 1,
                        price = 150000.0,
                        professional = "TestProfessional2",
                        propertyType = "TestPropertyType2",
                        offerType = 1,
                        url = "TestUrl2"
                    ),
                    ListItemDTO(
                        id = 3,
                        area = 100.0,
                        rooms = 2,
                        bedrooms = 1,
                        price = 150000.0,
                        professional = "TestProfessional3",
                        propertyType = "TestPropertyType3",
                        offerType = 1,
                        url = "TestUrl3"
                    )
                ),
                totalCount = 3
            )
            val expectedListDomain = ListDomain(
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
                        area = 100.0,
                        rooms = 2,
                        bedrooms = 1,
                        price = 150000.0,
                        professional = "TestProfessional2",
                        propertyType = "TestPropertyType2",
                        offerType = 1,
                        imageUrl = "TestUrl2"
                    ),
                ),
                propertyCount = 2
            )
            // Act
            val result = mapper.map(listData)

            // Assert
            assertEquals(expectedListDomain, result)
        }

    @Test
    fun `map returns ListDomain with empty list when all ListResponse items are missing mandatory fields`() =
        runTest {
            // Arrange
            val listData = ListResponse(
                itemsList = listOf(
                    ListItemDTO(
                        id = 1,
                        city = "Paris",
                        rooms = 2,
                        bedrooms = 1,
                        price = 150000.0,
                        professional = "TestProfessional1",
                        propertyType = "TestPropertyType1",
                        offerType = 1,
                        url = "TestUrl"
                    ),
                    ListItemDTO(
                        id = 2,
                        area = 100.0,
                        rooms = 2,
                        bedrooms = 1,
                        price = 150000.0,
                        professional = "TestProfessional2",
                        propertyType = "TestPropertyType2",
                        offerType = 1,
                        url = "TestUrl2"
                    ),
                    ListItemDTO(
                        id = 3,
                        area = 100.0,
                        rooms = 2,
                        bedrooms = 1,
                        price = 150000.0,
                        professional = "TestProfessional3",
                        offerType = 1,
                        url = "TestUrl3"
                    )
                ),
                totalCount = 3
            )
            val expectedListDomain = ListDomain(
                properties = emptyList(),
                propertyCount = 0
            )
            // Act
            val result = mapper.map(listData)

            // Assert
            assertEquals(expectedListDomain, result)
        }
}