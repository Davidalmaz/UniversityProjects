/*PROBLEMAS PARTE 1 - EJERCICIO 5*/
/*David Barrios - C.I: 25.721.785*/


agregar_final([],X,[X]).
agregar_final([H|T],X,[H|L]):-agregar_final(T,X,L).
