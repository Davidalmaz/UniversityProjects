/*PROBLEMAS PARTE 1 - EJERCICIO 8*/
/*David Barrios - C.I: 25.721.785*/

/*Reglas*/

sacar(X,[X|R],R).
sacar(X,[F |R],[F|S]) :- sacar(X,R,S).

permutacion([],[]).
permutacion([X|Y],Z) :- permutacion(Y,W), sacar(X,Z,W).
