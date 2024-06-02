/*PROBLEMAS PARTE 1 - EJERCICIO 9*/
/*David Barrios - C.I: 25.721.785*/

/*Reglas*/

primero([H|_],H).
ordenada([]).
ordenada([_]).
ordenada([H|T]):- primero(T,X),(H @< X), ordenada(T).
