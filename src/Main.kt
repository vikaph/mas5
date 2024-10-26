fun main() {
    println("Введите слова через пробел:")
    val words = readLine()?.split(" ") ?: emptyList()

    val groupedWords = groupAnagrams(words)

    for (group in groupedWords) {
        println(group.joinToString(", "))
    }
}
// Функция для группировки анаграмм
fun groupAnagrams(words: List<String>): List<List<String>> {
    val anagramMap = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        // Сортируем буквы в слове, чтобы получить ключ для анаграммы
        val sortedWord = word.toCharArray().sorted().joinToString("")

        // Добавляем слово в соответствующую группу
        anagramMap.computeIfAbsent(sortedWord) { mutableListOf() }.add(word)
    }
    return anagramMap.values.toList()
}