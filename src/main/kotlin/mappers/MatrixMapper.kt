package mappers

import models.MatrixModel

interface MatrixMapper : Mapper<String, MatrixModel>

class MatrixMapperImpl : MatrixMapper {

    override fun map(input: String): MatrixModel {
        val matrix = matrixRegex.find(input) ?: return MatrixModel(-1, -1)
        val (width, height) = matrix.destructured
        return MatrixModel(width.toInt(), height.toInt())
    }

    private companion object {
        val matrixRegex = Regex("""^(\d+)x(\d+)""")
    }
}
