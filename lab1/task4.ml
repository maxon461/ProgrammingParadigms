let rec insert lista element pozycja =
  if pozycja <= 0 then element :: lista
  else if lista = [] then [element]
  else
    let hd = List.hd lista in
    let tl = List.tl lista in
    hd :: (insert tl element (pozycja - 1))


let moja_lista = [1; 2; 3; 4; 5]
let nowy_element = 99
let pozycja = 3
let nowa_lista = insert moja_lista nowy_element pozycja
