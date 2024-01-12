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

(*Imperative*)
let skipponacciImperacci n m =
  let result = Array.make n 0 in
  let current_n = ref n in

  let  skipponacciHelper n m =
    let num_of_res = int_of_float (2. ** float_of_int (m - 1)) in
    let start = ref (n * num_of_res) in
    let res = ref 0 in
    let num_of_res_ref = ref num_of_res in

    while !num_of_res_ref > 0 do
      res := !res + fib !start;
      start := !start - 1;
      num_of_res_ref := !num_of_res_ref - 1;
    done;

    !res
  in

  while !current_n > 0 do
    result.(n - !current_n) <- skipponacciHelper !current_n m;
    current_n := !current_n - 1;
  done;

  result
;;

(* Test *)
let result2 = skipponacciImperacci 3 3;;



(*modifcation*)

let nth_row_pascal_triangle n =
  let row = Array.make (n + 1) 1 in
  for i = 2 to n do
    for j = i - 1 downto 1 do
      row.(j) <- row.(j) + row.(j - 1)
    done;
  done;
  row


let example_result = nth_row_pascal_triangle 5



















