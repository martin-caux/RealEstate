package dev.martincaux.property.detail.data

import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import dev.martincaux.property.detail.data.datasource.DetailRemoteDataSource
import dev.martincaux.property.detail.data.mapper.DetailMapper
import dev.martincaux.property.detail.data.repository.DetailRepositoryImpl
import dev.martincaux.property.detail.data.response.DetailResponse
import dev.martincaux.property.detail.domain.model.DetailDomain
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
class DetailRepositoryTest {

    private lateinit var repository: DetailRepositoryImpl
    private lateinit var remoteDataSource: DetailRemoteDataSource
    private var logger: Logger = Logger(StaticConfig())
    private var mapper: DetailMapper = DetailMapper()

    @Before
    fun setUp() {
        remoteDataSource = mockk()
        repository = DetailRepositoryImpl(remoteDataSource, mapper, logger)
    }

    @Test
    fun `getDetail returns ResultSuccess when remote data source returns ResponseSuccess with complete data`() = runTest {
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
        coEvery { remoteDataSource.getDetailResponse(itemId) } returns Response.success(detailData)

        // Act
        val result = repository.getDetail(itemId)

        // Assert
        assertTrue(result.isSuccess)
        assertEquals(Result.success(expectedDetailDomain), result)
    }

    @Test
    fun `getDetail returns ResultSuccess when remote data source returns ResponseSuccess with data missing optional fields`() =
        runTest {
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
            coEvery { remoteDataSource.getDetailResponse(itemId) } returns Response.success(
                detailData
            )

            // Act
            val result = repository.getDetail(itemId)

            // Assert
            assertTrue(result.isSuccess)
            assertEquals(Result.success(expectedDetailDomain), result)
        }

    @Test
    fun `getDetail returns ResultFailure when remote data source returns ResponseSuccess with data missing mandatory fields`() =
        runTest {
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
            val expectedException: Exception = Exception("Detail missing mandatory fields")
            coEvery { remoteDataSource.getDetailResponse(itemId) } returns Response.success(
                detailData
            )

            // Act
            val result = repository.getDetail(itemId)

            // Assert
            assertTrue(result.isFailure)
            assertEquals(expectedException.message, result.exceptionOrNull()?.message)
        }

    @Test
    fun `getDetail returns ResultFailure when remote data source returns ResponseError`() = runTest {
        // Arrange
        val itemId = 1
        val expectedException = Exception("Network Error")
        coEvery { remoteDataSource.getDetailResponse(itemId) } returns Response.error(
            404,
            mockk(relaxed = true)
        )

        // Act
        val result = repository.getDetail(itemId)

        // Assert
        assertTrue(result.isFailure)
        assertEquals(expectedException.message, result.exceptionOrNull()?.message)
    }
}