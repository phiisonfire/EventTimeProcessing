package de.phinguyen.sparkstreaming
package salesgenerator.config

import com.typesafe.config.ConfigFactory
import java.util.Properties

class KafkaConfig extends App {
  private val config = ConfigFactory.load("configuration.conf")

  def getKafkaProps: Properties = {
    val props = new Properties()
    props.put("bootstrap.servers", config.getString("kafka.bootstrap-servers"))
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props
  }

  val topicProducts = config.getString("kafka.topic-products")
}
