# Advent of Code 2023 - Day 2 Solution

## Overview

This repository contains a Java solution for Day 2 (part 1) of the Advent of Code 2023 challenge.

**Problem Statement:** [Day 2](https://adventofcode.com/2023/day/2) (part 1)

The program reads a file named `input.txt` containing game data, evaluates whether the games are valid based on specific color draw limits, and calculates the sum of the game numbers for all valid games.

## Problem Details

The task involves reading lines from an input file and checking the validity of games based on the number of colored balls drawn:

- Each line in the input file represents a game in the format: `Game X: [hand1]; [hand2]; ...`.
- Each hand contains a list of draws, such as `3 blue, 4 red`, where the first part indicates the number of balls drawn and the second part indicates the color.
- Valid draws must not exceed the following limits:
  - Red: Maximum of 12
  - Green: Maximum of 13
  - Blue: Maximum of 14
- A game is considered valid if all hands within the game have valid draws.

### Example

Given an input file `input.txt` with the following content:

```
Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
```

**Analysis:**
- Game 1 is valid (all draws within the limits).
- Game 2 is valid (all draws within the limits).
- Game 3 is invalid (contains `20 red` which exceeds the allowed limit).
- Game 4 is invalid (contains `15 blue` and `14 red`, both exceeding the limits).
- Game 5 is valid (all draws within the limits).

**Total Sum of Valid Games**: 1 + 2 + 5 = 8

## Installation and Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/prithvirajdeshmane/AdventOfCode_2023_Day2_1.git
   ```
2. Ensure Java (Java 8 or higher) is installed on your system.
3. Place your input file named `input.txt` in the root directory.

## Usage

To compile and run the program:

```bash
javac App.java
java App
```

## Input File

The program reads from an input file named `input.txt`, which should be located in the same directory as `App.java`. Ensure the file contains the game data as per the problem requirements.

### Sample Input Format
```
Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
```

## Explanation of the Code

- The `App` class contains the logic to read and parse the input file.
- The `main` method reads each line, extracts the game number, and checks the validity of each game using helper methods.
- The `isGameValid` method evaluates if all hands within a game are valid.
- The `isHandValid` method checks if each hand has valid draws.
- The `isDrawValid` method ensures that the count of balls drawn does not exceed the set limits for each color.

## Error Handling

If the input file is not found, the program will display an error message:

```
File not found: input.txt (No such file or directory)
```

## Author

**Prithviraj Deshmane**

This project is part of the Advent of Code 2023 series. For more details, visit [Advent of Code](https://adventofcode.com).

## License

This project is licensed under the GNU General Public License v3.0 - see the LICENSE file for details.

