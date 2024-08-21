package de.phinguyen.sparkstreaming
package salesgenerator.models

case class Inventory(
                      timestamp: String,
                      productId: String,
                      previousLevel: Int,
                      restockAmount: Int,
                      newLevel: Int
                    )
