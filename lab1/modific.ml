let rec select_element sublist index =
  if index < 0 then []
  else if sublist = [] then []
  else if index = 0 then [List.hd sublist]
  else select_element (List.tl sublist) (index - 1)

let rec select list_of_lists index_list =
  if list_of_lists = [] || index_list = [] then []
  else
    let sublist = List.hd list_of_lists in
    let index = List.hd index_list in
    let tempi = index in
    if tempi >= 0 
     then
      let selected = select_element sublist tempi in
      selected ::  select (List.tl list_of_lists) (List.tl index_list)
    else
      select (List.tl list_of_lists) (List.tl index_list)
;;

let res = select [ [1;5;3;8]; [2;7;4;1] ] [3;2];;
