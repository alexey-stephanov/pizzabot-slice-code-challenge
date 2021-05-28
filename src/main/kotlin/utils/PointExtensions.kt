package utils

import models.MatrixModel
import models.PointModel
import kotlin.math.abs

fun PointModel.isValid(matrix: MatrixModel): Boolean {
    if (coordinateX <= matrix.width && coordinateX >= 0 && coordinateY <= matrix.height && coordinateY >= 0) {
        return true
    }

    return false
}

fun PointModel.absoluteDistance(targetPoint: PointModel): Int =
    abs(this.coordinateX - targetPoint.coordinateX) + abs(this.coordinateY - targetPoint.coordinateY)
