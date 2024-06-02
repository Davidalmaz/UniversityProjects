/*PROBLEMAS PARTE 2 - EJERCICIO 1*/
/*David Barrios - C.I: 25.721.785*/

/*Base de conocimiento - Semantica*/

atributo(animal,puede,respirar).
atributo(ave,es_un,animal).
atributo(ave,vuela,bien).
atributo(ave,tiene,plumas).
atributo(ave,pone,huevo).
atributo(flamenco,es_un,ave).
atributo(albatros,es_un,ave).
atributo(flamenco,patas,largas).
atributo(flamenco,vive_en,marisma).
atributo(albatros,come,peces).
atributo(mamifero,es_un,animal).
atributo(mamifero,tiene,piel).
atributo(mamifero,da,leche).
atributo(ballena,es_un,mamifero).
atributo(ballena,come,plancton).
atributo(ballena,vive_en,mar).
atributo(tigre,es_un,mamifero).
atributo(tigre,come,carne).

/*Reglas*/

/*Relaciones*/

atributo(ave,animal).
atributo(mamifero,animal).
atributo(flamenco,ave).
atributo(albatros,ave).
atributo(ballena,mamifero).
atributo(tigre,mamifero).

/*Herencia*/

hereda(X,Y):- atributo(X,Y).
hereda(X,Y):- atributo(X,Z), hereda(Z,Y).

atributo(X,Y,Z):- hereda(X,M), atributo(M,Y,Z).
