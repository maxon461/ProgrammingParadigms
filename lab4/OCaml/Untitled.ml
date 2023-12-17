type 'a tree3 =
  | Empty
  | Node of 'a * 'a tree3 * 'a tree3 * 'a tree3

let rec combine_tree3 tree1 tree2 =
  match (tree1, tree2) with
  | Empty, _ -> Empty 
  | _, Empty -> Empty
  | Node (v1, l1, m1, r1), Node (v2, l2, m2, r2) ->
      Node (
        v1 + v2,
        combine_tree3 l1 l2,
        combine_tree3 m1 m2,
        combine_tree3 r1 r2
          )
 
;;

let tree1 = Node(1, Empty, Node(7,Empty, Empty, Empty), Node(2,Empty, Empty, Empty));;
let tree2 = Node(2, Empty, Node(5,Empty, Empty, Empty), Empty);;
let result = combine_tree3 tree1 tree2 ;;



type file = { name : string }
type folder = { name : string; content : entry list }
and entry = File of file | Folder of folder
  
type disk = { letter : char; content : entry list }

