package org.twelveHart.example.sftp

import org.apache.spark.sql.DataFrame

object sftpTest extends SparkSessionWrapper {
  def main(args: Array[String]): Unit = {
    
    import spark.implicits._
    spark.sparkContext.setLogLevel("ERROR")
    
    val df: DataFrame = Seq(
      ("Alex", "2018-01-01 00:00:00", "2018-02-01 00:00:00", "OUT"),
      ("Bob", "2018-02-01 00:00:00", "2018-02-05 00:00:00", "IN"),
      ("Mark", "2018-02-01 00:00:00", "2018-03-01 00:00:00", "IN"),
      ("Mark", "2018-05-01 00:00:00", "2018-08-01 00:00:00", "OUT"),
      ("Meggy", "2018-02-01 00:00:00", "2018-02-01 00:00:00", "OUT")
    ).toDF("NAME", "START_DATE", "END_DATE", "STATUS")
  
    df.printSchema()
  
    df.write
      .format("com.springml.spark.sftp")
      .option("host", "localhost")
      .option("username", "XXXXXX")
      .option("password", "XXXXXXX")
      .option("fileType", "csv")
      .option("delimiter", ";")
      .option("codec", "bzip2")
      .save("/tmp/daily.csv")
  
    spark.stop()
  }
}
