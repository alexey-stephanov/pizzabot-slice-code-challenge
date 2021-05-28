package navigators

import models.Instructions
import models.PointModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class NavigatorTest {

    lateinit var navigator: Navigator

    @Before
    fun setup() {
        navigator = NavigatorImpl()
    }

    @Test
    fun `test get instructions without similar points`() {
        val points = listOf(PointModel(0, 3), PointModel(2, 2), PointModel(3, 1))
        val expectedPath = listOf(
            Instructions.North,
            Instructions.North,
            Instructions.North,
            Instructions.Drop,
            Instructions.East,
            Instructions.East,
            Instructions.South,
            Instructions.Drop,
            Instructions.East,
            Instructions.South,
            Instructions.Drop
        )
        assertEquals(expectedPath, navigator.getInstructions(points))
    }

    @Test
    fun `test get instructions with similar points`() {
        val points = listOf(PointModel(0, 3), PointModel(2, 2), PointModel(0, 3))
        val expectedPath = listOf(
            Instructions.North,
            Instructions.North,
            Instructions.North,
            Instructions.Drop,
            Instructions.Drop,
            Instructions.East,
            Instructions.East,
            Instructions.South,
            Instructions.Drop
        )
        assertEquals(expectedPath, navigator.getInstructions(points))
    }
}