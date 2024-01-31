module type Comparable = sig
  type t
  val compare : t -> t -> int
end

module PriorityQueueList (C : Comparable) = struct
  type element = C.t
  type queue = element list

  let empty = []

  let rec insert x = function
    | [] -> [x]
    | hd :: tl ->
      if C.compare x hd <= 0 then x :: hd :: tl
      else hd :: insert x tl

  let rec delete_min = function
    | [] -> failwith "Empty queue"
    | [_] as q -> q, List.hd q
    | hd :: tl -> let rest, min_val = delete_min tl in hd :: rest, min_val
end

module IntComparable = struct
  type t = int
  let compare a b = a - b
end

module IntPriorityQueue = PriorityQueueList(IntComparable)



let () =
  let pq = IntPriorityQueue.empty in
  let pq = IntPriorityQueue.insert 3 pq in
  let pq = IntPriorityQueue.insert 1 pq in
  let pq = IntPriorityQueue.insert 4 pq in
  let pq = IntPriorityQueue.insert 2 pq in
  let pq, min_val = IntPriorityQueue.delete_min pq in
  Printf.printf "Usunięto element o najniższym priorytecie: %d\n" min_val;;