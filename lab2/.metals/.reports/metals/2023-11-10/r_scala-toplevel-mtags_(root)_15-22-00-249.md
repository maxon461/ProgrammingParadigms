id: file://<WORKSPACE>/helloscala/src/main/scala/hello.worksheet.sc:[1484..1484) in Input.VirtualFile("file://<WORKSPACE>/helloscala/src/main/scala/hello.worksheet.sc", "def indexSwap[A](list: List[A], a: Int, b: Int): List[A] = {
  def swap(lst: List[A], index: Int, value: A): List[A] = (lst, index) match {
    case (h :: tail, i) if i == 0 => value :: tail
    case (h :: tail, i) => h :: swap(tail, i - 1, value)
    case (Nil, _) => Nil
  }

  def swapValues(lst: List[A], indexA: Int, indexB: Int): List[A] = {
    if (indexA < 0 || indexA >= lst.length || indexB < 0 || indexB >= lst.length) lst
    else {
      val valueA = lst(indexA)
      val valueB = lst(indexB)
      swap(swap(lst, indexA, valueB), indexB, valueA)
    }
  }

  swapValues(list, a, b)
}


// Testy
val list1 = List(1, 2, 3, 4, 5)
val list2 = List(1, 2, 3, 4, 5, 6)

val swapped1 = indexSwap(list1, 1, 3)
val swapped2 = indexSwap(list1, 0, 4)
val swapped3 = indexSwap(list2, 2, 5)




def split3Rec[A](list: List[A]): (List[A], List[A], List[A]) = {
  def splitRec(lst: List[A], first: List[A], second: List[A], third: List[A], count: Int): (List[A], List[A], List[A]) = (lst, count) match {
    case (h :: tail, c) if c < 1  =>
      splitRec(tail, first :+ h, second, third, c + 1)
    case (h :: tail, c) if c == 1  =>
      splitRec(tail, first, second :+ h, third, c + 1)
    case (h :: tail, c) =>
      splitRec(tail, first, second, third :+ h, c - 2)
    case (Nil, _) =>
      (first, second, third)
  }

  splitRec(list, List(), List(), List(), 0)
}

val myList = List(1, 2, 3, 4, 5, 6, 7, 8, 9 )
val result = split3Rec(myList)

def


// [x1,x2,...,y1,xn,y2,xn+1]")
file://<WORKSPACE>/helloscala/src/main/scala/hello.worksheet.sc
file://<WORKSPACE>/helloscala/src/main/scala/hello.worksheet.sc:53: error: expected identifier; obtained eof
// [x1,x2,...,y1,xn,y2,xn+1]
                            ^
#### Short summary: 

expected identifier; obtained eof