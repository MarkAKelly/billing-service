package cafe

import org.scalatest.{Matchers, WordSpec}

class BillSpec extends WordSpec with Matchers {

  "The total bill for an empty order" should {
    "amount to £0.00" in {
      Bill.total(Nil) shouldBe BigDecimal(0)
    }
  }

  "The total bill for a cola" should {
    "amount to £0.50" in {
      Bill.total(List("cola")) shouldBe BigDecimal(0.5)
    }
  }

  "The total bill for 2 cola drinks" should {
    "amount to £1.00" in {
      Bill.total(List("cola", "cola")) shouldBe BigDecimal(1)
    }
  }

  "The total bill for 1 coffee" should {
    "amount to £1.00" in {
      Bill.total(List("coffee")) shouldBe BigDecimal(1)
    }
  }

  "The total bill for 2 coffees" should {
    "amount to £2.00" in {
      Bill.total(List("coffee", "coffee")) shouldBe BigDecimal(2)
    }
  }

  "The total bill for a cola and a coffees" should {
    "amount to £1.50" in {
      Bill.total(List("cola", "coffee")) shouldBe BigDecimal(1.5)
    }
  }

  "Calculating the service charge" when {
    "all items purchased are drinks" should {

      "result in no service charge for a cola" in {
        Bill.serviceCharge(List("cola")) shouldBe BigDecimal(0)
      }

      "result in no service charge for 2 cola drinks" in {
        Bill.serviceCharge(List("cola", "cola")) shouldBe BigDecimal(0)
      }

      "result in no service charge for a coffee" in {
        Bill.serviceCharge(List("coffee")) shouldBe BigDecimal(0)
      }

      "result in no service charge for 2 coffees" in {
        Bill.serviceCharge(List("coffee", "coffee")) shouldBe BigDecimal(0)
      }

      "result in no service charge for a cola and a coffees" in {
        Bill.serviceCharge(List("cola", "coffee")) shouldBe BigDecimal(0)
      }
    }

    "items purchased include food" should {

      "result in no service charge for a cola and 2 steak sandwiches" in {
        Bill.serviceCharge(List("cola", "steak sandwich", "steak sandwich")) shouldBe BigDecimal(0.95)
      }
    }
  }

}
