id: file://<WORKSPACE>/Scala/helloscala/src/main/scala/hello.worksheet.sc:[2186..2188) in Input.VirtualFile("file://<WORKSPACE>/Scala/helloscala/src/main/scala/hello.worksheet.sc", "// import pprint.Tree
sealed trait Tree3[+A]
case object Empty extends Tree3[Nothing]
case class Node[A](elem: A, left: Tree3[A], middle: Tree3[A], right: Tree3[A]) extends Tree3[A]


// def combineTree3[A](tree1: Tree3[A])(tree2: Tree3[A]): Tree3[A] = {
//   (tree1, tree2) match {
//     case (Node(v1, l1, m1, r1), Node(v2, l2, m2, r2)) =>
       
//       Node(
//         v1 + v2, //.elem
//         combineTree3(l1)(l2),
//         combineTree3(m1)(m2),
//         combineTree3(r1)(r2)
//       )
//     case (Empty, _) => tree2.asInstanceOf[Tree3[A]]
//     case (_, Empty) => tree1.asInstanceOf[Tree3[A]]
//   }
// }

// val tree1: Tree3[Int] = Node(1, Node(2, Empty, Empty, Empty), Node(3, Empty, Empty, Empty), Empty)
// val tree2: Tree3[Int] = Node(4, Node(5, Empty, Empty, Empty), Node(6, Empty, Empty, Empty), Empty)

// val combinedTree: Tree3[Int] = combineTree3(tree1)(tree2)



case class File(name: String)

case class Folder(name: String, content: (List[File], List[Folder]))

case class Disk(letter: Char, content: (List[File], List[Folder]))




// def findItemPath(itemName: String, folder: Folder, currentPath: String): Option[String] = {
//   val folderPath = currentPath + folder.folderName + "/"
//   val path = folderPath + itemName
//   folder.contents.collectFirst {
//     case Folder(subfolder) => findItemPath(itemName, subfolder, folderPath)
//     case File(file) if file.fileName == itemName => path
//   }.getOrElse(folderPath)
// }

// def path(disk: Disk, itemName: String): Option[String] = {
//   disk.contents.collectFirst {
//     case Folder(folder) => findItemPath(itemName, folder, "")
//     case File(file) if file.fileName == itemName => "/" + itemName
//   }.map(p => disk.diskName + ":/" + p)
// }

// val exampleDisk = Disk('C', List(Folder("Program Files", List(File("file.txt")))))

// val resultPath = path(exampleDisk, "file.txt")

let rec combine_tree3 tree1 tree2 =
  match (tree1, tree2) with
  | Node (v1, l1, m1, r1), Node (v2, l2, m2, r2) ->
      Node (
        v1 + v2,
        combine_tree3 l1 l2,
        combine_tree3 m1 m2,
        combine_tree3 r1 r2
      		)
 
  | Empty, _ -> tree2
  | _, Empty -> tree1
;;



type 'a tree3 =
  | Empty
  | Node of 'a * 'a tree3 * 'a tree3 * 'a tree3

let rec combine_tree3 tree1 tree2 =
  match (tree1, tree2) with
  | Empty, _ -> tree2
  | _, Empty -> tree1
  | Node (v1, l1, m1, r1), Node (v2, l2, m2, r2) ->
      Node (
        v1 + v2,
        combine_tree3 l1 l2,
        combine_tree3 m1 m2,
        combine_tree3 r1 r2
          )
 
;;

let tree1 = Node(1, Empty, Empty, Empty);;
let tree2 = Node(2, Empty, Empty, Empty);;
let result = combine_tree3 tree1 tree2 ;;


")
file://<WORKSPACE>/Scala/helloscala/src/main/scala/hello.worksheet.sc
file://<WORKSPACE>/Scala/helloscala/src/main/scala/hello.worksheet.sc:74: error: expected identifier; obtained symbollit
type 'a tree3 =
     ^
#### Short summary: 

expected identifier; obtained symbollit