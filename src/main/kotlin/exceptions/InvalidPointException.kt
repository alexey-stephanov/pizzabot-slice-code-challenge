package exceptions

import models.MatrixModel
import models.PointModel

class InvalidPointException(point: PointModel, matrix: MatrixModel) :
    Exception("Point x:${point.coordinateX}, y: ${point.coordinateY} is out of matrix $matrix")
