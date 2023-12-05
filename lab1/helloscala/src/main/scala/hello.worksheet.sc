println("Hello, world!")
   
def reverse4[A, B, C, D](tuple: (A, B, C, D)): (D, C, B, A) = {
  val (a, b, c, d) = tuple
  (d, c, b, a)
}

val tuple1 = (1, 2, 3, 4)
val reversed1 = reverse4(tuple1)
assert (reversed1 == (4, 3, 2, 1));

def sumProd(s: Int, e: Int): (Int, Int) = {
  def loop(n: Int, sum: Int, prod: Int): (Int, Int) = {
    if (n >= e) {
      (sum, prod)
    } else {
      loop(n + 1, sum + n, prod * n)
    }
  }

  loop(s, 0, 1)
}

// Testy
val (sum1, prod1) = sumProd(2, 6)
assert(sum1 == 2 + 3 + 4 + 5)
assert(prod1 == 2 * 3 * 4 * 5)

val (sum2, prod2) = sumProd(1, 5)
assert(sum2 == 1 + 2 + 3 + 4)
assert(prod2 == 1 * 2 * 3 * 4)

def isPerfect(n: Int): Boolean = {
  def sumDivisors(divisor: Int, sum: Int): Int = {
    if (divisor <= 0) sum
    else if (n % divisor == 0) sumDivisors(divisor - 1, sum + divisor)
    else sumDivisors(divisor - 1, sum)
  }

  val divSum = sumDivisors(n - 1, 0)
  divSum == n
}

// Testy
assert(isPerfect(6))
assert(isPerfect(8128))
assert(!isPerfect(7))



def insert(lista: List[Int], element: Int, pozycja: Int): List[Int] = {
  if (pozycja <= 0) {
    element :: lista
  } else {
    if (lista == Nil) {
      List(element)
    } else {
      val head = lista.head
      val tail = lista.tail
      head :: insert(tail, element, pozycja - 1)
    }
  }
}

val myList = List[Int](1, 2, 3, 4, 5)
val newE = 99
val pos = 2
val nowaLista = insert(myList, newE, pos)


def select(list: List[List[Int]], indexList: List[Int]): List[Int] = {
  def selectElement(sublist: List[Int], index: Int): List[Int] = {
    if (index < 0) {
      List()
    } else if (sublist.isEmpty) {
      List()
    } else if (index == 0) {
      List(sublist.head)
    } else {
      selectElement(sublist.tail, index - 1)
    }
  }

  if (list.isEmpty || indexList.isEmpty) {
    Nil
  } else {
    val temp = list.head
    val tempi = indexList.head

    if (tempi >= 0 ) {
      val selected = selectElement(temp, tempi)
      
      selected.head :: select(list.tail, indexList.tail)
    } else {
      select(list.tail, indexList.tail)
    }
  }
}



  val res = select(List(List(1,5,3,8) , List(2,7,4,1) , List(3,6,4,3)) , List(1,3,0) )





