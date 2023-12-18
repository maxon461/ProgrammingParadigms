import scala.compiletime.ops.boolean
// import pprint.Tree
sealed trait Tree3[+A]
case object Empty extends Tree3[Nothing]
case class Node[A](elem: A, left: Tree3[A], middle: Tree3[A], right: Tree3[A]) extends Tree3[A]


sealed trait Resource
case class File(name: String) extends Resource
case class Folder(name: String, content: List[Resource]) extends Resource

case class Disk(driveLetter: String, rootFolder: Folder)

def path(target: String, disk: Disk): Option[String] = {
  def pathAux(currentFolder: Folder, currentPath: String): Option[String] = {
    currentFolder.content.find {
      case File(name) => name == target
      case _: Folder => false
    } match {
      case Some(File(name)) => Some(currentPath + name)
      case Some(folder: Folder) => pathAux(folder, currentPath + folder.name + "/")
      case None =>
        currentFolder.content.foldLeft(None: Option[String]) { //result init 
          case (result, folder: Folder) =>
            result.orElse(pathAux(folder, currentPath + folder.name + "/"))
          case (result, _) => result
        }
    }
  }

  pathAux(disk.rootFolder, disk.driveLetter)
}

val file1 = File("file1.txt")
val file2 = File("file2.txt")
val file3 = File("file3.txt")
val folder1 = Folder("folder1", List(file1))
val folder2 = Folder("folder2", List(file2, file3))
val rootFolder = Folder("root", List(folder1, folder2))
val disk1 = Disk("C:/", rootFolder)

val target = "file2.txt"
val result = path(target, disk1)


// def remove(disk: Disk , )

def remove(disk: Disk, path: List[String]): (Disk, Boolean) = {
  def removeAux(currentFolder: Folder, currentPath: List[String]): (Folder, Boolean) = {
    currentPath match {
      case Nil =>
        (currentFolder, false) // Nie znaleziono zasobu do usunięcia
      case name :: Nil =>
        val (newContent, found) = currentFolder.content.partition {
          case File(fileName)  => fileName != name
          case Folder(foldername, content) => foldername != name
        }
        (Folder(currentFolder.name, newContent), found.nonEmpty)
      case name :: rest =>
        currentFolder.content.collectFirst {
          case folder: Folder if folder.name == name => folder
        } match {
          
        }
    }
  }

  val (newRootFolder, removed) = removeAux(disk.rootFolder, path)

  if (removed) {
    (Disk(disk.driveLetter, newRootFolder), true)
  } else {
    (disk, false)
  }
}

val disk = Disk("C:", Folder("root", List(
  File("file1.txt"),
  Folder("folder1", List(
    File("file2.txt"),
    File("file3.txt")
  )),
  Folder("folder2", List(
    File("file4.txt"),
    Folder("subfolder1", List(
      File("file5.txt")
    ))
  ))
)))

val (newDisk, removed) = remove(disk, List("folder1", "file2.txt"))
if (removed) {
  println("Plik został pomyślnie usunięty.")
} else {
  println("Wystąpił błąd podczas usuwania pliku.")
}


