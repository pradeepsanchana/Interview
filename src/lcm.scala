import scala.collection.mutable.HashMap

/**
 * Created by pradeepsanchana on 20/06/18.
 */
object lcm {
  def main(args: Array[String]) {
    println(gcd(20,30))
    println(getLcm(20,30))
    println(getLcm(40,30))
    println(getLcm(getLcm(20,30),40))
  }

  def getLcm(x:Int, y:Int):Int= {
    var l = findAllMul(x)
    var m = findAllMul(y)
    var p=0
    var q=0
    var sum = 1.0
    var finalV = HashMap[Int,Int]()
    for(i <- l.keysIterator ){
      p = l(i)
      if( m.contains(i)){
        q = m(i)
        m.remove(i)
      }
      finalV += (i -> Math.max(p,q))
    }
    finalV ++= m
    for(i<- finalV.keysIterator){
      p = finalV(i)
      sum *= Math.pow(i.toDouble,p.toDouble)
    }
    sum.toInt
  }

  def findAllMul(x:Int) ={
    var i = x
    var j = 2
    var ret = HashMap[Int,Int]()
    var num = 1
    while ( j <= i){
      if(i%j == 0){
        if( ret.contains(j)){
          var num = ret(j)
          num += 1
          ret(j) = num
        } else{
          ret += (j -> num)
        }
        i /= j
      } else {
        j += 1
      }
    }
    ret

  }
   def gcd(x:Int, y:Int):Int= {
     if(y!=0 )
         return gcd(y,x%y)
       else
         return x
   }

}
