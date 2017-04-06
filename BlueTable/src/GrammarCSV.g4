/**
 * Define a grammar called Hello
 */
grammar GrammarCSV;
r: 'FIND' (abr input)+;         // match keyword hello followed by an identifier

abr : 'A_'|'T_'|'TL_'|'GT_'|'SD_'|'IP_';
input: IN'-' ;

IN : ([a-z] | [A-Z] | [0-9] | [0-9]'.' | [0-9]':' )+;             // match lower-case identifiers

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines


