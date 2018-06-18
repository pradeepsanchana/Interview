/**
 * Created by pradeepsanchana on 17/04/18.
 */
object Abbreviation {
  def abbreviation(a: String, b: String): String = {
    // Complete this function

      var ka = a.getBytes()
      var kb = b.getBytes()
     var buf = new Array[Byte](100)
      var i = 0
      var j = 0
      var k =0
      while ((!(ka(i) == kb(j) || ka(i) - 32 == kb(j))) && (i < a.length - 1)) {
        i += 1
      }
      while (j <= b.length-1  && i <= a.length - 1) {
          if (j<= b.length-1 && (ka(i) == kb(j))) {
            i += 1
            j += 1
          } else if ( ka(i) - 32 == kb(j)){
            while ( i <= a.length - 1){
              buf(k) = ka(i)
              k += 1
              i+=1
            }
          }else {
            if (ka(i) >= 65 && ka(i) <= 90 && ka(i-1)-32 != ka(i) ) {
              return "NO"
            } else {
              i += 1
            }
          }
        }
      if((j == b.length && i <= a.length)) {
        while (i <= a.length - 1) {
          if (ka(i) >= 65 && ka(i) <= 90 && ka(i-1)-32 != ka(i) ) {
            return "NO"
          } else {
            i += 1
          }
        }
        "YES"
      } else {
        "NO"

      }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var q = sc.nextInt();
    var a0 = 0;
    while(a0 < q){
      var a = sc.next();
      var b = sc.next();
      val result = abbreviation(a, b);
      println(result)
      a0+=1;
    }
  }
}
