object LearningScala4 {
  // Data structures
  
  // Tuples (Also really common with Spark!!)
  // Immutable lists
  // Often thought of as database fields, or columns.
  // Useful for passing around entire rows of data.
//lesson
  val captainStuff = ("Picard", "Enterprise-D", "NCC-1701-D")
                                                  //> captainStuff  : (String, String, String) = (Picard,Enterprise-D,NCC-1701-D)
                                                  //| 
  println(captainStuff)                           //> (Picard,Enterprise-D,NCC-1701-D)
  
  // You refer to individual fields with their ONE-BASED index:
  println(captainStuff._1)                        //> Picard
  println(captainStuff._2)                        //> Enterprise-D
  println(captainStuff._3)                        //> NCC-1701-D
 
 val picardShipTrial = captainStuff._1 -> captainStuff._2
                                                  //> picardShipTrial  : (String, String) = (Picard,Enterprise-D)
 println(picardShipTrial._1)                      //> Picard
 
 // You can create a key/value pair with ->
 val picardsShip = "Picard" -> "Enterprise-D"     //> picardsShip  : (String, String) = (Picard,Enterprise-D)
 println(picardsShip._2)                          //> Enterprise-D
 
 // You can mix different types in a tuple
 val aBunchOfStuff = ("Kirk", 1964, true)         //> aBunchOfStuff  : (String, Int, Boolean) = (Kirk,1964,true)
 
   
  //practice below:
  val bellSrik = ("Srikanth", "Bellary", "4403408383")
                                                  //> bellSrik  : (String, String, String) = (Srikanth,Bellary,4403408383)
  val rajaniKSam = ("Rajani", "Samudrala", "5155285797")
                                                  //> rajaniKSam  : (String, String, String) = (Rajani,Samudrala,5155285797)
  println(bellSrik._1 + " loves " + rajaniKSam._1)//> Srikanth loves Rajani
  println(bellSrik._1+ "'s phone number is " + bellSrik._3)
                                                  //> Srikanth's phone number is 4403408383
  println(rajaniKSam._1+ "'s phone number is " + rajaniKSam._3)
                                                  //> Rajani's phone number is 5155285797
    val contactNumbers =
    List(
    ("Srikanth", "Bellary", "Mobile", "4403408383"),
    ("Rajani", "Samudrala", "Mobile", "5155285797"),
    ("Srikanth", "Bellary", "Work", "3124445256")
    )                                             //> contactNumbers  : List[(String, String, String, String)] = List((Srikanth,B
                                                  //| ellary,Mobile,4403408383), (Rajani,Samudrala,Mobile,5155285797), (Srikanth,
                                                  //| Bellary,Work,3124445256))
    //val bellsrikWork = contactNumbers.filter((c: Unit) => c == ("Srikanth", "Bellary", "Work", "3124445256"))
    println(contactNumbers)                       //> List((Srikanth,Bellary,Mobile,4403408383), (Rajani,Samudrala,Mobile,5155285
                                                  //| 797), (Srikanth,Bellary,Work,3124445256))
    println(contactNumbers(0))                    //> (Srikanth,Bellary,Mobile,4403408383)
    val srikMobile = contactNumbers(0)            //> srikMobile  : (String, String, String, String) = (Srikanth,Bellary,Mobile,4
                                                  //| 403408383)
    val rajiMobile = contactNumbers(1)            //> rajiMobile  : (String, String, String, String) = (Rajani,Samudrala,Mobile,5
                                                  //| 155285797)
    val srikWork = contactNumbers(2)              //> srikWork  : (String, String, String, String) = (Srikanth,Bellary,Work,31244
                                                  //| 45256)
for (column <- contactNumbers) {
		println(column)                   //> (Srikanth,Bellary,Mobile,4403408383)
                                                  //| (Rajani,Samudrala,Mobile,5155285797)
                                                  //| (Srikanth,Bellary,Work,3124445256)
		}

 // Lists
 // Like a tuple, but it's an actual Collection object that has more functionality.
 // Also, it cannot hold items of different types.
 // It's a singly-linked list under the hood.
 
 val shipList = List("Enterprise", "Defiant", "Voyager", "Deep Space Nine")
                                                  //> shipList  : List[String] = List(Enterprise, Defiant, Voyager, Deep Space Ni
                                                  //| ne)
 // Access individual members using () with ZERO-BASED index (confused yet?)
 println(shipList(1))                             //> Defiant
 
 // head and tail give you the first item, and the remaining ones.
 println(shipList.head)                           //> Enterprise
 println(shipList.tail)                           //> List(Defiant, Voyager, Deep Space Nine)
 
 
 // Iterating though a list
 for (ship <- shipList) {println(ship)}           //> Enterprise
                                                  //| Defiant
                                                  //| Voyager
                                                  //| Deep Space Nine
 
 // Let's apply a function literal to a list! map() can be used to apply any function to every item in a collection.
val backwardShips = shipList.map( (ship: String) => {ship.reverse})
                                                  //> backwardShips  : List[String] = List(esirpretnE, tnaifeD, regayoV, eniN eca
                                                  //| pS peeD)
 for (ship <- backwardShips) {println(ship.toUpperCase)}
                                                  //> ESIRPRETNE
                                                  //| TNAIFED
                                                  //| REGAYOV
                                                  //| ENIN ECAPS PEED
                                                  
// reduce() can be used to combine together all the items in a collection using some function.
val numberList = List(1, 2, 3, 4, 5)              //> numberList  : List[Int] = List(1, 2, 3, 4, 5)
val sum = numberList.reduce( (x: Int, y: Int) => x + y)
                                                  //> sum  : Int = 15
println(sum)                                      //> 15

// filter() can remove stuff you don't want. Here we'll introduce wildcard syntax while we're at it.
val iHateFives = numberList.filter( ((x: Int) => x != 5))
                                                  //> iHateFives  : List[Int] = List(1, 2, 3, 4)
val iHateThrees = numberList.filter(_ == 3)       //> iHateThrees  : List[Int] = List(3)

val nameList = List("Srikanth", "Ujwal", "Nikhil", "Suresh", "Srikanth", "Shiva", "Rohit")
                                                  //> nameList  : List[String] = List(Srikanth, Ujwal, Nikhil, Suresh, Srikanth, 
                                                  //| Shiva, Rohit)
val nameBackwards = nameList.map( (name: String) => {name.reverse})
                                                  //> nameBackwards  : List[String] = List(htnakirS, lawjU, lihkiN, hseruS, htnak
                                                  //| irS, avihS, tihoR)
for (friendsListBackwards <- nameBackwards) { println(friendsListBackwards)}
                                                  //> htnakirS
                                                  //| lawjU
                                                  //| lihkiN
                                                  //| hseruS
                                                  //| htnakirS
                                                  //| avihS
                                                  //| tihoR

val findNameWith_S = println(nameList.filter(_ == "Srikanth"))
                                                  //> List(Srikanth, Srikanth)
                                                  //| findNameWith_S  : Unit = ()
for (friendsList <- nameList) { println(friendsList)}
                                                  //> Srikanth
                                                  //| Ujwal
                                                  //| Nikhil
                                                  //| Suresh
                                                  //| Srikanth
                                                  //| Shiva
                                                  //| Rohit

// Note that Spark has its own map, reduce, and filter functions that can distribute these operations. But they work the same way!
// Also, you understand MapReduce now :)

// Concatenating lists
val moreNumbers = List(6, 7, 8)                   //> moreNumbers  : List[Int] = List(6, 7, 8)
val lotsOfNumbers = numberList ++ moreNumbers     //> lotsOfNumbers  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)

// More list fun
val reversed = numberList.reverse                 //> reversed  : List[Int] = List(5, 4, 3, 2, 1)
val sorted = reversed.sorted                      //> sorted  : List[Int] = List(1, 2, 3, 4, 5)
val lotsOfDuplicates = numberList ++ numberList   //> lotsOfDuplicates  : List[Int] = List(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
val distinctValues = lotsOfDuplicates.distinct    //> distinctValues  : List[Int] = List(1, 2, 3, 4, 5)
val maxValue = numberList.max                     //> maxValue  : Int = 5
val total = numberList.sum                        //> total  : Int = 15
val hasThree = iHateThrees.contains(3)            //> hasThree  : Boolean = true

// Maps
// Useful for key/value lookups on distinct keys
// Like dictionaries in other languages

val shipMap = Map("Kirk" -> "Enterprise", "Picard" -> "Enterprise-D", "Sisko" -> "Deep Space Nine", "Janeway" -> "Voyager")
                                                  //> shipMap  : scala.collection.immutable.Map[String,String] = Map(Kirk -> Ente
                                                  //| rprise, Picard -> Enterprise-D, Sisko -> Deep Space Nine, Janeway -> Voyage
                                                  //| r)
println(shipMap("Janeway"))                       //> Voyager

// Dealing with missing keys
println(shipMap.contains("Archer"))               //> false

val archersShip = util.Try(shipMap("Archer")) getOrElse "Unknown"
                                                  //> archersShip  : String = Unknown
println(archersShip)                              //> Unknown

// EXERCISE
// Create a list of the numbers 1-20; your job is to print out numbers that are evenly divisible by three. (Scala's
// modula operator, like other languages, is %, which gives you the remainder after division. For example, 9 % 3 = 0
// because 9 is evenly divisible by 3.) Do this first by iterating through all the items in the list and testing each
// one as you go. Then, do it again by using a filter function on the list instead.

//My First Scala Exercise:

val testList = List (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
                                                  //> testList  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                                                  //|  15, 16, 17, 18, 19, 20)
def divThree(x: Int): Int  = {x % 3}              //> divThree: (x: Int)Int
def divThree1(x: Int, f: Int => Int) : Int = {f(x)}
                                                  //> divThree1: (x: Int, f: Int => Int)Int
for (x: Int <- testList) {
   	val y = divThree1(x, divThree)
  		if (y == 0) {
  		println(x)
  		}
		}                                 //> 3
                                                  //| 6
                                                  //| 9
                                                  //| 12
                                                  //| 15
                                                  //| 18
//Same Program above with filter function:
val newList = testList.filter(((x: Int) => (x % 3) == 0))
                                                  //> newList  : List[Int] = List(3, 6, 9, 12, 15, 18)
for (x: Int <- newList) { println(x)}             //> 3
                                                  //| 6
                                                  //| 9
                                                  //| 12
                                                  //| 15
                                                  //| 18
// That's enough for now!
// There is MUCH more to learn about Scala. We didn't cover many other collection types, including mutable collections.
// And we didn't even touch on object-oriented Scala. The book "Learning Scala" from O'Reilly is great if you want to
// go into more depth - but you've got enough to get through this course for now.

}