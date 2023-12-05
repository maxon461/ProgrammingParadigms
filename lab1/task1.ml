let reverse4 (a, b, c, d) =
  let swapped = (d, c, b, a) in
  swapped
;;

(* Testy *)
let () =
  let input = (1, 2, 3, 4) in
  let result = reverse4 input in
  assert (result = (4, 3, 2, 1));
  ;;
