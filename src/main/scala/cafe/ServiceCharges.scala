package cafe

import scala.math.BigDecimal.RoundingMode

object ServiceCharges {

  val rounding = RoundingMode.HALF_EVEN

  val standardCharge: (BigDecimal, Seq[Product]) => Option[BigDecimal] = (total, xs) => {
    val rate = BigDecimal(0.1)

    if (!xs.forall(_.isInstanceOf[Drink])) {
      Some((total * rate).setScale(2, rounding))
    } else Some(0)
  }

  val hotFoodCharge: (BigDecimal, Seq[Product]) => Option[BigDecimal] = (total, xs) => {
    val maxHotFoodServiceCharge = BigDecimal(20)
    val rate = BigDecimal(0.2)

    if (xs.exists(_.isInstanceOf[HotFood])) {
      val charge = (total * rate).setScale(2, rounding)
      if (charge > maxHotFoodServiceCharge) Some(maxHotFoodServiceCharge) else Some(charge)
    } else None
  }

  val premiumFoodCharge: (BigDecimal, Seq[Product]) => Option[BigDecimal] = (total, xs) => {
    val maxPremiumFoodServiceCharge = BigDecimal(40)
    val rate = BigDecimal(0.25)

    if (xs.exists(_.isInstanceOf[PremiumFood])) {
      val charge = (total * rate).setScale(2, rounding)
      if (charge > maxPremiumFoodServiceCharge) Some(maxPremiumFoodServiceCharge) else Some(charge)
    } else None
  }

}
