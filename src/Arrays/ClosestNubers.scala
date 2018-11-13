package Arrays
/**
 * Created by pradeepsanchana on 15/07/18.
 */
object ClosestNubers {
  def main(args: Array[String]) {
    maxCircle(Array(Array(1,2),Array(3,4),Array(2,3)))
    //maxCircle(Array(Array(1000000000,23),Array(11,3778),Array(7,47),Array(11,1000000000)))
    //println(countingValleys(10,"UDUUUDUDDD"))
    //println(countingValleys(1000000,""))

    //println(jumpingOnClouds( Array(0,0,1,0,0,1,0)))
    //println(sockMerchant(9,Array(10,20, 20, 10, 10, 30, 50, 10, 20)))
//    val (x,y) = closestNumbers(Array(-20, -3916237, -357920 ,-3620601, 7374819 ,-7330761, 30 ,6246457, -6461594, 266854 ))
//    print(x + " " + y)
  }
  def closestNumbers(arr:Array[Int]):(Int, Int)={
    var  asort = arr.sorted
    var diff = Int.MaxValue
    var res:(Int,Int) = (0,0)
    for(i<-0 to asort.length-2){
      if( diff > asort(i+1) - asort(i)){
        diff = asort(i+1) - asort(i)
        res = (asort(i),asort(i+1) )
      }

    }
    res
  }
  def sockMerchant(n: Int, ar: Array[Int]): Int = {
    var c =0
    var h:Map[Int,Int] = Map()
    for (j<-0 to n-1){
      if (h.contains(ar(j))) {
        val b = h(ar(j))
        h += (ar(j) -> (b + 1))
      } else {
        h += (ar(j) -> 1)
      }
    }
    for(i<-h.keySet){

        c += h(i) / 2
    }
    c

  }
  def jumpingOnClouds(c: Array[Int]): Int = {
    var r = new Array[Int](c.length)


    r(0) = 0
    if(c(1) ==0 ){
      r(1) =1
    }
    for(i<-2 to c.length-1){
      if(c(i) == 0) {
        r(i) = Math.min(r(i-1),r(i-2)) + 1
      }else {
        r(i) = 9999
      }
    }
    r(c.length-1)
  }

  def countingValleys(n: Int, s: String): Int = {
    var r = new Array[Int](1)
    var c = 0
    r(0) = 0
    var i =0
    while(i< n){
      if(s(i) == 'U'){
        while( i< n && s(i) == 'U'){
          c +=1
          i +=1
        }
      } else {
        while (i< n && s(i) == 'D' ){
          c -= 1
          i +=1
        }
      }
      r   +:= c
    }
    for(i<-0 to r.length-1){
      print(r(i)+ " ")
    }
    var lmax = r(0)
    var steps = 0
    var vf:Boolean = false
    for(i<-r.length-2 to 0 by -1){
      if(r(i) < 0 && vf == false){
        steps +=1
        vf = true
      }
      if(  r(i) >= 0 && vf== true){
        vf = false
        //lmax =r(i)
      }
    }
    steps
  }
  def maxCircle(queries: Array[Array[Int]]): Array[Int] = {
    var a = collection.mutable.Set[collection.mutable.Set[Int]]()
    //var b = collection.mutable.Set[Int]()
    var res:Array[Int] = Array()
    var r = queries.length-1
    var c = queries(0).length-1
    a +=  collection.mutable.Set(queries(0)(0), queries(0)(1))
    res +:= 2
    var max = 2
    for(i<-1 to r) {
      var addFlag = false
      for (j <- a) {
        if (j.contains(queries(i)(0))) {
          for (k <- a - j if (k.contains(queries(i)(1)))) {
            val m = k ++ j
            a.remove(k)
            a.remove(j)
            a.add(m)
            max = Math.max(max, m.size)
            res +:= max

            addFlag = true
          }
          if (addFlag == false) {
            val l = j + queries(i)(1)
            a.remove(j)
            a.add(l)
            max = Math.max(max, l.size)
            res +:= max
            addFlag = true
          }

        } else if (j.contains(queries(i)(1))) {
          for (k <- a - j if (k.contains(queries(i)(0)))) {
            val m = k ++ j
            a.remove(k)
            a.remove(j)
            a.add(m)
            max = Math.max(max, m.size)
            res +:= max
            addFlag = true
          }
          if (addFlag == false) {
            val l = j + queries(i)(1)
            a.remove(j)
            a.add(l)
            max = Math.max(max, l.size)
            res +:= max
            addFlag = true
          }
        }
      }
      if (addFlag == false) {
        a += collection.mutable.Set(queries(i)(0), queries(i)(1))
        max = Math.max(max, 2)
        res +:= max
      }
    }
      //println(queries(i)(0)+ " , "+ queries(i)(1))
    res.reverse.foreach(println)
    res.reverse

  }

}
