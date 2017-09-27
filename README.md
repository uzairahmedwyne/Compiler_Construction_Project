# Compiler_Construction_Project
Compiler for structured case sensitive language implemented using java.
Code to be examined by compiler is inside 'source.txt' file which is inside 'Compiler_Construction_Project' folder.
LANGUAGE SPECIFICATIONS:
Loops: while=>unless , for=>loop
Conditional Statements: if=>iff , elseif=>oriff , else=>atlast
program starts execution from go() function.
No datatypes, first letter of identifier's name tells its datatype i.e. String=> $ , character=> @ , boolean=> ? , integer=> # , floating point=> ~
Struct is declared using: struct struct-name { ..body.. };
1D arrays are declared as: (# or $ or @ or ? or ~)array_name[length] OR (# or $ or @ or ? or ~)array_name={..elements..}
2D arrays are declared as: (# or $ or @ or ? or ~)array_name[rows][columns] OR (# or $ or @ or ? or ~)array_name={..,(elements),..}
Function declaration: (# or $ or @ or ? or ~)function_name(..optional parameters..){..body..}
Only single line comments are there which are used as: //..comments..
Rules for integer, string, float, character, boolean constant's are same as in Java.
Statements terminates at ;
Punctuators: .  (  ) { }
Arithmetic, Increment/Decrement, Assignment, Logical, Relational operators are same as in Java.
void=> not
All other keywords are same as in java except for the object oriented keywords.
