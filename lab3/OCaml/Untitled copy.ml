let increment x = x + 1;;

let (<<) f n x =
  List.map (fun i -> f (List.fold_left (fun acc _ -> acc x) x (List.init i (fun j -> j)))) (List.init n (fun i -> i))

