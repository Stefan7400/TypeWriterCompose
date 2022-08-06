package utils

fun matchAtIndex(given: String, toMatch : String): Boolean{
    return toMatch.startsWith(given)
}

fun createTextLines(inputText : String, charLimitPerLine : Int): ArrayList<String>{
    val textLines = arrayListOf<String>()
    val words = inputText.split(" ")
    var charCounter = 0
    var currentString = ""
    for (word in words) {
        if(charCounter + ( word.length + 1) <= charLimitPerLine){
        } else {
            charCounter = 0
            textLines.add(currentString)
        }
        currentString = word
        charCounter += word.length + 1
    }
    return textLines
}