package di

import mappers.MatrixMapper
import mappers.MatrixMapperImpl
import mappers.PointMapper
import mappers.PointMapperImpl
import models.Instructions
import navigators.Navigator
import navigators.NavigatorImpl
import org.koin.dsl.module
import parsers.InputParser
import parsers.Parser
import printers.OutputPrinter
import printers.Printer

val pizzabotAppModule = module {
    single<Parser> { InputParser(get(), get()) }
    single<MatrixMapper> { MatrixMapperImpl() }
    single<PointMapper> { PointMapperImpl() }
    single<Navigator> { NavigatorImpl() }
    single<Printer<List<Instructions>>> { OutputPrinter() }
}
