val salary = Range(0, 4)

val ZERO = 0
val ELEVEN = 2
val FOUR_THREE = 6
val ADD = 11

val no = Range(ZERO, ELEVEN)
val basic = Range(ELEVEN, FOUR_THREE)
val higher = Range(FOUR_THREE, ADD)
val add = Range(ADD, Int.MaxValue)

def n(salary: Range): Seq[Int] = salary.partition(n => n < ELEVEN)._1
//
def b(salary: Range) = salary.partition(b => (b >= ELEVEN) && (b < FOUR_THREE))._1
//
def h(salary:Range) = salary.partition(h => (h >= FOUR_THREE) && (h < ADD))._1
//
def a(salary:Range) = salary.partition(a => a > ADD)._1

a(salary)
val as = a(salary).size

h(salary)
val ad = h(salary).size

b(salary)
val af = b(salary).size









