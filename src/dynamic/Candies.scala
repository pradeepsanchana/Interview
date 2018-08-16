package dynamic

/**
 * Created by pradeepsanchana on 19/07/18.
 */
object Candies {
  def main(args: Array[String]) {
    //println(candies(3,Array(1,2,2)))
    //println(candies(9,Array(9,8,7,1,4,5,3,2,1)))
    println(candies(8,Array(2,4,3,5,2,6,4,5)))
    println(candies(10,Array(2,4,2,6,1,7,8,9,2,1)))
    }
  def candies(n:Int, arr:Array[Int]):Int ={
    var res = Array.ofDim[Int](n)
    //res(0) =1
    var min =0
    for(i<-1 to n-2){
      if(arr(i) < arr(i+1)){
        if(arr(i-1) > arr(i)){
          res(i) = 1
        }
        res(i+1) = res(i) + 1


        //min  = Math.min(res(i),min)
      } else if(arr(i) == arr(i+1)){
        res(i+1) = res(i)
      }
    }

    if(res(n-1) ==0 ){
      res(n-1) = 1
    }
    for(i<-n-2 to 1 by -1 if(res(i) == 0)){
      if(arr(i) < arr(i-1)){
        res(i) = Math.min(res(i-1) + 1,res(i+1)+1)
      } else {
        //res(i) = res(i-1) + 1
      }
    }
    if(res(0) ==0 ){
      res(0) = res(1)+1
    }
    for(i<-1 to n-2 if(res(i) == 0)){
      if(arr(i) > arr(i-1)){
        res(i) = Math.max(res(i-1) + 1,res(i+1)+1)
      }
    }
    res.foreach(print)
    println
    res.sum
  }

}
