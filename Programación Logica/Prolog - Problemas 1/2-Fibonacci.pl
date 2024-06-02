/*PROBLEMAS PARTE 1 - EJERCICIO 2*/
/*David Barrios - C.I: 25.721.785*/

/*Reglas*/

fibonacci(0,0).
fibonacci(1,1).
fibonacci(N,F):-N1 is N-1, N2 is N1-1,
                fibonacci(N1,A),
                fibonacci(N2,B),
                F is A+B.
