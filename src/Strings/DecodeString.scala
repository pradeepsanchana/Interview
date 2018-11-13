package Strings

/**
 * Created by pradeepsanchana on 25/10/18.
 */
object DecodeString {
  def main(args:Array[String]) ={
    println(decodePosition("a2bc3d4", 7))
    println(decodePosition("a2bc3d4", 10))
  }
  def decodePosition(s:String, pos:Int): Any = {
    var de = ""
    var repeatString = ""
    for(i<-0 to s.length-1) {
      if(s(i).isLetter == true) {
        repeatString += s(i)
      } else {
        if(s(i).isDigit == true) {
          for(j<-0 to s(i).asDigit-1) {
            de += repeatString
          }
          repeatString = ""
        }
      }
      if(de.length > pos) {
        return de(pos-1)
      }
    }
    if(de.length < pos)
      -1

  }

}
