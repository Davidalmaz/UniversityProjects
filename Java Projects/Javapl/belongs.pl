belongs([X|_], X).
belongs([_|L], X) :- belongs(L, X).