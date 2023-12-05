let isPerfect n =
  let rec sum_divisors divisor sum =
    if divisor <= 0 then
      sum
    else if n mod divisor = 0 then
      sum_divisors (divisor - 1) (sum + divisor)
    else
      sum_divisors (divisor - 1) sum
  in
  let div_sum = sum_divisors (n - 1) 0 in
  div_sum = n
;;


let () =
  assert (isPerfect 6);
  assert (not (isPerfect 28));
  assert (not (isPerfect 12));
  assert (isPerfect 8128);
  assert (not (isPerfect 7));
;;
