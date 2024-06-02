/*PROBLEMAS PARTE 1 - EJERCICIO 1*/
/*Base de Conocimientos - Los Simpsons*/
/*David Barrios - C.I: 25.721.785*/

/*Hechos*/
/*Se lee: abraham es progenitor de homero*/

es_progenitor(abraham,homero).
es_progenitor(mona,homero).
es_progenitor(jacqueline,marge).
es_progenitor(clancy,marge).
es_progenitor(jacqueline,paty).
es_progenitor(clancy,paty).
es_progenitor(jacqueline,selma).
es_progenitor(clancy,selma).
es_progenitor(homero,bart).
es_progenitor(homero,lisa).
es_progenitor(marge,bart).
es_progenitor(marge,lisa).
es_progenitor(marge,maggie).
es_progenitor(kang,maggie).

/*Mujeres*/

mujer(mona).
mujer(jacqueline).
mujer(marge).
mujer(lisa).
mujer(maggie).
mujer(paty).
mujer(selma).

/*Hombres*/

hombre(abraham).
hombre(clancy).
hombre(homero).
hombre(bart).
hombre(kang).

/*EJERCICIO 1*/

/*Se lee: abraham es abuelo de bart, porque homero es progenitor de bart y abraham es hombre*/

abuelo(X,Y):- hombre(X),es_progenitor(X,Z),es_progenitor(Z,Y).
abuela(X,Y):- mujer(X),es_progenitor(X,Z),es_progenitor(Z,Y).

/*En este caso de hermanos, si hay coincidencia con ambos papás, se repetirá el hermano dos veces, pero es la misma persona*/

hermano(X,Y):- hombre(X), es_progenitor(Z,X), es_progenitor(Z,Y), X\=Y.
hermana(X,Y):- mujer(X), es_progenitor(Z,X), es_progenitor(Z,Y), X\=Y.

/*En este caso de tios, si hay coincidencia con ambos papás, se repetirá el tio dos veces, pero es la misma persona*/

tio(X,Y):- es_progenitor(Z,Y), hermano(Z,X), X\=Y.
tia(X,Y):- es_progenitor(Z,Y), hermana(Z,X), X\=Y.


