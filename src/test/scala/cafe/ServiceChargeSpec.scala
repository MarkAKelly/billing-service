package cafe

import org.scalatest.{Matchers, WordSpec}

class ServiceChargeSpec extends WordSpec with Matchers {

  "Calculating the standard service charge" when {
    val target = ServiceCharges.standardCharge
    val total = BigDecimal("123.35")

    "all items purchased are drinks" should {

      "result in no service charge for only cold drinks" in {
        target(total, Seq(Cola, Cola)) shouldBe Some(0)
      }

      "result in no service charge for only hot drinks" in {
        target(total, Seq(Coffee, Coffee)) shouldBe Some(0)
      }

      "result in no service charge for only drinks, hot or cold" in {
        target(total, Seq(Coffee, Cola)) shouldBe Some(0)
      }
    }

    "items purchased include food" should {

      "result in a 10% service charge" in {
        target(100, Seq(Cola, CheeseSandwich)) shouldBe Some(10)
      }

      "result in a 10% service charge rounded up to 2 decimal places from N.NN5" in {
        val total = BigDecimal("123.35")
        target(total, Seq(Cola, CheeseSandwich)) shouldBe Some(12.34)
      }

      "result in a 10% service charge rounded up to 2 decimal places from N.NN6" in {
        val total = BigDecimal("123.36")
        target(total, Seq(Cola, CheeseSandwich)) shouldBe Some(12.34)
      }

      "result in a 10% service charge rounded down to 2 decimal places from N.NN4" in {
        val total = BigDecimal("123.34")
        target(total, Seq(Cola, CheeseSandwich)) shouldBe Some(12.33)
      }
    }
  }

  "Calculating the hot food service charge" when {
    val target = ServiceCharges.hotFoodCharge
    val total = BigDecimal("123.35")

    "items purchased do NOT contain hot food" should {

      "result in no service charge for only cold drinks" in {
        target(total, Seq(Cola, Cola)) shouldBe None
      }

      "result in no service charge for only hot drinks" in {
        target(total, Seq(Coffee, Coffee)) shouldBe None
      }

      "result in no service charge for cold food" in {
        target(total, Seq(CheeseSandwich)) shouldBe None
      }
    }

    "items purchased include hot food" should {

      "result in a 20% service charge" in {
        target(100, Seq(SteakSandwich)) shouldBe Some(20)
      }

      "result in a max service charge of £20.00" in {
        val total = BigDecimal("10000")
        target(total, Seq(Cola, SteakSandwich)) shouldBe Some(20)
      }
    }
  }

  "Calculating the premium food service charge" when {
    val target = ServiceCharges.premiumFoodCharge
    val total = BigDecimal("123.35")

    "items purchased do NOT contain premium food" should {

      "result in no service charge for cold drinks" in {
        target(total, Seq(Cola, Cola)) shouldBe None
      }

      "result in no service charge for hot drinks" in {
        target(total, Seq(Coffee, Coffee)) shouldBe None
      }

      "result in no service charge for cold food" in {
        target(total, Seq(CheeseSandwich)) shouldBe None
      }

      "result in no service charge for hot food" in {
        target(total, Seq(SteakSandwich)) shouldBe None
      }
    }

    "items purchased include premium food" should {

      "result in a 25% service charge" in {
        target(100, Seq(Lobster)) shouldBe Some(25)
      }

      "result in a max service charge of £40.00" in {
        val total = BigDecimal("10000")
        target(total, Seq(Cola, Lobster)) shouldBe Some(40)
      }
    }
  }

}
