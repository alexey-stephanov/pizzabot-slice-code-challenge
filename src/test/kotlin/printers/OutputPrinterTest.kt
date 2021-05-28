package printers

import io.mockk.MockKAnnotations
import models.Instructions
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputPrinterTest {

    lateinit var outStream: ByteArrayOutputStream

    lateinit var out: PrintStream

    lateinit var outputPrinter: OutputPrinter

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        outStream = ByteArrayOutputStream()
        out = PrintStream(outStream)
        System.setOut(out)
        outputPrinter = OutputPrinter()
    }

    @Test
    fun `test printer prints instructions`() {
        val instructions = listOf(
            Instructions.East,
            Instructions.East,
            Instructions.North,
            Instructions.North,
            Instructions.North,
            Instructions.Drop
        )
        outputPrinter.print(instructions)
        assertEquals("EENNND", outStream.toString())
    }
}