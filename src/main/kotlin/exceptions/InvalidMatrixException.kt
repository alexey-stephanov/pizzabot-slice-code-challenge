package exceptions

import models.MatrixModel

class InvalidMatrixException(matrix: MatrixModel) :
    Exception("Invalid matrix size. Width: ${matrix.width}, height: ${matrix.height}")
