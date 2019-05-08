package cafe

object Tax {

  def getPayslip(salary: BigDecimal): Payslip = {
    val monthly : BigDecimal => BigDecimal = num => num / 12

    Payslip(
      grossSalary = monthly(salary),
      ni = 159.4,
      allowance = 916.67,
      taxableIncome = 1083.33,
      taxPayable = 216.67)
  }

  private def getNI

}

case class Payslip(id: Int = 12345,
                   name: String = "John J Doe",
                   grossSalary: BigDecimal,
                   ni: BigDecimal,
                   allowance: BigDecimal,
                   taxableIncome: BigDecimal,
                   taxPayable: BigDecimal
                  )


