package Arrays

/**
 * Created by pradeepsanchana on 12/07/18.
 */
object BinarySearch {
  def main(args: Array[String]) {
    println(bFind(Array(1,3,5,7,9,11,13,15,17,19,21,23), 23))

  }

  def bFind(arr:Array[Int],V:Int):Int ={

    arr.sorted
    var st = 0
    var end = arr.length-1
    var mid = (st +end)/2
    if(arr.contains(V)) {
      while(true){
        if(V == arr(mid) ){
          return mid
        } else if (V > arr(mid)){
          mid = Math.ceil((mid + end)/2.0).toInt
        } else {
          mid = (mid+st)/2
        }


      }
      mid
    } else
    -1
  }
}
