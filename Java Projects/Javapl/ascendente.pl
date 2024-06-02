ascendente([X|L]) :- ascendente(X, L).
ascendente(X, [Y|L]) :- X < Y, ascendente(Y, L).
ascendente(_, []).

descendente([X|L]) :- recur(X, L).
recur(X, [Y|L]) :- X > Y, recur(Y, L).
recur(_,[]).