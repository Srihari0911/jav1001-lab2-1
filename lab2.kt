fun main() {
    //Ceaser Cipher function
    userInput()
    
}

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
