package com.sundogsoftware.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import scala.math.min

object MinTemperatures2 {
  
  def parseLine (line: String) = {
    val fields = line.split(",")
    val city_id = fields(0)
    val data_type = fields(2)
    val temperature = fields(3).toFloat * 0.1f * (9.0f / 5.0f) + 32.0f
    (city_id, data_type, temperature)
  }
  
  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc =  new SparkContext("local[*]", "MinTemperatures")
    val lines = sc.textFile("../1800.csv")
    val parsedLines = lines.map(parseLine)
    val minTemps = parsedLines.filter(x => x._2 == "TMIN")
    val stationTemps = minTemps.map ( x => (x._1, x._3.toFloat))
    val minTempByStation = stationTemps.reduceByKey((x,y) => min(x,y))
    val results = minTempByStation.collect()
    for (results <- results.sorted) {
      val station = results._1
      val temp = results._2
      val formattedTemp = f"$temp%.2f F"
      println(s"$station minimum temperature : $formattedTemp")
    }
    
    
  }
  
}