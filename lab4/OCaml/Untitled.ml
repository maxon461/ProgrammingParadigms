type 'a tree3 = Empty | Node of 'a * 'a tree3 * 'a tree3 * 'a tree3


let emptyTree3 = Empty


let rec combineTree3 f tree1 tree2 =
  match (tree1, tree2) with
  | (Empty, Empty) -> Empty
  | (Node (v1, l1, m1, r1), Empty) -> Empty
  | (Empty, Node (v2, l2, m2, r2)) -> Empty
  | (Node (v1, l1, m1, r1), Node (v2, l2, m2, r2)) ->
      Node (f v1 v2, combineTree3 f l1 l2, combineTree3 f m1 m2, combineTree3 f r1 r2)


let treeA = Node (1, Node (2, Empty, Empty, Empty), Node (3, Empty, Empty, Empty), Empty)
let treeB = Node (4, Node (5, Empty, Empty, Empty), Node (6, Empty, Empty, Empty), Node (7, Empty, Empty, Empty))


let resultTreeAB = combineTree3 (fun x y -> x + y) treeA treeB



type disk = { letter: char; contents: item list }
and file = { name: string }
and folder = { name: string; contents: item list }
and item = File of file | Folder of folder


let exampleDisk = 
  { letter='C'; contents=[
    File {name="document.txt"};
    Folder {name="Images"; contents=[
      File {name="image1.jpg"};
      File {name="image2.png"}
    ]};
    Folder {name="Documents"; contents=[
      File {name="report.pdf"};
      Folder {name="Research"; contents=[
        File {name="paper1.docx"};
        File {name="paper2.docx"}
      ]}
    ]}
  ]}