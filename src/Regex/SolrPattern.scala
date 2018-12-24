package Regex

/**
 * Created by pradeepsanchana on 16/07/18.
 */
object SolrPattern {
  def main(args: Array[String]) {
    //println(extractShardId("sjsolr-int2b1:8983_solr"))
//    println(extractShardId("gusw1-int-solr-node-0001-a-001.gcp-np:8983_solr"))
   /* println(extractShardId("gusw1-int-solr-node-0001-a-001.gcp-np.marketo.org:8983_solr"))
    println(extractShardId("gusw1-int-solr-node-0001-b-001.gcp-np.marketo.org:8983_solr"))
    println(extractShardId("gusw1-int-solr-node-0001-a-003.gcp-np.marketo.org:8983_solr"))
    println(extractShardId("gusw1-int-solr-node-0001-b-003.gcp-np.marketo.org:8983_solr"))
    println(extractShardId("gusw1-int-solr-node-0001-a-004.gcp-np.marketo.org:8983_solr"))
    println(extractShardId("gusw1-int-solr-node-0001-b-004.gcp-np.marketo.org:8983_solr"))
    println(extractShardId("gusw1-int-solr-node-0001-a-002.gcp-np.marketo.org:8983_solr"))
    println(extractShardId("gusw1-int-solr-node-0001-b-002.gcp-np.marketo.org:8983_solr"))*/
    println(decimal("(75,180)"))
  }
  def extractShardId(nodeName: String): String = {
    val pattern = """([a-z]+[0-9]+\-?[a-z]*\-?solr\-?node\-?[0-9]+\-?[ab]\-?[0-9]+.*):.*""".r

   // val pattern(shardId) = nodeName
  //  shardId

    nodeName match {
      case pattern => "i am here"

    }
  }
  def decimal(nodeName: String): String = {
    val pattern = """(\(\d*\.?\d*\, \d*\.?\d*$/\))""".r

    // val pattern(shardId) = nodeName
    //  shardId

    nodeName match {
      case pattern => "i am here"
      case _ => "be"

    }
  }

}
