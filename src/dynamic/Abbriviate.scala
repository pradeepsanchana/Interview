package dynamic
/**
 * Created by pradeepsanchana on 17/07/18.
 */
import java.io._
object Abbriviate {
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter("abc.txt")

    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val a = stdin.readLine

      val b = stdin.readLine

      val result = abbriviate(a, b)
      println(result)
      printWriter.println(result)
    }

    printWriter.close()
/* \   println(abbriviate("Yyxu","Y"))
    println(abbriviate("XXVVnDEFYgYeMXzWINQYHAQKKOZEYgSRCzLZAmUYGUGILjMDET","XXVVDEFYYMXWINQYHAQKKOZEYSRCLZAUYGUGILMDETQVWU"))
    println(abbriviate("AbcDE","ABDE"))*/
  }
  def abbriviate(a:String,b:String):String ={

    var res = Array.ofDim[Boolean](a.length+1, b.length+1)
    res(0)(0) = true
    for(i<-1 to a.length ){
      if(a(i-1) >= 'a' && a(i-1) <= 'z' ){
        res(i)(0) = res(i-1)(0)
      }
    }
    for(i<-1 to a.length){
      for(j<-1 to b.length){
        if((b(j-1) == a(i-1)) )
          res(i)(j) = res(i-1)(j-1)
        else if((b(j-1) == a(i-1).toChar.toUpper))
          res(i)(j) = res(i-1)(j-1) || res(i-1)(j)
        else if (a(i-1) >= 'a' && a(i-1) <= 'z' )
          res(i)(j) = res(i-1)(j)
      }
    }
    if(res(a.length)(b.length) == true)
      "YES"
    else
      "NO"
  }

}
