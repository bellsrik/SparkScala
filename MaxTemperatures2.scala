package com.sundogsoftware.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import scala.math.max

object MaxTemperatures2 {
   def parseLine(line:String)= {
    //Split each line
     val fields = line.split(",")
    //get fields and convert to Int or Float etc.
     val city_id = fields(0)
     val data_type = fields(2)
     val temperature = fields(3).toFloat * 0.1f * (9.0f / 5.0f) + 32f
    //Create Tuple
     (city_id, data_type, temperature)
  }

  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)
    //Create SparkContext
    val sc = new SparkContext ("local[*]", "MaxTemperatures2")
    //Create RDD from Source file
    val lines = sc.textFile("../1800.csv")
    //Map and Reduce
    val parsedLines = lines.map(parseLine)
    val maxTemp = parsedLines.filter(x => x._2 == "TMAX")
    val maxTempByStation = maxTemp.map(x => (x._1, x._3.toFloat))
    val stationMax = maxTempByStation.reduceByKey((x,y) => max(x,y))
    val results = stationMax.collect()
    for (result <- (results.sorted)) {
      val station = result._1
      val temp = result._2
      val formattedTemp = f"$temp%.2f F"
      println(s"$station maximum temperature: $formattedTemp")
    }
    //Print Results
  }
}