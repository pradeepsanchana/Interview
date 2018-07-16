import java.io._

object Solution2 {


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

    while(c(i) < c(i-1) && i>0){
      i -=1
    }
    var x = c(i-1)
    var min = i
    for(j<- i+1 to  a.length-1){
      if (c(j) >= x && c(j) <= c(min))
      {
        min = j;
      }
    }
    var tmp = c(i-1)
    c(i-1) = c(min)
    c(min) = tmp

    return c.mkString.substring(0,i) + c.mkString.substring(i).sorted


  }
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter("./abc.txt")

    val T = stdin.readLine.trim.toInt

    for (r <- 1 to T) {
      val w = stdin.readLine

      val result = biggerIsGreater(w)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
