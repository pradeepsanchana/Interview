package Strings

import scala.collection.immutable.HashMap

/**
 * Created by pradeepsanchana on 07/07/18.
 */
object MaxPalindrome {
  var str:String = ""
  var factorial = new Array[BigInt](50001)
  // Complete the initialize function below.
  def initialize(s: String) {
    // This function is called once before all queries.
    str =s
    fact(s.length/2+1)
  }

  // Complete the answerQuery function below.
  def answerQuery(l: Int, r: Int): BigInt = {
    if(l>r)
      return 0
    var subStr = str.substring(l-1,r)
    var count:BigInt = 0
    var hash = HashMap[Char,Int]()
    var c:Int =0
    for(i<- subStr){
      if(hash.contains(i)) {
        c = hash(i)
        hash += ((i,c+1))
      } else {
        hash +=  ((i,1))
      }
    }
    var evens:Int = 0
    var odds:Int = 0
    var div:BigInt = 1
    for (i<- hash.values){
      if(i %2 == 0 ){
        evens += i/2
        div *= fact(i/2)
      } else {
//        if(i/2 ==1)
          evens += i/2
        div *= fact(i/2)
        odds += 1
      }
    }
    if(odds == 0)
      count = fact(evens)
    else
      count = fact(evens) * odds
    count  = count / div
    count % (Math.pow(10,9)+7).toLong
    // Return the answer for this query modulo 1000000007.

  }
  def fact(n:Int):BigInt = {
    if(factorial(n) != null   )
      return factorial(n)
    factorial(0)=1
   for(i<-1 to n.toInt)
     factorial(i) = factorial(i-1) * i
    factorial(n.toInt)
  }
  def main(args: Array[String]) {
    //initialize("amimaay")
    //println(answerQuery(1,7))
    //initialize("oooooqooooqoqoooooooqoooqoooooooqoqoqoooqoqo")
    //println(answerQuery(17,22))
    //println(answerQuery(2,3))
    val stdin = scala.io.StdIn

    val s = stdin.readLine

    initialize(s)
    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val lr = stdin.readLine.split(" ")

      val l = lr(0).trim.toInt

      val r = lr(1).trim.toInt

      val result = answerQuery(l, r)

      println(result)
    }
  }

}
