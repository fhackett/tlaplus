------------------------------- CONFIG Debug02 -------------------------------
SPECIFICATION Spec
==================================================================================
------------------------------- MODULE Debug02 -------------------------------
VARIABLE x
Init == x = TRUE
Next == x' =~x
Spec == Init /\ [][Next]_x
==================================================================================