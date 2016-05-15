lexer grammar pli;

WORD : '"' (~'"'|'""')* '"' ;             // Keyword
