let rec (<<) f n =
  if n < 0 then (fun _ -> [])
  else if n = 0 then (fun x -> [x])
  else (fun x -> x :: (f << (n-1)) (f x))
;;

(* Testy *)
let test1 = ((( * ) 2) << 3) 
let res1 = test1 2
let test2 = ((fun x -> x + 1) << 4) 
let res2 = test2 0

(*		(fun x -> x * 2) << 3: Wywołuje operator << z funkcją f i n.
*)