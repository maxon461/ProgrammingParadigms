def skipponacciDeclaracci(n: Int, m: Int): List[Int] = {
  def fib(n: Int): Int = {
    if (n <= 2) 1
    else fib(n - 1) + fib(n - 2)
  }

  def skipponacciHelper(n: Int, m: Int): Int = {
    (n, m) match {
      case (1, 1) => 1
      case (_, 1) => fib(n)
      case (_, _) => skipponacciHelper(2 * n - 1, m - 1) + skipponacciHelper(2 * n, m - 1)
    }
  }

  def skipD(n: Int, m: Int, acc: List[Int]): List[Int] = {
    if (n != 0) {
      skipD(n - 1, m, skipponacciHelper(n, m) +: acc)
    } else acc
  }

  skipD(n, m, Nil).reverse
}


// Testy

val result1 = skipponacciDeclaracci(3, 3)
// assert(result1 == List(1, 1, 2, 3, 5), s"Expected List(1, 1, 2, 3, 5), but got $result1")

// val result2 = skipponacciDeclaracci(6, 2)
// assert(result2 == List(1, 1, 5, 7, 12, 20), s"Expected List(1, 1, 5, 7, 12, 20), but got $result2")
