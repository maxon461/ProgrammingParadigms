id: file://<WORKSPACE>/Scala/helloscala/src/main/scala/hello.worksheet.sc:[1075..1078) in Input.VirtualFile("file://<WORKSPACE>/Scala/helloscala/src/main/scala/hello.worksheet.sc", "sealed trait Tree3[+A]
case object Empty extends Tree3[Nothing]
case class Node[A](elem: A, left: Tree3[A], middle: Tree3[A], right: Tree3[A]) extends Tree3[A]

def 


// def combineTree3[A, B](f: (Tree3[A] , Tree3[A]) => B)(tree1: Tree3[A])(tree2: Tree3[A]): Tree3[B] = {
//   (tree1, tree2) match {
//     case (Node(v1, l1, m1, r1), Node(v2, l2, m2, r2)) =>
//       Node(
//         f(Node(v1, Empty, Empty, Empty), Node(v2, Empty, Empty, Empty)),
//         combineTree3(f)(l1)(l2),
//         combineTree3(f)(m1)(m2),
//         combineTree3(f)(r1)(r2)
//       )
//     case (Empty, _) => tree2.asInstanceOf[Tree3[B]]
//     case (_, Empty) => tree1.asInstanceOf[Tree3[B]]
//   }
// }

// val tree1: Tree3[Int] = Node(1, Node(2, Empty, Empty, Empty), Node(3, Empty, Empty, Empty), Empty)
// val tree2: Tree3[Int] = Node(4, Node(5, Empty, Empty, Empty), Node(6, Empty, Empty, Empty), Empty)

// val combinedTree: Tree3[Int] = combineTree3((a, b) => a.elem + b.elem)(tree1)(tree2)
// Result: Node(5, Node(7, Empty, Empty, Empty), Node(9, Empty, Empty, Empty), Empty)



def combineTree3[A](tree1: Tree3[A])(tree2: Tree3[A]): Tree3[A] = {
  (tree1, tree2) match {
    case (Node(v1, l1, m1, r1), Node(v2, l2, m2, r2)) =>
       
      Node(
        v1 + v2,
        combineTree3(l1)(l2),
        combineTree3(m1)(m2),
        combineTree3(r1)(r2)
      )
    case (Empty, _) => tree2.asInstanceOf[Tree3[A]]
    case (_, Empty) => tree1.asInstanceOf[Tree3[A]]
  }
}

val tree1: Tree3[Int] = Node(1, Node(2, Empty, Empty, Empty), Node(3, Empty, Empty, Empty), Empty)
val tree2: Tree3[Int] = Node(4, Node(5, Empty, Empty, Empty), Node(6, Empty, Empty, Empty), Empty)

val combinedTree: Tree3[Int] = combineTree3(tree1)(tree2)")
file://<WORKSPACE>/Scala/helloscala/src/main/scala/hello.worksheet.sc
file://<WORKSPACE>/Scala/helloscala/src/main/scala/hello.worksheet.sc:30: error: expected identifier; obtained def
def combineTree3[A](tree1: Tree3[A])(tree2: Tree3[A]): Tree3[A] = {
^
#### Short summary: 

expected identifier; obtained def