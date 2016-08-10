package cafe

import scala.math.BigDecimal.RoundingMode

object Bill {

  def total(items: Seq[String]): BigDecimal = items.map(Product(_).price).sum

  def serviceCharge(items: Seq[String]): BigDecimal = {
    val p = items.map(Product(_))

    if (p.forall(_.isInstanceOf[Drink])) {
      BigDecimal(0)
    } else {
      (total(items) * BigDecimal(0.1)).setScale(2, RoundingMode.CEILING)
    }
  }
}
