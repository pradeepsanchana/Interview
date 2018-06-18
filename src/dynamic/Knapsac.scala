package dynamic

/**
 * Created by pradeepsanchana on 01/06/18.
 */
object Knapsac {


  def main(args: Array[String]) {

    val weight = Array(1,3,4,5)
    val value  = Array(1,4,5,7)
    val totW = 7
    println(knap(weight,value,totW))

  }

  def knap(weight:Array[Int],value:Array[Int], totW:Int):Int ={

    val T = Array.ofDim[Int]( value.length+1 , totW+1)

    for(i<-1 to weight.length)
      for(j<-1 to totW){
        T(i)(j) = if(j<weight(i-1))
          T(i-1)(j)
        else
         Math.max(T(i-1)(j), T(i-1)(j - weight(i-1)) + value(i-1))

      }

    T(weight.length)(totW)
  }

}
