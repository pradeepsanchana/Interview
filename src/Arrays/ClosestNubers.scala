package Arrays

/**
 * Created by pradeepsanchana on 15/07/18.
 */
object ClosestNubers {
  def main(args: Array[String]) {
    closestNumbers(Array(-20, -3916237, -357920 ,-3620601, 7374819 ,-7330761, 30 ,6246457, -6461594, 266854 )).foreach(x=>print(x+" "))
  }
  def closestNumbers(arr:Array[Int]):Array[Int]={
    var  asort = arr.sorted
    var diff = Int.MaxValue
    var res = Array[Int]()
    for(i<-0 to asort.length-2){
      diff = Math.min(asort(i+1) - asort(i),diff)
    }
    for(i<-0 to asort.length-2){
      if(diff == (asort(i+1) - asort(i))){
        res ++= Array(asort(i),asort(i+1))
      }
    }
    res
  }

}
