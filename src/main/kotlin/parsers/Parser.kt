package parsers

import models.PointModel

interface Parser {
    fun parse(input: String): List<PointModel>
}
