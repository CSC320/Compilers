/**
 * Define a grammar called Hello
 */
grammar GrammarCSV;
r: 'FIND' (abr':'input'-')+;         // match keyword hello followed by an identifier

abr : 'A' | 'T' | 'TL' | 'GT' | 'SD' | 'IP';

input: IN ;

IN : ([a-z] | [A-Z] | [0-9] | [0-9]'.' | [0-9] | ':'[0-9])+  ;             // match lower-case identifiers

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines


