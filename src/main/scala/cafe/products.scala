package cafe

trait Product {
  val price: BigDecimal
}

trait Drink extends Product
trait Food extends Product
trait HotFood extends Food
trait PremiumFood extends Food

object Product {
  def apply(name: String): Product = name.toLowerCase match {
    case "cola" => Cola
    case "coffee" => Coffee
    case "cheese sandwich" => CheeseSandwich
    case "steak sandwich" => SteakSandwich
    case "lobster" => Lobster
  }
}

object Cola extends Drink {
  override val price: BigDecimal = 0.5
}

object Coffee extends Drink {
  override val price: BigDecimal = 1
}

object CheeseSandwich extends Food {
  override val price: BigDecimal = 2
}

object SteakSandwich extends HotFood {
  override val price: BigDecimal = 4.5
}

object Lobster extends PremiumFood {
  override val price: BigDecimal = 25
}