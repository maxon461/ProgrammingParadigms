let sumProd s e =
  let rec loop n sum prod =
    if n >= e then
      (sum, prod)
    else
      loop (n + 1) (sum + n) (prod * n)
  in
  loop s 0 1
;;

(* Testy *)
let () =
  let (sum, prod) = sumProd 2 6 in
  assert (sum = 2 + 3 + 4 + 5 && prod = 2 * 3 * 4 * 5)
;;
