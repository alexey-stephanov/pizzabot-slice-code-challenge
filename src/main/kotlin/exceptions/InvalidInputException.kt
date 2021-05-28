package exceptions

class InvalidInputException(input: String): Exception("Invalid input: $input")
