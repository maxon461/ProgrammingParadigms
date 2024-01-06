let rec fib n =
  if n <= 2 then 1
  else fib (n - 1) + fib (n - 2)

let rec skipponacciHelper n m =
  match (n, m) with
  | (1, 1) -> 1
  | (_, 1) -> fib n
  | (_, _) -> skipponacciHelper (2 * n - 1) (m - 1) + skipponacciHelper (2 * n) (m - 1)

let rec skipD n m acc =
  if n != 0 then
    skipD (n - 1) m ((skipponacciHelper n m) :: acc)
  else
    acc

let skipponacciDeclaracci n m =
  List.rev (skipD n m [])

(* Testy *)
let result1 = skipponacciDeclaracci 3 3;;
