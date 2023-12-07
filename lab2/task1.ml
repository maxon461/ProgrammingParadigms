let rec swap lst index value = match lst, index with
  | h :: tail, i when i = 0 -> value :: tail
  | h :: tail, i -> h :: swap tail (i - 1) value
  | [], _ -> []

let rec get_element list idx = match list, idx with
  | head :: _, 0 -> head
  | _ :: tail, i when i > 0 -> get_element tail (i - 1)
  | _ -> failwith "Index out of bounds"  

let rec list_length lista = match lista with
  | [] -> 0
  | _ :: rest -> 1 + list_length rest

let index_swap list a b =
  let rec swap_values lst index_a index_b =
    let length = list_length lst in
    if index_a < 0 || index_a >= length || index_b < 0 || index_b >= length then lst
    else
      let value_a = get_element lst index_a in
      let value_b = get_element lst index_b in
      swap (swap lst index_a value_b) index_b value_a
  in
  swap_values list a b
(* Testy  *)
let list1 = [1; 2; 3; 4; 5]
let list2 = [-1; -2; -3; -4; -5; -6]

let swapped1 = indexSwap list1 1 3
let swapped2 = indexSwap list1 0 4
let swapped3 = indexSwap list2 2 5


let rec split3Rec lst =
  let rec splitRec l first second third count =
    match l, count with
    | h :: tail, c when c < 1 -> splitRec tail (h :: first) second third (c + 1)
    | h :: tail, c when c = 1 -> splitRec tail first (h :: second ) third (c + 1)
    | h :: tail, c -> splitRec tail first second (h :: third) (c - 2)
    | [], _ -> (first, second, third)
  in
  splitRec lst [] [] [] 0

let myList = [1; 2; 3; 4; 5; 6; 7; 8; 9]
let result = split3Rec myList
