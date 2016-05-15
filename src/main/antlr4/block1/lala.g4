lexer grammar lala;

fragment WORD : 'La' 'a'* ' '* ;             // Keyword
fragment WORD2: 'La' 'a'* ' '* 'La' 'a'* ' '*;
fragment WORD3: 'La' 'a'* ' '* 'La' 'a'* ' '* 'La' 'a'* ' '* 'Li';
EXPRESSION : (WORD|WORD2|WORD3)*;
