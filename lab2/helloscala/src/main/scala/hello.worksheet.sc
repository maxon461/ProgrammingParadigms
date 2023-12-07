def indexSwap[A](a: Int,b: Int)(list: List[A]) : List[A] = {
  def swap(lst: List[A], index: Int, value: A): List[A] = (lst, index) match {
    case (h :: tail, 0) => value :: tail
    case (h :: tail, i) => h :: swap(tail, i - 1, value)
    case (Nil, _) => Nil
  }

  def getElement(list: List[A], idx: Int): A = (list, idx) match {
    case (head :: _, 0) => head
    case (_ :: tail, i) if i > 0 => getElement(tail, i - 1)
  }


  def dlugoscListy[A](lista: List[A]): Int = lista match {
  case Nil => 0
  case _ :: reszta => 1 + dlugoscListy(reszta)
}


  def swapValues(lst: List[A], indexA: Int, indexB: Int): List[A] = {
    if (indexA < 0 || indexA >= dlugoscListy(lst) || indexB < 0 || indexB >= dlugoscListy(lst)) lst
    else {
      val valueA = getElement(lst , indexA) //TODO
      val valueB = getElement(lst , indexB)
      swap(swap(lst, indexA, valueB), indexB, valueA)
    }
  }

  swapValues(list, a, b)
}


// Testy
val list1 = List(1, 2, 3, 4, 5)
val list2 = List(1, 2, 3, 4, 5, 6)

val swapped13 = indexSwap(1,3)
swapped13(list2)




def split3Rec[A](list: List[A]): (List[A], List[A], List[A]) = {
  def splitRec(lst: List[A], first: List[A], second: List[A], third: List[A], count: Int): (List[A], List[A], List[A]) = (lst, count) match {
    case (h :: tail, c) if c < 1  =>
      splitRec(tail, h :: first , second, third, c + 1)
    case (h :: tail, c) if c == 1  =>
      splitRec(tail, first, h::second, third, c + 1)
    case (h :: tail, c) =>
      splitRec(tail, first, second, h::third, c - 2)
    case (Nil, _) =>
      (first, second, third)
  }

  splitRec(list, List(), List(), List(), 0)
}

val myList = List(1, 2, 3, 4, 5, 6, 7, 8, 9 )
val result = split3Rec(myList)





def interleave[A](k:((List[A],Int), List[A])) = {
  val ((list1 , position) , list2) = k;
  def interleaveHelper(lst1: List[A], n: Int, lst2: List[A]): List[A] = 
    (lst1, n, lst2) match {
    case (Nil, _, _) => Nil
    case (_, _, Nil) => Nil 
    case (h :: tail, 0, h2 :: tail2) => h2 :: h :: interleaveHelper(tail, n, tail2)
    case (h :: tail, _, _) => h :: interleaveHelper(tail, n - 1, lst2)
  }

  interleaveHelper(list1, position, list2)
  
}

val exampleInput = ((List(1, 2, 3 , 9 , 11 , 12), 2), List(4, 5, 6))
val result1 = interleave(exampleInput)


def lrepeat[A](k: Int)(lxs: LazyList[A]): LazyList[A] = {
  def repeatHelper(n: Int, elem: A): LazyList[A] =
    if (n <= 0) LazyList.empty
    else elem #:: repeatHelper(n - 1, elem)

  lxs.flatMap(elem => repeatHelper(k, elem))
}

// Examples
val result11 = lrepeat(3)(LazyList('a','b','c','d')).toList
val result2 = lrepeat(3)(LazyList.from(1)).take(15).toList
val result3 = lrepeat(3)(LazyList()).take(15).toList


