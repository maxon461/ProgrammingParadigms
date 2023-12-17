type 'a memoLazyList = unit -> 'a memoLazyNode
and 'a memoLazyNode = Nil | Cons of 'a * 'a memoLazyList

type 'a memoResult = {
  elements: 'a list;
  result: 'a option;
}

let rec getMemoNth n l =
  let elementsRef = ref [] in
  let memoRef = ref [] in
  let rec getMemoNthHelper n' l' =
    if n' <= 0 then ({ elements = List.rev !elementsRef; result = None })
    else
      match l' () with
      | Nil -> ({ elements = List.rev !elementsRef; result = None })
      | Cons (hd, tl) ->
        if n' = 1 then
          let result = { elements = List.rev (hd :: !elementsRef); result = Some hd } in
          elementsRef := hd :: !elementsRef;
          memoRef := result :: !memoRef;
          result
        else
          let result = getMemoNthHelper (n' - 1) tl in
          elementsRef := hd :: result.elements;
          { result with elements = List.rev !elementsRef }
  in
  let { elements; result } = getMemoNthHelper n l in
  ({ elements = elements; result = result }, List.rev !memoRef)

let rec from n = fun () -> Cons (n, from (n + 2))

let lazyIntegers = from 4

let test1, _ = getMemoNth 3 lazyIntegers
let test2, _ = getMemoNth 10 lazyIntegers
let test4, _ = getMemoNth 5 lazyIntegers
