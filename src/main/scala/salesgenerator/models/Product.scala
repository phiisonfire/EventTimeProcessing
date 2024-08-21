package de.phinguyen.sparkstreaming
package salesgenerator.models

case class Product(
                    timestamp: String,
                    productId: String,
                    category: String,
                    item: String,
                    size: String,
                    cogs: Float,
                    price: Float,
                    inventoryLevel: Int,
                    containsFruit: Boolean,
                    containsVeggies: Boolean,
                    containsNuts: Boolean,
                    containsCaffeine: Boolean,
                    propensityToBuy: Int
                  )
