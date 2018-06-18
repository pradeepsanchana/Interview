/**
 * Created by pradeepsanchana on 06/04/18.
 */
object LearningScala3 extends App{

  def splitA():String = {
    var sentence = "You can do it the way you Like"
    var b= ""
    if( !sentence.split(" ").filter(_.length>2).filter( _.length%2 ==0 ).isEmpty ){
      sentence.split(" ").filter(_.length>2).filter( _.length%2 ==0 )(0)
    }else{


    "00"

  }
//    a.charAt(0)
    //x * x
  }
  def isPangramOrNot(strings: String): String = {
    var a = new Array[Int](26)
    for(i<-0 to strings.length-1){
      if(strings(i) != ' '){
        a(strings(i)%97) = 1

      }
    }
    for(j<-0 to a.length-1){
      if(a(j) == 0)
       return "O"
    }
    "1"
  }

  def isPangram(strings: Array[String]): String = {
    var res =""
    for(k<-0 to strings.length-1){
      res += isPangramOrNot(strings(k))
    }
    res
  }

  def cube (x:Int):Int = {
    x* x * x
  }
  //println(cube(5))
  def transformInt(x:Int,f:Int=>Int): Int ={
    f(x)
  }
  println(isPangram(Array("we promptly judged antique ivory buckles for the next prize","a")))
 // println(transformInt(3,cube))
 // println(splitA())

  //println(transformInt(3,x=> x*x*x*x))

  //println(transformInt(3,x=> {val y= x*2; y*x}))
}
