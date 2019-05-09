package cafe

object Tax {

  val allowance:BigDecimal = 11000

  val monthly : BigDecimal => BigDecimal = num => (num / 12).setScale(2, BigDecimal.RoundingMode.HALF_UP)

  def getPayslip(salary: BigDecimal): Payslip = {

    Payslip(
      grossSalary = monthly(salary),
      ni = monthly(getNi(salary)),
      allowance = monthly(getAllowance(salary)),
      taxableIncome = monthly(taxableIncome(salary)),
      taxPayable = monthly(taxPayable(salary)))
  }

  private def getNi(salary: BigDecimal) : BigDecimal = {
    val basicRate = 0.12
    val higherRate = 0.02

    val highSalary: BigDecimal = if (salary > 43000) salary - 43000 else 0
    val basicSalary: BigDecimal = if (salary > 8060) salary - 8060 - highSalary else 0

    (highSalary * higherRate) + (basicSalary * basicRate)
  }

  private def getAllowance(salary: BigDecimal) = {
    allowance
  }

  private def taxableIncome(salary: BigDecimal) = {
    salary - allowance
  }

  private def taxPayable(sal: BigDecimal): BigDecimal = {

    val basicRate = 0.2
    val higherRate = 0.4
    val additionalRate = 0.45

    val salary = Range(0, sal.toInt)

    val ZERO = 0
    val basicLimit = 11000
    val higherLimit = 43000
    val additionalLimit = 150000

    val allowance = salary.splitAt(basicLimit)
    val basicPart = allowance._2.partition(b => (b >= basicLimit) && (b < higherLimit))
    val higherPart = basicPart._2.partition(h => h < additionalLimit && h >=basicLimit)
    val addPart = higherPart._2.partition(_ > additionalLimit)

    (basicPart._1.size * basicRate) + (higherPart._1.size * higherRate) + (addPart._1.size * additionalRate)
  }
}

case class Payslip(id: Int = 12345,
                   name: String = "John J Doe",
                   grossSalary: BigDecimal,
                   ni: BigDecimal,
                   allowance: BigDecimal,
                   taxableIncome: BigDecimal,
                   taxPayable: BigDecimal
                  )


