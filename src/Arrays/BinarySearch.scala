package Arrays

/**
 * Created by pradeepsanchana on 12/07/18.
 */
object BinarySearch {
  def main(args: Array[String]) {
//    println(bFind(Array(1,3,5,7,9,11,13,15,17,19,21,23), 23))
//    meanderingArray(Array(5,2,7,8,-2,25,25)).foreach(println)
    println(getIntegerComplement(5))
  }

  def bFind(arr:Array[Int],v:Int):Int ={

    arr.sorted
    var st = 0
    var end = arr.length-1
    var mid = (st +end)/2
    if(arr.contains(v)) {
      while(true){
        if(v == arr(mid) ){
          return mid
        } else if (v > arr(mid)){
          mid = Math.ceil((mid + end)/2.0).toInt
        } else {
          mid = (mid+st)/2
        }


      }
      mid
    } else
    -1
  }
  def meanderingArray(unsorted: Array[Int]): Array[Int] = {

    var sorted = unsorted.sorted
    var res = Array.ofDim[Int](unsorted.length)
    for (i<-0 to unsorted.length-1){
      if(i%2 == 0)
        res(i) = sorted(unsorted.length-i/2-1)
      else
        res(i) = sorted(i/2)
    }
    res
  }
  def getIntegerComplement(n: Int): Int = {
    var t= n
    var i = 1
    while(t/2 != 0){
      i +=1
      t=t/2
    }
    Math.pow(2,i).toInt-n
  }

}
