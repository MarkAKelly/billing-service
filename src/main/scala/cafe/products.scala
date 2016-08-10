package cafe

trait Product {
  val price: BigDecimal
}

trait Drink extends Product

object Product {
  def apply(name: String): Product = name.toLowerCase match {
    case "cola" => Cola
    case "coffee" => Coffee
    case "cheese sandwich" => CheeseSandwich
    case "steak sandwich" => SteakSandwich
  }
}

object Cola extends Drink {
  override val price: BigDecimal = 0.5
}

object Coffee extends Drink {
  override val price: BigDecimal = 1
}

object CheeseSandwich extends Product {
  override val price: BigDecimal = 2
}

object SteakSandwich extends Product {
  override val price: BigDecimal = 4.5
}