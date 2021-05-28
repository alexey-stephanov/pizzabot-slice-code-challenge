import di.pizzabotAppModule
import org.koin.core.context.startKoin

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            startKoin {
                modules(pizzabotAppModule)
            }

            val input = if (args.isEmpty()) {
                readLine()!!
            } else {
                args.joinToString(separator = " ")
            }
            PizzabotApp(input)
        }
    }
}
