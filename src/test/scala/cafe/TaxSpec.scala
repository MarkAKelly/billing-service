package cafe

import org.scalatest.{Matchers, WordSpec}

class TaxSpec extends WordSpec with Matchers {

  "The monthly payslip for an employee with a salary of £24,000" should {

    val ANNUAL_SALARY: Int = 24000

    val payslip = Tax.getPayslip(ANNUAL_SALARY)

    "have a the ID 12345" in {
      payslip.id shouldBe 12345
    }

    "have the name John J Doe" in {
      payslip.name shouldBe "John J Doe"
    }

    "have the gross salary of 2000.00" in {
      payslip.grossSalary shouldBe 2000.00
    }

    "have the NI contribution of 159.40" in {

    }

    "have a tax free allowance of 916.67" in {

    }

    "have a taxable income of 1083.33" in {

    }

    "have tax payable of 216.67" in {

    }
  }
}
