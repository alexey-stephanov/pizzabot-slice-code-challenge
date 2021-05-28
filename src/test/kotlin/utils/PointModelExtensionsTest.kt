package utils

import models.MatrixModel
import models.PointModel
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.absoluteDistance
import utils.isValid

class PointModelExtensionsTest {

    @Test
    fun `test correct point`() {
        val point = PointModel(3, 4)
        val matrix = MatrixModel(5, 5)
        assert(point.isValid(matrix))
    }

    @Test
    fun `test correct border point`() {
        val point = PointModel(0, 5)
        val matrix = MatrixModel(5, 5)
        assert(point.isValid(matrix))
    }

    @Test
    fun `test incorrect point with out of matrix negative x coordinate`() {
        val point = PointModel(-3, 4)
        val matrix = MatrixModel(5, 5)
        assertEquals(false, point.isValid(matrix))
    }

    @Test
    fun `test incorrect point with out of matrix negative y coordinate`() {
        val point = PointModel(3, -4)
        val matrix = MatrixModel(5, 5)
        assertEquals(false, point.isValid(matrix))
    }

    @Test
    fun `test incorrect point with out of matrix positive x coordinate`() {
        val point = PointModel(6, 3)
        val matrix = MatrixModel(5, 5)
        assertEquals(false, point.isValid(matrix))
    }

    @Test
    fun `test incorrect point with out of matrix positive y coordinate`() {
        val point = PointModel(3, 6)
        val matrix = MatrixModel(5, 5)
        assertEquals(false, point.isValid(matrix))
    }

    @Test
    fun `test correct absolute distance calculation`() {
        val currentPoint = PointModel(1, 1)
        val targetPoint = PointModel(4, 2)
        assertEquals(4, currentPoint.absoluteDistance(targetPoint))
    }
}