package cafe

import org.scalatest.{Matchers, WordSpec}

class BillSpec extends WordSpec with Matchers {
  val coffee = "coffee"
  val cola = "cola"
  val cheeseSandwich = "cheese sandwich"
  val steakSandwich = "steak sandwich"
  val lobster = "lobster"

  "The total bill for an empty order" should {
    "amount to £0.00" in {
      Bill.total(Nil) shouldBe BigDecimal(0)
    }
  }

  "The total bill for a cola" should {
    "amount to £0.50" in {
      Bill.total(List(cola)) shouldBe BigDecimal(0.5)
    }
  }

  "The total bill for 2 cola drinks" should {
    "amount to £1.00" in {
      Bill.total(List(cola, cola)) shouldBe BigDecimal(1)
    }
  }

  "The total bill for 1 coffee" should {
    "amount to £1.00" in {
      Bill.total(List(coffee)) shouldBe BigDecimal(1)
    }
  }

  "The total bill for 2 coffees" should {
    "amount to £2.00" in {
      Bill.total(List(coffee, coffee)) shouldBe BigDecimal(2)
    }
  }

  "The total bill for a cola and a coffees" should {
    "amount to £1.50" in {
      Bill.total(List(cola, coffee)) shouldBe BigDecimal(1.5)
    }
  }

}
