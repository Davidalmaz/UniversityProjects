/*PROBLEMAS PARTE 2 - EJERCICIO 3*/
/*David Barrios - C.I: 25.721.785*/

/*Base de Conocimientos - Familia Tudor*/

padre(enrique7,enrique8).
padre(enrique7,arturo).
padre(enrique7,margarita).
madre(isabeldeyork,enrique8).
madre(isabeldeyork,arturo).
madre(isabeldeyork,margarita).
padre(enrique8,maria).
padre(enrique8,isabel).
padre(enrique8,eduardo).
madre(catalina,maria).
madre(ana,isabel).
madre(juana,eduardo).

hombre(enrique8).
hombre(enrique7).
hombre(arturo).
hombre(eduardo).
mujer(isabeldeyork).
mujer(margarita).
mujer(catalina).
mujer(maria).
mujer(juana).
mujer(ana).
mujer(isabel).

/*Reglas*/
/*Ejemplo: progenitor(X,isabel).*/

progenitor(X,Y):- padre(X,Y).
progenitor(X,Y):- madre(X,Y).

/*Ejemplo: antepasado(X,isabel).*/
/*Primero mostrara los padres y luego los abuelos*/

antepasado(X,Y):-progenitor(X,Y).
antepasado(X,Y):-progenitor(X,Z), antepasado(Z,Y).

/*Ejemplo: descendiente(enrique8,X).*/

descendiente(X,Y):- padre(X,Y).
descendiente(X,Y):- madre(X,Y).

/*Otras relaciones*/
/*Ejemplo abuelos: abuelo(X,isabel).*/

abuelo(X,Y):- progenitor(X,Z),progenitor(Z,Y),hombre(X).
abuela(X,Y):- progenitor(X,Z),progenitor(Z,Y),mujer(X).

/*Ejemplo nietos: nieto(enrique7,X).*/
nieto(X,Y):- progenitor(X,Z),progenitor(Z,Y),hombre(Y).
nieta(X,Y):- progenitor(X,Z),progenitor(Z,Y),mujer(Y).

/*Ejemplo hermanos: hermano(enrique8,X).*/
/*Si tienen los mismos padres se repetiran los mismos nombres*/
hermano(X,Y):- hombre(Y), progenitor(Z,X), progenitor(Z,Y), X\=Y.
hermana(X,Y):- mujer(Y), progenitor(Z,X), progenitor(Z,Y), X\=Y.


