lexer grammar extwelve;

WORD : 'A'..'Z'|'a'..'z' BLA BLA BLA BLA BLA;             // Keyword
fragment BLA : ('a'..'z'|'A'..'Z'|'0'..'9');
