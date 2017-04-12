/**
 * Define a grammar called Hello
 */
grammar GrammarCSV;
r: 'FIND' (abr input)+;         // match keyword of possible commands and input

abr : 'A_'|'T_'|'TL_'|'G_'|'SD_'|'IP_' | 'D_' | 'SU_' | 'SP_' | 'DP_' | 'URL_' | 'CA_';
input: IN'-' ;

IN : ([a-z] | [A-Z] | [0-9] | [0-9]'.' | [0-9]':' )+;             // match lower-case identifiers

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines


