package Arrays

import scala.collection.mutable.Map
/**
 * Created by pradeepsanchana on 25/10/18.
 */
object FirstNonrepeatingChar {
  def main(args:Array[String]): Unit ={
    println(findNonRepeatingChar("geeksforgeeks"))
    println(findNonRepeatingChar2("geeksforgeeks"))
  }

  def findNonRepeatingChar(a: String):Char = {
    var count  =  new Array[Int](256)
    for(i<-0 to a.length-1){
      count(a(i)) += 1
    }
    for(i<-0 to a.length-1) {
      if(count(a(i)) == 1 )
        return a(i)
    }
    ' '
  }
  def findNonRepeatingChar2(a: String):Char = {
    var hash:Map[Char ,(Int,Int)]  =  Map()
    for(i<-0 to a.length-1){
      if(!hash.contains(a(i))) {
        hash += (a(i)) -> (1,i)
      } else {
        var (j,k) = hash(a(i))
        hash(a(i)) = ( j + 1 , k)
      }
    }
    var min:Int = a.length
    var c:Char = ' '
    for(a <- hash) {
      var (i,j) = a._2
       if(i == 1 && j < min  ){
         min = j
         c = a._1
       }

    }
    c
  }

}
