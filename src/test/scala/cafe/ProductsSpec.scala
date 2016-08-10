package cafe

import org.scalatest.{Matchers, WordSpec}

class ProductsSpec extends WordSpec with Matchers {

  "Creating a product" when {

    "passing in a string 'Cola'" should {
      val cola = Product("Cola")

      "create a Cola object" in {
        cola shouldBe Cola
      }

      "have a price of 50p" in {
        cola.price shouldBe BigDecimal(0.5)
      }
    }

    "passing in a string 'Coffee'" should {
      val coffee = Product("Coffee")

      "create a Coffee object" in {
        coffee shouldBe Coffee
      }

      "have a price of £1.00" in {
        coffee.price shouldBe BigDecimal(1)
      }
    }

    "passing in a string 'Cheese Sandwich'" should {
      val sandwich = Product("Cheese Sandwich")

      "create a CheeseSandwich object" in {
        sandwich shouldBe CheeseSandwich
      }

      "have a price of £2.00" in {
        sandwich.price shouldBe BigDecimal(2)
      }
    }

    "passing in a string 'Steak Sandwich'" should {
      val sandwich = Product("Steak Sandwich")

      "create a SteakSandwich object" in {
        sandwich shouldBe SteakSandwich
      }

      "have a price of £4.50" in {
        sandwich.price shouldBe BigDecimal(4.5)
      }
    }

  }
}

