package mappers

import models.MatrixModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MatrixModelMapperTest {

    lateinit var matrixMapper: MatrixMapper

    @Before
    fun setup() {
        matrixMapper = MatrixMapperImpl()
    }

    @Test
    fun `test matrix mapper maps data correctly`() {
        val input = "5x5(1,3)(2,3)"
        val expectedMatrix = MatrixModel(5, 5)
        assertEquals(expectedMatrix, matrixMapper.map(input))
    }
}