/**
 * Define a grammar called Hello
 */
grammar Hello;
r  : 'FIND' (ABR ':' IN '-')* ;         // match keyword hello followed by an identifier

ABR : 'A' | 'T' | 'TL' | 'GT' | 'SD';

IN : ([a-z] | [A-Z] | [0-9])+  ;             // match lower-case identifiers

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines


