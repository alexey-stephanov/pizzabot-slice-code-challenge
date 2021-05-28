package printers

interface Printer<I> {
    fun print(data: I)
}
