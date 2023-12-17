def composites(n: Int): List[Int] = {
  def isComposite(num: Int): Boolean = {
    val range = List.range(2, num-1)
    for (i <- range) {
      if (num % i == 0) {
        return false
      }
    }
    true
  }

  (for {
    num <- List.range(2, n + 1)
    if isComposite(num)
  } yield num).toList
}

val test1 = composites(10) 
val test2 = composites(20) 
val test3 = composites(5) 

