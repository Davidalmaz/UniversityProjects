/*PROBLEMAS PARTE 1 - EJERCICIO 7*/
/*David Barrios - C.I: 25.721.785*/

/*Reglas*/ 

ultimo([X],X).
ultimo([_|Y],X):- ultimo(Y,X).
