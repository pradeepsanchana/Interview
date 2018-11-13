package Strings
/**
 * Created by pradeepsanchana on 25/10/18.
 */
import scala.collection.mutable.Map
object Mmt1 {
  def main(args:Array[String]) = {
    println(findPalindrome("babammm",2))
    println(findPalindrome("babammm",5))
  }
  def findPalindrome(s:String, c:Int): String = {
    for(i<-0 to s.length-1-c) {
      if(palindrom(s.substring(i,c +i))){
        return s.substring(i,c+i)
      }
    }
    ""
  }
  def palindrom(s:String):Boolean ={
    var hash:Map[Char,Int] = Map()
    for(i<-s) {
      if(!hash.contains(i)){
        hash += i -> 1
      } else {
        var x = hash(i)
        hash(i) = (x + 1)
      }
    }
    var odd = 0
    var even = 0
    for(i<-hash){
      if(i._2 % 2 != 0 ){
        odd += 1
      }
    }
    if (odd == 1 || odd == 0){
      true
    } else{
      false
    }
  }
}
