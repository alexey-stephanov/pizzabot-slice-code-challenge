package printers

import models.Instructions

/**
 * Class that prints the output according to instructions.
 */
class OutputPrinter : Printer<List<Instructions>> {
    override fun print(data: List<Instructions>) {
        data.forEach { instruction ->
            print(instruction.command)
        }
    }
}
