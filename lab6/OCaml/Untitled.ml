type 'a lmbt = unit -> 'a lnode
and 'a lnode =
  | LLeaf
  | LNode of 'a * 'a lmbt Lazy.t * 'a lmbt Lazy.t

type direction = Left | Right

let memoize f =
  let result = ref None in
  fun () ->
    match !result with
    | Some v -> v
    | None ->
      let v = f () in
      result := Some v;
      v

let rec memoized_lazy_tree : int lmbt =
  memoize (fun () ->
    LNode (
      1,
      lazy (fun () ->
        LNode (
          2,
          lazy (fun () -> LNode (4, lazy (fun () -> LLeaf), lazy (fun () -> LLeaf))),
          lazy (fun () -> LLeaf)
        )
      ),
      lazy (fun () ->
        LNode (
          3,
          lazy (fun () -> LNode (5, lazy (fun () -> LLeaf), lazy (fun () -> LLeaf))),
          lazy (fun () -> LNode (7, lazy (fun () -> LLeaf), lazy (fun () -> LLeaf)))
        )
      )
    )
  )

let rec lttake (lazy_tree : 'a lmbt) (path : direction list) : 'a list =
  let rec traverse tree path =
    match tree () with
    | LLeaf -> []
    | LNode (value, left, right) ->
      match path with
      | [] -> [value]
      | Left :: rest -> value :: traverse (Lazy.force left) rest
      | Right :: rest -> value :: traverse (Lazy.force right) rest
  in
  traverse lazy_tree path
;;

(* Przykładowe użycie *)

let result = lttake memoized_lazy_tree [Right; Left; Right]
