package Arrays

/**
 * Created by pradeepsanchana on 06/07/18.
 */
object insertionSort {
  def main(args: Array[String]) {
   // insert(Array(2, 4, 6, 8, 3))
    insert2(Array(1, 4 ,3 ,5, 6, 2 ))

  }
  def insert(x:Array[Int]):Unit ={
    val y =x(x.length-1)
    var p = 0
    for(i<- x.length-2 to 0 by -1
        if(y < x(i))){
        x(i+1) = x(i)
        x.foreach(l=>print(l+" "))
        println
        p = i
      }
      x(p) = y

    x.foreach(x=>print(x+" "))

  }
  def insert2(x:Array[Int]):Unit ={
    for(i<- 1 to x.length-1){
      var p = 0
      for (j<-0 to i-1
           if(x(i) < x(j))){
        var t = x(i)
        x(i) = x(j)
        x(j) = t
      }

      x.foreach(x=>print(x+" "))
      println
    }
  }


  def swap(x:Array[Int],i:Int,j:Int):Array[Int] = {
    var t = x(i)
    x(j) = x(i)
    x(j) = t
    x
  }

}
