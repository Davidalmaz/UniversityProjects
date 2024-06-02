:- [tablero].

dxy(1,0).
dxy(-1,0).
dxy(0,1).
dxy(0,-1).
dxy(1,1).
dxy(1,-1).
dxy(-1,1).
dxy(-1,-1).

libre(X, Y):-
	\+pieza(X, Y).

salta([X,Y], [X1, Y1]) :-
	dxy(Dx, Dy),
	X1 is X+Dx,
	correcto(X1),
	Y1 is Y+Dy,
	correcto(Y1),
	libre(X1, Y1).

correcto(X) :-
	1 =< X,
	X =< 8.

