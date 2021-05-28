package navigators

import models.Instructions
import models.PointModel
import utils.absoluteDistance
import kotlin.math.abs

/**
 * Class that contains logic for building the optimal delivery path.
 * Navigator receives points and builds the path according to the following principle.
 * It finds the closest point to the start point (0, 0) by calculating the distance between them.
 * Then the navigator writes the path from the start point to the closest point and makes the closest point the current point.
 * The navigator's work continues until all points are finished and all paths are recorded.
 * As a result, the navigator returns instructions describing the entire path.
 */
class NavigatorImpl : Navigator {

    override fun getInstructions(points: List<PointModel>): List<Instructions> {

        //Map is used in case we have 2+ similar points on the map.
        val groupedPoints = points.groupBy { it }
            .mapValues { it.value.size }.toMutableMap()

        var currentPoint = startPoint
        val instructions = mutableListOf<Instructions>()
        while (groupedPoints.keys.isNotEmpty()) {
            val closestPoint = findClosestPoint(currentPoint, groupedPoints.keys)
            instructions.addAll(findPath(currentPoint, closestPoint))
            val droppingTimes = groupedPoints[closestPoint] ?: 0
            repeat(droppingTimes) {
                instructions.add(Instructions.Drop)
            }
            groupedPoints.remove(closestPoint)
            currentPoint = closestPoint
        }
        return instructions
    }

    private fun findClosestPoint(currentPoint: PointModel, points: Set<PointModel>): PointModel {
        val pointsList = points.toList()

        var closestPoint: PointModel = pointsList[0]

        for (i in 1..pointsList.lastIndex) {
            if (currentPoint.absoluteDistance(closestPoint) > currentPoint.absoluteDistance(pointsList[i])) {
                closestPoint = pointsList[i]
            }
        }
        return closestPoint
    }

    private fun findPath(currentPoint: PointModel, targetPoint: PointModel): List<Instructions> {
        val xPath = targetPoint.coordinateX - currentPoint.coordinateX
        val yPath = targetPoint.coordinateY - currentPoint.coordinateY
        val instructions = mutableListOf<Instructions>()
        if (xPath > 0) {
            repeat(xPath) {
                instructions.add(Instructions.East)
            }
        } else if (xPath < 0) {
            repeat(abs(xPath)) {
                instructions.add(Instructions.West)
            }
        }

        if (yPath > 0) {
            repeat(yPath) {
                instructions.add(Instructions.North)
            }
        } else if (yPath < 0) {
            repeat(abs(yPath)) {
                instructions.add(Instructions.South)
            }
        }
        return instructions
    }

    private companion object {
        val startPoint = PointModel(0, 0)
    }
}
