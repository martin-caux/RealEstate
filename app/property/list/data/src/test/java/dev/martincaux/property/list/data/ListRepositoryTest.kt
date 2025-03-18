package dev.martincaux.property.list.data

import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import dev.martincaux.property.list.data.datasource.ListRemoteDataSource
import dev.martincaux.property.list.data.mapper.ListMapper
import dev.martincaux.property.list.data.repository.ListRepositoryImpl
import dev.martincaux.property.list.data.response.ListItemDTO
import dev.martincaux.property.list.data.response.ListResponse
import dev.martincaux.property.list.domain.model.ListDomain
import dev.martincaux.property.list.domain.model.PropertyItemDomain
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class ListRepositoryTest {

    private lateinit var repository: ListRepositoryImpl
    private lateinit var remoteDataSource: ListRemoteDataSource
    private var logger: Logger = Logger(StaticConfig())
    private var mapper: ListMapper = ListMapper()

    @Before
    fun setUp() {
        remoteDataSource = mockk()
        repository = ListRepositoryImpl(remoteDataSource, mapper, logger)
    }

    @Test
    fun `getList returns ResultSuccess with full List when remote data source returns ResponseSuccess with complete data`() = runTest {
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
        coEvery { remoteDataSource.getListResponse() } returns Response.success(listData)

        // Act
        val result = repository.getList()

        // Assert
        assertTrue(result.isSuccess)
        assertEquals(Result.success(expectedListDomain), result)
    }

    @Test
    fun `getList returns ResultSuccess with full List when remote data source returns ResponseSuccess and some list items are missing optional fields`() =
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
            coEvery { remoteDataSource.getListResponse() } returns Response.success(listData)

            // Act
            val result = repository.getList()

            // Assert
            assertTrue(result.isSuccess)
            assertEquals(Result.success(expectedListDomain), result)
        }


    @Test
    fun `getList returns ResultSuccess with partial List when remote data source returns ResponseSuccess and some list item are missing mandatory fields`() =
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
            coEvery { remoteDataSource.getListResponse() } returns Response.success(listData)

            // Act
            val result = repository.getList()

            // Assert
            assertTrue(result.isSuccess)
            assertEquals(Result.success(expectedListDomain), result)
        }

    @Test
    fun `getList returns ResultSuccess with empty list when remote data source returns ResponseSuccess and all list item are missing mandatory fields`() =
        runTest {
            // Arrange
            val listData = ListResponse(
                itemsList = listOf(
                    ListItemDTO(
                        id = 1,
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
                        offerType = 1,
                        url = "TestUrl2"
                    ),
                    ListItemDTO(
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
                properties = emptyList(),
                propertyCount = 0
            )
            coEvery { remoteDataSource.getListResponse() } returns Response.success(listData)

            // Act
            val result = repository.getList()

            // Assert
            assertTrue(result.isSuccess)
            assertEquals(Result.success(expectedListDomain), result)
        }

    @Test
    fun `getList returns ResultFailure when remote data source returns ResponseError`() = runTest {
        // Arrange
        val expectedException = Exception("Network Error")
        coEvery { remoteDataSource.getListResponse() } returns Response.error(
            404,
            mockk(relaxed = true)
        )

        // Act
        val result = repository.getList()

        // Assert
        assertTrue(result.isFailure)
        assertEquals(expectedException.message, result.exceptionOrNull()?.message)
    }
}