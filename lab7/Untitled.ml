module type COMPARATOR = sig
  
  type comparison_result
  type comparable_type
  val compare : comparable_type -> comparable_type -> comparison_result
end
(*module definicion*)
module IntComparator : COMPARATOR with type comparison_result = string
                                   and type comparable_type = int = struct
  type comparison_result = string
  type comparable_type = int

  let compare x y = if x < y then "Less" else if x = y then "Equal" else "Greater"
end

(** Module implementing string comparator *)
module StringComparator : COMPARATOR with type comparison_result = int
                                      and type comparable_type = string = struct
  type comparison_result = int
  type comparable_type = string

  let compare x y = String.compare x y (*String is also module with comapre func*)
end


let result_int = IntComparator.compare 10 5;;


let result_string = StringComparator.compare "apple" "orange";;

(*TODO functors*)
module PriorityQueueImpl : sig
  type 'a priority_queue
  val create : unit -> 'a priority_queue
  val is_empty : 'a priority_queue -> bool
  val insert : 'a priority_queue -> 'a -> 'a priority_queue
  val retrieve : 'a priority_queue -> 'a option
end = struct
  type 'a priority_queue = Empty | Node of 'a * 'a priority_queue * 'a priority_queue

  let create () = Empty

  let is_empty pq =
    match pq with
    | Empty -> true
    | _ -> false

  let rec insert pq elem =
    match pq with
    | Empty -> Node (elem, Empty, Empty)
    | Node (value, left, right) ->
      if elem > value then
        Node (elem, insert right value, left)
      else
        Node (value, insert right elem, left)

  let retrieve pq =
    match pq with
    | Empty -> None
    | Node (value, _, _) -> Some value
end

module IntPriorityQueue = PriorityQueueImpl

let pq = IntPriorityQueue.create () ;;
let pq = IntPriorityQueue.insert pq 5 ;;
let pq = IntPriorityQueue.insert pq 2 ;;
let pq = IntPriorityQueue.insert pq 8 ;;

let top_element = IntPriorityQueue.retrieve pq ;;


module PriorityQueue : sig
  type 'a t
  val create : unit -> 'a t
  val is_empty : 'a t -> bool
  val insert : 'a t -> 'a -> 'a t
  val retrieve : 'a t -> 'a option
end = struct
  type 'a t = 'a PriorityQueueImpl.priority_queue

  let create () = PriorityQueueImpl.create ()

  let is_empty pq = PriorityQueueImpl.is_empty pq

  let insert pq elem = PriorityQueueImpl.insert pq elem

  let retrieve pq = PriorityQueueImpl.retrieve pq
end
