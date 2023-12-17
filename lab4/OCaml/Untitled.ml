type 'a memoLazyList = unit -> 'a memoLazyNode
and 'a memoLazyNode = Nil | Cons of 'a * 'a memoLazyList

let rec getMemoNth n l =
  let memoRef = ref [] in
  let rec getMemoNthHelper n' l' =
    if n' <= 0 then (List.rev !memoRef, None)
    else
      match l' () with
      | Nil -> (List.rev !memoRef, None)
      | Cons (hd, tl) ->
        if n' = 1 then
          let result = List.rev (hd :: !memoRef), Some hd in
          memoRef := hd :: !memoRef;
          result
        else
        	getMemoNthHelper (n' - 1) tl
  in
  getMemoNthHelper n l

let rec from n = fun () -> Cons (n, from (n+2))

let lazyIntegers = from 4

let test1 = getMemoNth 3 lazyIntegers
let test2 = getMemoNth 10 lazyIntegers
let test4 = getMemoNth 5 lazyIntegers
