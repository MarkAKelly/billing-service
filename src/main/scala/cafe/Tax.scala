package cafe

object Tax {

  def getPayslip(salary: BigDecimal): Payslip = {
    val monthly : BigDecimal => BigDecimal = num => num / 12

    Payslip(
      grossSalary = monthly(salary),
      ni = 1,
      allowance = 1,
      taxableIncome = 1,
      taxPayable = 1)
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


