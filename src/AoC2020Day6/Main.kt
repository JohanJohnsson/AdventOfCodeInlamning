package AoC2020Day6

import java.io.File
// https://adventofcode.com/2020/day/6
// Jag ska räkna ut antalet frågor som det har svarats "Ja" på. Endast ett ja/fråga/grupp.
// Svaret blir summan av alla ja-svar/grupp.

val data: String = File("src/AoC2020Day6/day6Input.txt").readText().trimIndent()


fun firstSolution(): Int {
    val groups = data.split("\n\n").map { it.trim() }
    var sum = 0
    for (group in groups) {
        val yes = group.replace("\n", "").toSet()
        sum += yes.size
    }
    return sum
}

// https://www.reddit.com/r/adventofcode/comments/k7ndux/comment/gesph2i/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button


//sumBy räknar ut antalet unika bokstäver/grupp. filter { it.isLetter() } filtrerar bort tecken som ej är bokstäver.
//Jag konverterar till set (toSet()) för att komma åt funktionen sumBy och eliminerar duplicerade bokstäver .size för antalet element i Set.
fun finalSolution(): Int {
    return data.split("\n\n").sumOf { group -> group.filter { it.isLetter() }.toSet().size }
}


fun main() {

    println(firstSolution()) // First
    println(finalSolution()) //Final
    
    

}
