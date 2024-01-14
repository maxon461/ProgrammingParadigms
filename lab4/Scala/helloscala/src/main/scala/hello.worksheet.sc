// import scala.compiletime.ops.boolean
// import pprint.Tree
sealed trait Tree3[+A]
case object EmptyTree3 extends Tree3[Nothing]
case class Node[A](value: A, left: Tree3[A], middle: Tree3[A], right: Tree3[A]) extends Tree3[A]

// Puste drzewo trójkowe
val emptyTree3: Tree3[Nothing] = EmptyTree3

// Przykład drzewa trójkowego
val exampleTree3: Tree3[Int] = Node(1, Node(2, EmptyTree3, EmptyTree3, EmptyTree3), Node(3, EmptyTree3, EmptyTree3, EmptyTree3), EmptyTree3)


sealed trait Resource
case class File(name: String) extends Resource
case class Folder(name: String, content: List[Resource]) extends Resource

case class Disk(driveLetter: String, rootFolder: Folder)
