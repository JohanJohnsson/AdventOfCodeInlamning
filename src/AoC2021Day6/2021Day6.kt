package AoC2021Day6

import java.io.File

// https://adventofcode.com/2021/day/6


val data: List<Int> = File("src/AoC2021Day6/day6Input.txt").readText().split(",").map { it.toInt() }

fun firstSolution(initialAges: List<Int>, days: Int): Int {
    var ages = initialAges

    repeat(days) {                             //Kör igenom antal dagar jag skickar in
        val newAges = mutableListOf<Int>()          //Skapar en mutableList för de nya åldrarna

        for (age in ages) {
            if (age == 0) {
                newAges.add(6)                     // Om en fisk med timer 0 hittas sätts den fiskens timer till 6
                newAges.add(8)                     // Lägger till en ny fisk med timer 8
            } else {
                newAges.add(age - 1)               // Om ingen timer är på 0 kör den om och sätter resterande fiskars timer -1
            }
        }

        ages = newAges
    }

    return ages.size
}

//Inspo
// https://www.reddit.com/r/adventofcode/comments/r9z49j/comment/hnfm851/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button
// Testade att använda mig av flatMap som i denna lösningen. Denna är för part 2 men enda skillnaden är egentligen
// att man behöver använda sig av Long istället för Int. 

fun finalSolution(initialAges: List<Int>, days: Int): Int {
    var ages = initialAges

    repeat(days) {                          //Upprepas enligt antal dagar
        ages = ages.flatMap {               //Flatmap retunerar en lista av nya åldrar för varje fisk
            if (it == 0) listOf(6, 8)    //Om 0 hittas i ages uppdateras den fisken till timer 6 och en ny med timer 8 läggs till
            else listOf(it - 1)          //Om Ingen fisk har timer 0 dras 1 av från alla timers och loopen körs igen
        }
    }

    return ages.size //retunerar storleken på listan/antalet fiskar
}


fun partOneFirstSolution() = firstSolution(data, 80)
fun partOneFinalSolution() = finalSolution(data, 80)


fun main() {

    println(partOneFirstSolution())
    println(partOneFinalSolution())

}
