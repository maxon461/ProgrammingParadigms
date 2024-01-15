
sealed trait Tree3[+A] //dla podtypu
case object EmptyTree3 extends Tree3[Nothing]
case class Node[A](value: A, left: Tree3[A], middle: Tree3[A], right: Tree3[A]) extends Tree3[A]

val emptyTree3: Tree3[Nothing] = EmptyTree3


val exampleTree3: Tree3[Int] = Node(1, Node(2, EmptyTree3, EmptyTree3, EmptyTree3), Node(3, EmptyTree3, EmptyTree3, EmptyTree3), EmptyTree3)


case class Disk(letter: Char, contents: List[Item])
sealed trait Item
case class File(name: String) extends Item
case class Folder(name: String, contents: List[Item]) extends Item

val exampleDisk: Disk = 
  Disk('C', List(
    File("document.txt"),
    Folder("Images", List(
      File("image1.jpg"),
      File("image2.png")
    )),
    Folder("Documents", List(
      File("report.pdf"),
      Folder("Research", List(
        File("paper1.docx"),
        File("paper2.docx")
      ))
    ))
  ))