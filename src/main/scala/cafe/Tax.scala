package cafe

import sun.security.krb5.internal.PAData.SaltAndParams

object Tax {

  val allowance:BigDecimal = 11000

  val monthly : BigDecimal => BigDecimal = num => (num / 12).setScale(2, BigDecimal.RoundingMode.HALF_UP)

  def getPayslip(salary: BigDecimal): Payslip = {

    taxPayable(salary)

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

  private def taxPayable(salary: BigDecimal): BigDecimal = {

    val basic = 0.2
    val higher = 0.4
    val additional = 0.45

    val taxable = taxableIncome(salary)
    val additionalAmt: BigDecimal = if (taxable > 150000) taxable - 150000 else 0
    val higherAmt: BigDecimal = if (taxable > 43000) taxable - 11000 - additionalAmt else 0
    val basicAmt: BigDecimal = if (taxable > 11000) taxable - higherAmt else 0

    (basicAmt * basic) + (higherAmt * higher) + (additionalAmt * additional)

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


