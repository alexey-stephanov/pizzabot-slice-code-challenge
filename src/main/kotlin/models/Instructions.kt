package models

enum class Instructions(val command: String) {
    North("N"),
    South("S"),
    East("E"),
    West("W"),
    Drop("D")
}
