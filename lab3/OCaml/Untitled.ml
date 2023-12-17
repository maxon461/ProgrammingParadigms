let rec (<<) f n =
  let rec generate_list acc x n =
    if n < 0 then
      acc
    else
      generate_list (x :: acc) (f x) (n - 1)
  in
  generate_list [] n n
;;



let test1 = (fun x -> x * x) << 3 
let test2 = (fun x -> x + 1) << 4 


