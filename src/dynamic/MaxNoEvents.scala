package dynamic

/**
 * Created by pradeepsanchana on 03/06/18.
 */
object MaxNoEvents {

  /*
    * Complete the findMaximumEvents function below.
    */
  def findMaximumEvents(eventDetails: Array[String]) {
    var eventTime =Array.ofDim[Int](eventDetails.size,2)

    for(i<-0 to eventDetails.size-1) {
      eventTime(i)(0) = eventDetails(i).split(" ")(0).toInt
      eventTime(i)(1) = eventDetails(i).split(" ")(1).toInt

    }
    eventTime = eventTime.sortWith(_(1) < _(1))
    var store =  Array.fill(eventDetails.size)(1)
    for(i<-1 to eventDetails.size-1) {
      for(j<-0 to i-1) {
        if(eventTime(i)(0) > eventTime(j)(1)){
          store(i) = Math.max(store(i), store(j)+1)
        }
      }
      // println(store.mkString(" "))
    }
    println(store.max)
    //store.max
  }



  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val eventDetailsCount = stdin.readLine.trim.toInt

    val eventDetails = Array.ofDim[String](eventDetailsCount)

    for (eventDetailsItr <- 0 until eventDetailsCount) {
      val eventDetailsItem = stdin.readLine
      eventDetails(eventDetailsItr) = eventDetailsItem}

    findMaximumEvents(eventDetails)
  }

}
