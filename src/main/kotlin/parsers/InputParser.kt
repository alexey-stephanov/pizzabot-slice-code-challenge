package parsers

import exceptions.InvalidInputException
import exceptions.InvalidMatrixException
import exceptions.InvalidPointException
import mappers.MatrixMapper
import mappers.PointMapper
import models.PointModel
import utils.isValid

/**
 * Class that parses the input and returns points if validation is successful.
 * Regular expressions are used for validation.
 * The input is invalid if it contains negative numbers. Example: 3x-4(1,1)(1,-3)(2,2).
 * Negative numbers are checks during input validation and aren't skipping further.
 * Spaces are allowed:
 *      between the matrix and the first point: 3x3 (1,3);
 *      between the points: (2,3) (3,3);
 *      between the coordinates after the comma: (2, 4).
 * Input without spaces and with some spaces are also correct variants: 5x5(1,4)(5,5)(3,4); 7x7 (1,1) (2,5)(3, 4).
 */
class InputParser(
    private val matrixMapper: MatrixMapper,
    private val pointMapper: PointMapper
) : Parser {

    @Throws(Exception::class)
    override fun parse(input: String): List<PointModel> {

        if (!validationRegex.matches(input)) {
            throw InvalidInputException(input)
        }

        val matrix = matrixMapper.map(input)

        if (!matrix.isValid) {
            throw InvalidMatrixException(matrix)
        }

        val points = pointMapper.map(input)

        points.forEach { point ->
            if (!point.isValid(matrix)) {
                throw InvalidPointException(point, matrix)
            }
        }

        return points
    }

    private companion object {
        val validationRegex = Regex("""^\d+x\d+( ?\(\d+, ?\d+\))+$""")
    }
}
