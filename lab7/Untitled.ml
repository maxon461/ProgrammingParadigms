module type COMPARATOR = sig
  
  type comparison_result
  type comparable_type
  val compare : comparable_type -> comparable_type -> comparison_result
end
(*module definicion*)
module IntComparator : COMPARATOR with type comparison_result = int
                                   and type comparable_type = int = struct
  type comparison_result = int
  type comparable_type = int

  let compare x y = Int.compare x y
end

(** Module implementing string comparator *)
module StringComparator : COMPARATOR with type comparison_result = int
                                      and type comparable_type = string = struct
  type comparison_result = int
  type comparable_type = string

  let compare x y = String.compare x y (*String is also module with compare func*)
end


let result_int = IntComparator.compare 10 5;;


let result_string = StringComparator.compare "apple" "orange";;

(* Parametric PriorityQueue module *)
(* Parametric PriorityQueue module *)
module PriorityQueueImpl (C : COMPARATOR with type comparison_result = int
                                      and type comparable_type = int) = struct
  type comparison_result = int
  type comparable_type = int
  let compare x y = Int.compare x y
  type priority_queue = C.comparable_type list

  let create () = []

  let rec insert element pq =
    match pq with
    | [] -> [element]
    | hd :: tl ->
      if C.compare element hd <= 0 then element :: pq
      else hd :: insert element tl

  let retrieve = function
    | [] -> None
    | hd :: _ -> hd
end

(* Example usage *)
(* Example usage *)
let () =
  let module IntPriorityQueue = PriorityQueueImpl(IntComparator) in
  let queue = IntPriorityQueue.create () in
  let queue = IntPriorityQueue.insert 3 queue in
  let queue = IntPriorityQueue.insert 1 queue in
  let queue = IntPriorityQueue.insert 2 queue in
  let queue = IntPriorityQueue.insert 2 queue in
  let queue = IntPriorityQueue.insert 2 queue in
  let queue = IntPriorityQueue.insert 2 queue in
  let queue = IntPriorityQueue.insert 2 queue in
  let queue = IntPriorityQueue.insert 2 queue in
  let result = IntPriorityQueue.retrieve queue in
  Printf.printf "Priority queue test result: %d\n" result

