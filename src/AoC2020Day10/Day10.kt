package AoC2020Day10

import java.io.File

// https://adventofcode.com/2020/day/10

// Alla adaptrar i väskan måste användas, så jag får inte hoppa över någon. Jag börjar på 0 och 
// slutar på högsta adaptern i väskan + 3. 

val data = File("src/AoC2020Day10/day10Input.txt").readLines().map { it.toInt() }.sorted() //first (Sorterad)
val adapters: List<Int> = data.plus(0).plus(data.maxOrNull()!! + 3).sorted() // second (Sorterad + 0 och 195)


fun firstSolution() {
    val mapOfDifferences = mutableMapOf<Int, Int>()
    var currentJolt = 0

    for (adapter in data) {
        val difference = (adapter - currentJolt)
        mapOfDifferences[difference] = mapOfDifferences.getOrDefault(difference, 0) + 1
        currentJolt = adapter
    }

    val oneJoltDifferences = mapOfDifferences.getOrDefault(1, 0)
    val threeJoltDifferences = mapOfDifferences.getOrDefault(3, 0) + 1 // Lägger till den sista adaptern
    val result = oneJoltDifferences * threeJoltDifferences
    println("$result")
}


// https://todd.ginsberg.com/post/advent-of-code/2020/day10/
// Ville få ner koden till färre rader och försöka få den mer funktionell.


fun finalSolution(): Int {
    val differences = adapters.sorted().zipWithNext() //Skapar en lista med par som representerar 2 angränsande adaprar.
        .map { it.second - it.first }                 
        .groupingBy { it }                            //Grupperar efter värderna.
        .eachCount()                                   
    return differences[1]!! * differences[3]!!        //Jag retunerar antal 1-jolts skillnader * antal 3-jolts skillnader
}


fun main() {
    firstSolution()
    println(finalSolution())
}

 


 
