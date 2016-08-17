package cafe

import scala.math.BigDecimal.RoundingMode

object Bill {

  def serviceCharge(items: Seq[String]): BigDecimal = {

    val maxHotFoodServiceCharge = BigDecimal(20)
    val p = items.map(Product(_))

    if (p.forall(_.isInstanceOf[Drink])) {
      BigDecimal(0)
    } else if (p.exists(_.isInstanceOf[HotFood])) {
      val charge = (total(items) * BigDecimal(0.2)).setScale(2, RoundingMode.CEILING)
      if (charge > maxHotFoodServiceCharge) maxHotFoodServiceCharge else charge
    } else {
      (total(items) * BigDecimal(0.1)).setScale(2, RoundingMode.CEILING)
    }
  }

  def total(items: Seq[String]): BigDecimal = items.map(Product(_).price).sum
}
