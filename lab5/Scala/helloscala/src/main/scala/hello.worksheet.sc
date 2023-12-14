def sublistsL[A](list: LazyList[A]): LazyList[List[A]] = {
  def sublistsHelper(prefix: LazyList[A], suffix: LazyList[A]): LazyList[List[A]] = {
    if (suffix.isEmpty) LazyList.empty
    else (prefix ++ suffix.take(1)).toList #:: sublistsHelper(prefix ++ suffix.take(1), suffix.drop(1))
  }

  sublistsHelper(LazyList.empty, list)
}

// Przykładowe użycie
val inputList: LazyList[Int] = LazyList(1, 2, 3, 4, 5)
val result: LazyList[List[Int]] = sublistsL(inputList)

result.take(5).foreach(sublist => println(sublist))


val nums: LazyList[Int] = {println("e1"); 1} #:: nums.map(n => {println("e"+(n+1)); n+1})
nums.take(3).toList
// nums.take(6).toList