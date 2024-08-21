package de.phinguyen.sparkstreaming
package salesgenerator.models

case class Purchase(
                     transactionTime: String,
                     transactionId: String,
                     productId: String,
                     price: Double,
                     quantity: Int,
                     isMember: Boolean,
                     memberDiscount: Double,
                     addSupplement: Boolean,
                     supplementPrice: Double
                   )
