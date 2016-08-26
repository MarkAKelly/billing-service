package cafe

import cafe.ServiceCharges._

object Bill {

  def total(items: Seq[String],
            charges: ((BigDecimal, Seq[Product]) => Option[BigDecimal])*): BigDecimal = {
    val itemsPurchased = items.map(Product(_))
    val total = itemsPurchased.map(_.price).sum
    total + charges.flatMap(_(total, itemsPurchased)).headOption.getOrElse(0)
  }

}
