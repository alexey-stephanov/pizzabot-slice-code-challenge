# Pizzabot

Console app that сalculates the route for the delivery bot.

## Usage

There are several ways to use pizzabot

* In IntelliJ IDEA
1. Open the project in IntelliJ IDEA, open file Main.kt and run the main function. After that, write your input without quotes.

* In terminal
Go to the project root folder

1. Write ./pizzabot.sh and your input in quotes
```
./pizzabot.sh "(your_input)"
```
Example:
```
./pizzabot.sh "5x5 (1, 2) (2, 3)"
```

2. Write ./pizzabot.sh and run the program. After that, write your input without quotes
```
./pizzabot.sh
(your_input)
```
Example:
```
./pizzabot.sh
5x5 (1, 2) (2, 3)
```

## How pizzabot works

After starting the program, the input goes to the parser and divides into the size of the matrix and points. Matrix and points goes through validation and if successful, they go to the navigator, which builds the deliver path. If there are mistakes in the input, the program throws an exception with an error message, and then the program ends. Delivery path builds according to the following principle: first, the search is carried out for the closest point to the start point (0,0) and after finding one, the navigator builds a path to it. Then path builds from the current point to the closest. The process is repeated until all points are passed. The path looks like a list of instructions (East, East, North, Drop, etc.). When the path is created, the list of instructions goes to the printer and it prints the output to the console. After that the program ends successfully.
