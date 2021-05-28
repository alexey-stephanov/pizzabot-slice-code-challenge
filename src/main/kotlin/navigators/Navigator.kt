package navigators

import models.Instructions
import models.PointModel

interface Navigator {
    fun getInstructions(points: List<PointModel>): List<Instructions>
}
