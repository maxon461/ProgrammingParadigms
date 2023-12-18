let (<<) f n =
  let generate_list x =
    let rec iterate acc i =
      if i < 0 then
        acc
      else
        iterate (List.map f (x :: acc)) (i - 1)
    in
    iterate [] n
  in
  List.rev (generate_list n)
;;

(* 
let (<<) f n =
  let rec generate_list_using_map x i =
    if i < 0 then []
    else List.map f (generate_list_using_map x (i - 1)) @ [x]
  in
  List.rev (generate_list_using_map n n)
;;
*)

let test1 = (fun x -> x * x) << 3 
let test2 = (fun x -> x + 1) << 4 

