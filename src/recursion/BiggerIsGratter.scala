package recursion

/**
 * Created by pradeepsanchana on 09/07/18.
 */
object BiggerIsGratter {
  var next = false

  def main(args: Array[String]) {
    println(biggerIsGreater("dkhc"))
  }
  def biggerIsGreater(a:String):String = {
    var orig =a
    if(a.sorted(Ordering.Char.reverse) == orig) {
      return "no answer"
    } else {
      var b= new Array[Char](a.length)

      return getNextGrater(a)

    }
  }
  def getNextGrater(a:String):String ={
    var c = a.toCharArray
    var i =a.length -1
    var j = a.length -1
    while(a(i) < a(i-1) && i>0){
      i -=1
    }
    while(a(i-1) > a(j) && j>0){
      j -=1
    }
    var tmp = c(i-1)
    c(i-1) = c.charAt((j))
    c(j) = tmp

    return c.mkString.substring(0,i) + c.mkString.substring(i).sorted


  }



}
