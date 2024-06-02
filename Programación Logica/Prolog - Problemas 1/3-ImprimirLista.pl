/*PROBLEMAS PARTE 1 - EJERCICIO 3*/
/*David Barrios - C.I: 25.721.785*/

/*Reglas*/
/*Imprime lista de forma vertical*/

imprime([]).
imprime([H|T]):-write_ln(H),
               imprime(T).
