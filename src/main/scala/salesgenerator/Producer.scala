package de.phinguyen.sparkstreaming
package salesgenerator
import de.phinguyen.sparkstreaming.salesgenerator.models.{Inventory, Product, Purchase}
import de.phinguyen.sparkstreaming.salesgenerator.config.KafkaConfig
import org.apache.kafka.clients.producer.KafkaProducer

import java.util.Properties
import scala.io.Source

object Producer extends App {

  // create KafkaConfig instance
  val kafkaConfig = new KafkaConfig
  val kafkaProps: Properties = kafkaConfig.getKafkaProps

  // create Kafka Producer instance
  val producer = new KafkaProducer[String, String](kafkaProps)

  var products: List[Product] = List()
  val propensityToBuyRange: List[Int] = List()

  def createProductList(): Unit = {
    // path to the sample products.csv file
    val sampleProductsCsvPath = getClass.getResource("/data/products.csv").getPath
    val source = Source.fromFile(sampleProductsCsvPath)
    val lines = source.getLines().drop(1)
    lines.foreach { line =>
      val productFeaturesList = line.split(",").toList
      val newProduct = Product(
        timestamp = java.time.Instant.now().toString,
        productId = productFeaturesList(0),
        category = productFeaturesList(1),
        item = productFeaturesList(2),
        size = productFeaturesList(3),
        cogs = productFeaturesList(4).toFloat,
        price = productFeaturesList(5).toFloat,
        inventoryLevel = productFeaturesList(6).toInt,
        containsFruit = productFeaturesList(7).toBoolean,
        containsVeggies = productFeaturesList(8).toBoolean,
        containsNuts = productFeaturesList(9).toBoolean,
        containsCaffeine = productFeaturesList(10).toBoolean,
        propensityToBuy = productFeaturesList(14).toInt
      )
      products = products :+ newProduct
    }
    source.close()
  }


  def publishToKafka(producer: KafkaProducer[String, String],
                     topic: String,
                     message) = {
    producer.send(topic, message)
  }


}
