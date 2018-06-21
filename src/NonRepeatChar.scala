import scala.collection.mutable._
/**
 * Created by pradeepsanchana on 12/04/18.
 */
object NonRepeatChar {
  def nonRepeatChar(s:String):Char ={
    var m = Map[Char,Int]()
    //var c:Char = null
    for(i <-0 to s.length-1){
      if(!m.isEmpty && m.contains(s.charAt(i))){
        var c = m.get(s.charAt(i)).get

        m(s.charAt(i)) = c+1
      } else {

        m(s.charAt(i)) = 1
      }

    }
    for(i <-0 to s.length-1){
      if(m(s.charAt(i)) ==1 )
        return s.charAt(i)
    }

    ' '
  }
  def main(args: Array[String]) {
    var s = "aabcbb"
    println("non repeating char:"+nonRepeatChar(s))
  }

}
