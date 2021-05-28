package utils

import models.MatrixModel
import org.junit.Assert.assertEquals
import org.junit.Test

class MatrixModelExtensionsTest {

    @Test
    fun `test correct matrix`() {
        val matrix = MatrixModel(3, 3)
        assert(matrix.isValid)
    }

    @Test
    fun `test incorrect matrix with negative width`() {
        val matrix = MatrixModel(-3, 3)
        assertEquals(false, matrix.isValid)
    }

    @Test
    fun `test incorrect matrix with negative height`() {
        val matrix = MatrixModel(3, -3)
        assertEquals(false, matrix.isValid)
    }

    @Test
    fun `test incorrect matrix with zero width`() {
        val matrix = MatrixModel(0, 3)
        assertEquals(false, matrix.isValid)
    }

    @Test
    fun `test incorrect matrix with zero height`() {
        val matrix = MatrixModel(3, 0)
        assertEquals(false, matrix.isValid)
    }
}