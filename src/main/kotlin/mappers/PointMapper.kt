package mappers

import models.PointModel

interface PointMapper : Mapper<String, List<PointModel>>

class PointMapperImpl : PointMapper {

    override fun map(input: String): List<PointModel> {
        return pointRegex.findAll(input)
            .map { point ->
                val (x, y) = point.destructured
                PointModel(x.toInt(), y.toInt())
            }.toList()
    }

    private companion object {
        val pointRegex = Regex("""\((\d+), ?(\d+)\)""")
    }
}
