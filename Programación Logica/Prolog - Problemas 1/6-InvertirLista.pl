/*PROBLEMAS PARTE 1 - EJERCICIO 6*/
/*David Barrios - C.I: 25.721.785*/

/*Regla*/

agregar_final([],X,[X]).
agregar_final([H|T],X,[H|L]):-agregar_final(T,X,L).

de_reversa([],_).
de_reversa([X|Y],L):- agregar_final(M,X,L), de_reversa(Y,M).

