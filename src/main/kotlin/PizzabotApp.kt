import models.Instructions
import navigators.Navigator
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import parsers.Parser
import printers.Printer

class PizzabotApp(input: String) : KoinComponent {
    private val parser: Parser by inject()
    private val navigator: Navigator by inject()
    private val printer: Printer<List<Instructions>> by inject()

    init {
        try {
            val map = parser.parse(input)
            val instructions = navigator.getInstructions(map)
            printer.print(instructions)
        } catch (e: Exception) {
            println(e.message)
        }
    }
}
