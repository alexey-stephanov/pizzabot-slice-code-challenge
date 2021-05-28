package parsers

import exceptions.InvalidInputException
import exceptions.InvalidMatrixException
import exceptions.InvalidPointException
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import mappers.MatrixMapper
import mappers.PointMapper
import models.MatrixModel
import models.PointModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class InputParserTest {

    @MockK
    lateinit var pointMapper: PointMapper

    @MockK
    lateinit var matrixMapper: MatrixMapper

    lateinit var parser: InputParser

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        parser = InputParser(matrixMapper, pointMapper)
    }

    @Test
    fun `test parser correctly parses data with points on matrix's borders`() {
        val input = "5x5(0,3)(2,5)"

        every { pointMapper.map(eq(input)) } returns listOf(PointModel(0, 3), PointModel(2, 5))
        every { matrixMapper.map(eq(input)) } returns MatrixModel(5, 5)

        assertEquals(2, parser.parse(input).size)
    }

    @Test
    fun `test parser correctly parses data without spaces`() {
        val input = "5x5(1,3)(2,3)"

        every { pointMapper.map(eq(input)) } returns listOf(PointModel(1, 3), PointModel(2, 3))
        every { matrixMapper.map(eq(input)) } returns MatrixModel(5, 5)

        assertEquals(2, parser.parse(input).size)
    }

    @Test
    fun `test parser correctly parses data with spaces`() {
        val input = "5x5 (1, 3) (2, 3)"

        every { pointMapper.map(eq(input)) } returns listOf(PointModel(1, 3), PointModel(2, 3))
        every { matrixMapper.map(eq(input)) } returns MatrixModel(5, 5)

        assertEquals(2, parser.parse(input).size)
    }

    @Test
    fun `test parser correctly parses data with some spaces`() {
        val input = "5x5 (1,3)(2, 3)"

        every { pointMapper.map(eq(input)) } returns listOf(PointModel(1, 3), PointModel(2, 3))
        every { matrixMapper.map(eq(input)) } returns MatrixModel(5, 5)

        assertEquals(2, parser.parse(input).size)
    }

    @Test(expected = InvalidInputException::class)
    fun `test parser invalid input`() {
        val input = "5x5 1,3)(2,3)"
        parser.parse(input)
    }

    @Test(expected = InvalidMatrixException::class)
    fun `test parser incorrect matrix size`() {
        val input = "0x0(1,3)(2,3)"

        every { pointMapper.map(eq(input)) } returns listOf(PointModel(1, 3), PointModel(2, 3))
        every { matrixMapper.map(eq(input)) } returns MatrixModel(0, 0)

        parser.parse(input)
    }

    @Test(expected = InvalidPointException::class)
    fun `test parser out of matrix point`() {
        val input = "3x3(1,4)(2,3)"

        every { pointMapper.map(eq(input)) } returns listOf(PointModel(1, 4), PointModel(2, 3))
        every { matrixMapper.map(eq(input)) } returns MatrixModel(3, 3)

        parser.parse(input)
    }
}