package utils

import models.MatrixModel

val MatrixModel.isValid
    get() = (width > 0 && height > 0)
