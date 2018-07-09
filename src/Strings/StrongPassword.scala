package Strings

/**
 * Created by pradeepsanchana on 07/07/18.
 */
object StrongPassword {
  def main(args: Array[String]) {
    //println(minCount(11,"#HackerRank"))
    println(minCount(4,"4700"))
  }
  def minCount(n:Int,s:String):Int ={
    var lower = false
    var upper = false
    var special = false
    var num = false
    var count = 0
    for(i<- s){
      i match {
        case 'a'|'b'|'c'|'d'|'e'|'f'|'g'|'h'|'i'|'j'|'k'|'l'|'m'|'n'|'o'|'p'|'q'|'r'|'s'|'t'|'u'|'v'|'w'|'x'|'y'|'z' =>
          lower = true
        case 'A'|'B'|'C'|'D'|'E'|'F'|'G'|'H'|'I'|'J'|'K'|'L'|'M'|'N'|'O'|'P'|'Q'|'R'|'S'|'T'|'U'|'V'|'W'|'X'|'Y'|'Z' =>
          upper = true
        case '1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9'|'0'=>
          num = true
        case '!'|'@'|'#'|'$'|'%'|'^'|'&'|'*'|'('|')'|'-'|'+' =>
          special = true
      }
    }
    if(lower){
      count +=1
    }
    if(upper){
      count +=1
    }
    if(special){
      count +=1
    }
    if(num){
      count +=1
    }
    if(count == 4 ){
      if( s.length >= 6)
        return 0
      else
        return 6-s.length
    } else {
      if( s.length >= 6)
        return 4-count
      else
        if(4-count+s.length <= 6)
         return 6-s.length
        else
         return 4-count
    }
  }
}
