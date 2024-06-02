equalList([]).
equalList([_]).
equalList([X,X|L]) :- equalList([X|L]).