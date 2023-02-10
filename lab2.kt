

/*
This assignment was done in group with Sri Hari Sreenivasan(A00272180)
 and myself Jobin Koodathinkal Jose(A00250653)
My contribution in this assignment was coding the ceaser cipher, userInput(), arrayContains()
And also I debugged and solved errors in the functions and tester functions.
We both worked together in developing logic for each function and Coded two functions each
 */

fun main() {
    //Ceaser Cipher function
    userInput()
    
    //Array average function
    println("-------------------------------")
    val numbers = intArrayOf(10,10,10)
    println(arrayAvg(numbers))
    
    //Array contains function
    println("-------------------------------")
    val array = intArrayOf(1,3,4,60,34,5,0)
    print("Enter value to check in the array : ")// taking user input for the value to be searched
    val searchValue = readln().toInt()

    val result = arrayContains(array,searchValue)
    if(result == true){
        println("$searchValue is an element in the array.")
    }
    else{
        println("$searchValue does not exist in the array.")
    }
    
    //Reverse an array function starts here
    println("-------------------------------")
    val arrayToReverse = intArrayOf(1,2,3,4,5,6,7,8,9)
    print("Array before reversing : [")
    for (i in arrayToReverse.indices){
        print(arrayToReverse[i])
        print("  ")
    }
    print("]")
    println()
    val reversedArray = reverseArray(arrayToReverse)
    print("Array after reversing : [")
    for (i in reversedArray.indices){
        print(reversedArray[i])
        print("  ")
    }
    print("]")
    println()
    
    // CALLING THE TESTER FUNCTIONS
    println("-------------------------------")
    println("Ceaser cipher tests")
    cipherTester()
    println("-------------------------------")
    println("Array average tests")
    arrayAvgTester()
    println("-------------------------------")
    println("Array contains tests")
    arrayContainsTester()
    println("-------------------------------")
    println("Reverse array tests")
    reverseArrayTester()
    
}
//encrypt string function
fun encrypt (string: String, shift: Int) : String {
    //variable to store the result
    var result = ""
    
  //converting the value of A to in for reference
    val firstCharCode = 'A'.toInt()
    val offset = ('z' - 'A') + 1 // offset is the number of alphabets (including uppercase and lowecase)

    for (i in 0 until string.length) {

        val oldCharCode = string[i].toInt()//converts each characters into its ASCII value
        val oldIndxInAlphabet = oldCharCode - firstCharCode //finds the original index of the character in the alphabet by substracting firstCharCode
      
      // adds the shift value to the original index of the alphabet. the modulus operation is performed 
      //to make sure the that the new index stays within the bounds of the alphabets.
        val newIndxInAlphabet = (oldIndxInAlphabet + shift) % offset
       
      //adds new index and firstCharacterCode and converts it to new character
        val newChar = (firstCharCode + newIndxInAlphabet).toChar()
        result += newChar

    }
    return result
}
// function to get string and shift value from the user
fun userInput() {

    var repeat = true
    while (repeat){
        print("Enter the string to be encrypted: ")
        val string = readln()
        print("Enter the shift position value (numeric value) : ")
        val shift = readln().toInt()
        val cipher = encrypt(string,shift )
        println("Encrypted text : $cipher")

        print("Enter 'q' to exit, or any other key to continue encrypting: ")
        val exit = readln()
        if(exit == "q") {
            repeat = false
        }
    }
}
// Array average function to get the average of an array
fun arrayAvg(array: IntArray): Int {
    var sum = 0
    for (i in array) {
        sum += i
    }
    return sum / array.size
}
// arrayContains() to check whether an element existis in an array
fun arrayContains(array: IntArray, searchValue: Int): Boolean {

    for(i in array.indices){
        if (array[i] == searchValue){
            return true
        }
    }
    return false
}
// funcrion to reverse an array
fun reverseArray(array: IntArray): IntArray {
    val reversedArray = IntArray(array.size) { 0 }
    for (i in array.size-1 downTo 0) {
        reversedArray[array.size - i - 1] = array[i]
    }
    return reversedArray
}

// FROM HERE START THE TESTER FUNCTIONS!
fun cipherTester(){
    // for the cipher tester we put the shift value to be 3
    val t1 = "Hello"
    val r1 = "Khoor"
    val t2 = "hai"
    val r2 = "kdl"
    val t3 = "Kotlin"
    val r3 = "Nrwolq"

    val tests = listOf<String>(t1,t2,t3)
    val results = listOf<String>(r1,r2,r3)

    for(i in tests.indices){
        val cipher = encrypt(tests[i], 3)
        if(cipher != results[i]){
            println("Test ${tests[i]} Failed")
        }
        else{
            println("Test ${tests[i]} Passed")
        }
    }
}
//Tester function for the arrayAvg()
fun arrayAvgTester(){
    val t1 = intArrayOf(1,2,3,4,5,6)
    val r1 = 3
    val t2 = intArrayOf(15,30,45,10)
    val r2 = 25
    val t3 = intArrayOf(0,24,100,-50, 200,26)
    val r3 = 50

    val tests = listOf<IntArray>(t1,t2,t3)
    val results = listOf<Int>(r1,r2,r3)

    for( i in tests.indices){
        var j = i
        val arryAvg = arrayAvg(tests[i])
        if(arryAvg != results[i]){
            println("Test${j+1} Failed")
        }
        else{
            println("Test${j+1} Passed")
        }
    }
}
// Function to test the arrayContains()
fun arrayContainsTester(){
    val t1 = intArrayOf(1,2,3,4,5,6)
    val v1 = 10
    val r1 = false
    val t2 = intArrayOf(15,30,45,10)
    val v2 = 45
    val r2 = true
    val t3 = intArrayOf(0,24,100,-50, 200,26)
    val v3 = 50
    val r3 = false

    val tests = listOf<IntArray>(t1,t2,t3)
    val values = listOf<Int>(v1,v2,v3)
    val results = listOf<Boolean>(r1,r2,r3)

    for( i in tests.indices){
        var j = i
        val arryContains = arrayContains(tests[i],values[i])
        if(arryContains != results[i]){
            println("Test${j+1} Failed")
        }
        else{
            println("Test${j+1} Passed")
        }
    }
}
// Function to test the reverseArray()
fun reverseArrayTester(){
    val t1 = intArrayOf(1,2,3,4,5,6)
    val r1 = intArrayOf(6,5,4,3,2,1)
    val t2 = intArrayOf(15,30,45,10)
    val r2 = intArrayOf(10,45,30,15)
    val t3 = intArrayOf(0,24,100,-50, 200,26)
    val r3 = intArrayOf(26,200,-50,100,24,0)

    val tests = listOf<IntArray>(t1,t2,t3)
    val results = listOf<IntArray>(r1,r2,r3)

    for( i in tests.indices){
        var j = i
        val arryReverse = reverseArray(tests[i])
        if(arryReverse != results[i]){
            println("Test${j+1} Failed")
        }
        else{
            println("Test${j+1} Passed")
        }
    }
}
