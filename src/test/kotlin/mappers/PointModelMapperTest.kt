package mappers

import models.PointModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PointModelMapperTest {

    lateinit var pointMapper: PointMapper

    @Before
    fun setup() {
        pointMapper = PointMapperImpl()
    }

    @Test
    fun `test point mapper maps data correctly`() {
        val input = "5x5(1,3)(2,3)"
        val expectedPoints = listOf(PointModel(1, 3), PointModel(2, 3))
        Assert.assertEquals(expectedPoints, pointMapper.map(input))
    }
}