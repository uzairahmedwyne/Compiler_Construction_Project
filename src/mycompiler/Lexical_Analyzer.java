package mycompiler;
import java.io.*;
import java.util.*;
public class Lexical_Analyzer {
    static boolean isBS=false , flag=false;
    static ArrayList<String> tokens=new ArrayList<String>();
    static int lineNo=1;
    
    static String punctuator(char punc, int lineNo){
        String token ="";
        switch(punc){
            case '(':
                token = "("+punc+","+punc+","+lineNo+")";
                break;
            case ')':
                token = "("+punc+","+punc+","+lineNo+")";
                break;
            case '{':
                token = "("+punc+","+punc+","+lineNo+")";
                break;
            case '}':
                token = "("+punc+","+punc+","+lineNo+")";
                break;
            case '[':
                token = "("+punc+","+punc+","+lineNo+")";
                break;
            case ']':
                token = "("+punc+","+punc+","+lineNo+")";
                break;
            case '.':
                token = "("+punc+","+punc+","+lineNo+")";
                break;
            case ';':
                token = "("+punc+","+punc+","+lineNo+")";
                break;
            case ':':
                token = "("+punc+","+punc+","+lineNo+")";
                break;
            default:
                token = "(Lexical_Error,"+punc+","+lineNo+")";
                break;
        }
        return token;
    }
    static String isoperator(String temp, int lineNo){
        String token ="";
        switch(temp){
            case "+":
                token = "(ADD_SUB,"+temp+","+lineNo+")";
                break;
            case "-":
                token = "(ADD_SUB,"+temp+","+lineNo+")";
                break;
            case "*":
                token = "(MUL_DIV,"+temp+","+lineNo+")";
                break;
            case "/":
                token = "(MUL_DIV,"+temp+","+lineNo+")";
                break;
            case "%":
                token = "(MODULO,"+temp+","+lineNo+")";
                break;
            case "=":
                token = "(ASSIGNMENT_OPERATOR,"+temp+","+lineNo+")";
                break;
            case "+=":
                token = "(ASSIGNMENT_OPERATOR,"+temp+","+lineNo+")";
                break;
            case "-=":
                token = "(ASSIGNMENT_OPERATOR,"+temp+","+lineNo+")";
                break;
            case "*=":
                token = "(ASSIGNMENT_OPERATOR,"+temp+","+lineNo+")";
                break;
            case "/=":
                token = "(ASSIGNMENT_OPERATOR,"+temp+","+lineNo+")";
                break;
            case "%=":
                token = "(ASSIGNMENT_OPERATOR,"+temp+","+lineNo+")";
                break;
            case "++":
                token = "(INC_DEC,"+temp+","+lineNo+")";
                break;
            case "--":
                token = "(INC_DEC,"+temp+","+lineNo+")";
                break;
            case "&&":
                token = "(AND,"+temp+","+lineNo+")";
                break;
            case "||":
                token = "(OR,"+temp+","+lineNo+")";
                break;
            case "<":
                token = "(RELATIONAL_OPERATOR,"+temp+","+lineNo+")";
                break;
            case ">":
                token = "(RELATIONAL_OPERATOR,"+temp+","+lineNo+")";
                break;
            case "<=":
                token = "(RELATIONAL_OPERATOR,"+temp+","+lineNo+")";
                break;
            case ">=":
                token = "(RELATIONAL_OPERATOR,"+temp+","+lineNo+")";
                break;
            case "==":
                token = "(RELATIONAL_OPERATOR,"+temp+","+lineNo+")";
                break;
            case "!=":
                token = "(RELATIONAL_OPERATOR,"+temp+","+lineNo+")";
                break;
            case "!":
                token = "(UNARY_OPERATOR,"+temp+","+lineNo+")";
                break;
            default:
                token = "(Lexical_Error,"+temp+","+lineNo+")";
                break;
        }
        return token;
    }
    public static void main(String[] args) {
        try
        {
                FileReader fr=new FileReader("source.txt");
                BufferedReader br =new BufferedReader(fr);
                
                String temp, code="";
                int i = 0,j;
                while((temp=br.readLine()) != null)
                {
                    code += temp;
                    code += "\n";
                }
                while(i <= code.length()-2)
                {
                    temp="";
                    
                    while((code.charAt(i) != '(' && code.charAt(i) != ')' && code.charAt(i) != '{' && 
                            code.charAt(i) != '}' && code.charAt(i) != '[' && code.charAt(i) != ']' 
                            && code.charAt(i) != '.' && code.charAt(i) != ';' && code.charAt(i)!=':' &&
                            code.charAt(i) != '\n' && code.charAt(i) != '+' && code.charAt(i) != '-' &&
                            code.charAt(i) != '*' && code.charAt(i) != '/' && code.charAt(i)!='<'
                            && code.charAt(i)!='>' && code.charAt(i)!= '=' && code.charAt(i)!= '&'
                            && code.charAt(i)!='|' && code.charAt(i) != 32 && code.charAt(i)!= '!' &&
                            code.charAt(i) != 34 && code.charAt(i) != 39) && i <= code.length()-2)
                    {
                        temp += code.charAt(i);
                        i++;
                    }
                    
                    if(!"".equals(temp) && code.charAt(i) != '.')
                    {
                        tokens.add(validate(temp,lineNo,code.charAt(i)));
                    }
                    
                    else if(code.charAt(i)=='.'){
                        if(temp.chars().allMatch( Character::isDigit )){
                            temp+=code.charAt(i);
                            i++;
                            while((code.charAt(i) != '(' && code.charAt(i) != ')' && code.charAt(i) != '{' && 
                                code.charAt(i) != '}' && code.charAt(i) != '[' && code.charAt(i) != ']' && 
                                code.charAt(i) != ';' && code.charAt(i) != '\n' && code.charAt(i) != '+' && 
                                code.charAt(i) != '-' && code.charAt(i) != '*' && code.charAt(i) != '/' && 
                                code.charAt(i) != 32 && code.charAt(i) != 34 && code.charAt(i) != 39 && 
                                code.charAt(i) != '.' && code.charAt(i) != ':' && code.charAt(i) != '=' &&
                                code.charAt(i) != '<' && code.charAt(i) != '>' && code.charAt(i) != '&' &&
                                code.charAt(i) != '|' && code.charAt(i) != '!' && code.charAt(i) != '%' && code.charAt(i) != '@') 
                                && i <= code.length()-2)
                            {
                                temp+=code.charAt(i);
                                i++;
                            }
                            tokens.add(validate(temp,lineNo,code.charAt(i)));
                        }
                        else{
                            tokens.add(validate(temp,lineNo,code.charAt(i)));
                        }
                    }
                    
                    if(code.charAt(i) == '\''){
                        temp="";
                        if(code.charAt(i+1)=='\\')
                        {
                            for(j=0;j<4;j++)
                            {
                                temp += code.charAt(i+j);
                            }
                            
                            tokens.add(validate(temp,lineNo,code.charAt(i)));
                            i += j-1;
                        }
                        else
                        {
                            for(j=0 ; j < 3;j++)
                            {
                                temp += code.charAt(i+j);
                            }
                            
                            tokens.add(validate(temp,lineNo,code.charAt(i)));
                            i+= j-1;
                        }
                    }
                    
                    else if(code.charAt(i)== '"')
                    {
                        temp= "";
                        temp += code.charAt(i);
                        for(j=1; (code.charAt(i+j) != '"' && (i+j)<=code.length()-2);j++){
                            if(code.charAt(i+j) == '\\'){
                                temp+= "\\";
                                temp += code.charAt(i+j+1);
                                j++;
                            }
                            else{
                                if(code.charAt(i+j)=='\n'){
                                 lineNo++;   
                                }
                                
                            temp += code.charAt(i+j);
                            }
                        }
                        i+= j;
                        if(code.charAt(i)!='\n')
                        {
                        temp+= code.charAt(i);
                        }
                        
                        tokens.add(validate(temp,lineNo,code.charAt(i)));
                    }
                    
                    else if(code.charAt(i)=='+' || code.charAt(i)=='-' || code.charAt(i)=='*' || 
                            code.charAt(i)=='/' || code.charAt(i)=='=' || code.charAt(i)=='&' ||
                            code.charAt(i)=='|' || code.charAt(i)=='>' || code.charAt(i)=='<' ||
                            code.charAt(i)=='!' || code.charAt(i) == '%')
                    {
                        temp = "";
                        temp += code.charAt(i); 
                        if(code.charAt(i+1)== '=' && (code.charAt(i)=='+' || code.charAt(i)=='-' ||
                            code.charAt(i)=='*' || code.charAt(i)=='/' || code.charAt(i)=='=' ||
                            code.charAt(i)=='%' || code.charAt(i)=='<' || code.charAt(i)=='>' ||
                                code.charAt(i)=='!'))
                        {
                            temp += code.charAt(i+1);
                            i++;
                            tokens.add(isoperator(temp , lineNo));
                        }
                        else if((code.charAt(i+1) == '+' && code.charAt(i) == '+') || (code.charAt(i+1) == '-' && 
                                code.charAt(i) == '-')){
                            temp += code.charAt(i+1);
                            i++;
                            tokens.add(isoperator(temp , lineNo));
                        }
                        
                        else if(code.charAt(i)=='/' && code.charAt(i+1) == '/')
                        {
                            while(code.charAt(i) != '\n'){
                                  i++;
                        }
                        lineNo++;
                        }
                        else if((Character.isDigit(code.charAt(i+1)) || code.charAt(i+1) == '.') && (code.charAt(i) == '+' || code.charAt(i) == '-')){
                            i++;
                            while((code.charAt(i) != '(' && code.charAt(i) != ')' && code.charAt(i) != '{' && 
                                code.charAt(i) != '}' && code.charAt(i) != '[' && code.charAt(i) != ']' && 
                                code.charAt(i) != ';' && code.charAt(i) != '\n' && code.charAt(i) != '+' && 
                                code.charAt(i) != '-' && code.charAt(i) != '*' && code.charAt(i) != '/' && 
                                code.charAt(i) != 32 && code.charAt(i) != 34 && code.charAt(i) != 39 && 
                                code.charAt(i) != '.' && code.charAt(i) != ':' && code.charAt(i) != '=' &&
                                code.charAt(i) != '<' && code.charAt(i) != '>' && code.charAt(i) != '&' &&
                                code.charAt(i) != '|' && code.charAt(i) != '!' && code.charAt(i) != '%' && code.charAt(i) != '@') 
                                && i <= code.length()-2)
                            {
                                temp+=code.charAt(i);
                                i++;
                            }
                            if(!"".equals(temp) && code.charAt(i) != '.'){
                                tokens.add(validate(temp,lineNo,code.charAt(i)));
                                i--;
                            }
                            else if(code.charAt(i)=='.'){
                                temp+=code.charAt(i);
                                i++;
                                while((code.charAt(i) != '(' && code.charAt(i) != ')' && code.charAt(i) != '{' && 
                                    code.charAt(i) != '}' && code.charAt(i) != '[' && code.charAt(i) != ']' && 
                                    code.charAt(i) != ';' && code.charAt(i) != '\n' && code.charAt(i) != '+' && 
                                    code.charAt(i) != '-' && code.charAt(i) != '*' && code.charAt(i) != '/' && 
                                    code.charAt(i) != 32 && code.charAt(i) != 34 && code.charAt(i) != 39 && 
                                    code.charAt(i) != '.' && code.charAt(i) != ':' && code.charAt(i) != '=' &&
                                    code.charAt(i) != '<' && code.charAt(i) != '>' && code.charAt(i) != '&' &&
                                    code.charAt(i) != '|' && code.charAt(i) != '!' && code.charAt(i) != '%' && 
                                    code.charAt(i) != '@') && i <= code.length()-2)
                                    {
                                        temp += code.charAt(i);
                                        i++;
                                    }
                                    tokens.add(validate(temp,lineNo,code.charAt(i)));
                                    i--;
                                }
                            }
                        
                        else if(code.charAt(i) == '&' || code.charAt(i) == '|'){
                            temp += code.charAt(i+1);
                            i++;
                            tokens.add(isoperator(temp , lineNo));
                        }
                        else{
                            tokens.add(isoperator(temp , lineNo));
                        }
                    }
                    
                    else if(code.charAt(i)=='\n')
                        
                        lineNo++;
                    
                    if(code.charAt(i) != '+' && code.charAt(i) != '-' && code.charAt(i) != '*' && code.charAt(i) != '/' && 
                            code.charAt(i) != '=' && code.charAt(i) != '&' && code.charAt(i) != '|' && code.charAt(i) != '>' && 
                            code.charAt(i) != '<' && code.charAt(i) !='!' && code.charAt(i) != '%' && code.charAt(i)!='"' && 
                            code.charAt(i)!= '\'' && code.charAt(i) != '\n' && code.charAt(i) != 32 && code.charAt(i) != '@' && 
                            !Character.isLetterOrDigit(code.charAt(i)))
                        
                        tokens.add(punctuator(code.charAt(i),lineNo));
                    
                    i++;
                }
                j = 0;
                while(j < tokens.size())
                {
                    System.out.println(tokens.get(j));
                    j++;
                }
                }
        
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    static String validate(String temp,int lineno,char brace){
        String token = "";
        if(!"loop".equals(temp) && !"unless".equals(temp) && !"iff".equals(temp) && !"oriff".equals(temp) 
                && !"atlast".equals(temp) && !"struct".equals(temp) && !"go".equals(temp) && !"break".equals(temp)
                && !"case".equals(temp) && !"default".equals(temp) && !"return".equals(temp) && !"not".equals(temp)
                && !"true".equals(temp) && !"false".equals(temp))
        {
        switch(temp.charAt(0)){
            case '\'':
                if(DFA_CharacterConstant(temp))
                    token = "(Character_Constant,"+temp+","+lineNo+")";
                else
                    token = "(Lexical_Error,"+temp+","+lineNo+")";
                break;
            case '"':
                if(DFA_StringConstant(temp))
                    token = "(String_Constant,"+temp+","+lineNo+")";
                else
                    token = "(Lexical_Error,"+temp+","+lineNo+")";
                break;
            case '@':
                if(DFA_Identifier(temp)){
                    if(brace == '('){
                    token = "(Function_Character_Identifier,"+temp+","+lineNo+")";
                    }
                    else if(brace == '[')
                        token = "(Array_Character_Identifier,"+temp+","+lineNo+")";
                    else
                        token = "(Character_Identifier,"+temp+","+lineNo+")";
                }
                else
                    token = "(Lexical_Error,"+temp+","+lineNo+")";
                break;
            case '$':
                if(DFA_Identifier(temp))
                    if(brace == '('){
                    token = "(Function_String_Identifier,"+temp+","+lineNo+")";
                    }
                    else if(brace == '[')
                        token = "(Array_String_Identifier,"+temp+","+lineNo+")";
                    else
                    token = "(String_Identifier,"+temp+","+lineNo+")"; 
                else
                    token = "(Lexical_Error,"+temp+","+lineNo+")";
                break;
            case '~':
                if(DFA_Identifier(temp))
                    if(brace == '('){
                    token = "(Function_Float_Identifier,"+temp+","+lineNo+")";
                    }
                    else if(brace == '[')
                        token = "(Array_Float_Identifier,"+temp+","+lineNo+")";
                    else
                    token = "(Float_Identifier,"+temp+","+lineNo+")"; 
                else
                    token = "(Lexical_Error,"+temp+","+lineNo+")";
                break;
            case '#':
                if(DFA_Identifier(temp))
                    if(brace == '('){
                    token = "(Function_Integer_Identifier,"+temp+","+lineNo+")";
                    }
                    else if(brace == '[')
                        token = "(Array_Integer_Identifier,"+temp+","+lineNo+")";
                    else
                    token = "(Integer_Identifier,"+temp+","+lineNo+")"; 
                else
                    token = "(Lexical_Error,"+temp+","+lineNo+")";
                break;
            case '?':
                if(DFA_Identifier(temp))
                    if(brace == '('){
                    token = "(Function_Boolean_Identifier,"+temp+","+lineNo+")";
                    }
                    else if(brace == '[')
                        token = "(Array_Boolean_Identifier,"+temp+","+lineNo+")";
                    else
                    token = "(Boolean_Identifier,"+temp+","+lineNo+")"; 
                else
                    token = "(Lexical_Error,"+temp+","+lineNo+")";
                break;
            case '.':
                if(DFA_FloatConstant(temp))
                    token = "(FLOAT_CONSTANT,"+temp+","+lineNo+")";
                else
                    token = "(LEXICAL_ERROR,"+temp+","+lineNo+")";
                break;
            case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
                if(temp.length()>1){
                        int i = 1;
                        while (i<temp.length()){
                            if(temp.charAt(i) == '.')
                                flag = true;
                            i++;
                        }
                        if(flag == false)
                            if(DFA_IntegerConstant(temp))
                                token = "(Integer_Constant,"+temp+","+lineNo+")"; 
                            else
                                token = "(Lexical_Error,"+temp+","+lineNo+")";
                        else{
                            if(DFA_FloatConstant(temp))
                                token = "(Float_Constant,"+temp+","+lineNo+")"; 
                            else
                                token = "(Lexical_Error,"+temp+","+lineNo+")";
                            flag = false;
                        }
                }
                else
                    if(DFA_IntegerConstant(temp))
                        token = "(Integer_Constant,"+temp+","+lineNo+")"; 
                    else
                        token = "(Lexical_Error,"+temp+","+lineNo+")";
                break;
            case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': case 'h':
            case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': case 'o': case 'p':
            case 'q': case 'r': case 's': case 't': case 'u': case 'v': case 'w': case 'x':
            case 'y': case 'z': case 'A': case 'B': case 'C': case 'D': case 'E': case 'F': case 'G': case 'H':
            case 'I': case 'J': case 'K': case 'L': case 'M': case 'N': case 'O': case 'P':
            case 'Q': case 'R': case 'S': case 'T': case 'U': case 'V': case 'W': case 'X':
            case 'Y': case 'Z':
                if(DFA_SimpleIdentifier(temp)){
                    if(brace == '('){
                    token = "(Function_Void_Identifier,"+temp+","+lineNo+")";
                    }
                    else if(brace == '{')
                        token = "(Struct_Identifier,"+temp+","+lineNo+")";
                    else
                        token = "(Lexical_Error,"+temp+","+lineNo+")";
                }
                else
                    token = "(Lexical_Error,"+temp+","+lineNo+")";
                break;
            case '+': case '-':
                int i = 1;
                while(i<temp.length()){
                    if(temp.charAt(i) == '.')
                        flag = true;
                    i++;
                }
                if(flag == false)
                    if(DFA_IntegerConstant(temp))
                        token = "(Integer_Constant,"+temp+","+lineNo+")"; 
                    else
                        token = "(Lexical_Error,"+temp+","+lineNo+")";
                else{
                    if(DFA_FloatConstant(temp))
                        token = "(Float_Constant,"+temp+","+lineNo+")"; 
                    else
                        token = "(Lexical_Error,"+temp+","+lineNo+")";
                    flag = false;
                }
                break;
            default:
                token = "(Lexical_Error,"+temp+","+lineNo+")";
            }
        }
        else{
                switch(temp){
                    case "loop":
                        token = "(FOR,"+temp+","+lineNo+")";
                        break;
                    case "unless":
                        token = "(WHILE,"+temp+","+lineNo+")";
                        break;
                    case "iff":
                        token = "(IF,"+temp+","+lineNo+")";
                        break;
                    case "oriff":
                        token = "(ELSE_IF,"+temp+","+lineNo+")";
                        break;
                    case "atlast":
                        token = "(ELSE,"+temp+","+lineNo+")";
                        break;
                    case "struct":
                        token = "(STRUCT,"+temp+","+lineNo+")";
                        break;
                    case "go":
                        token = "(MAIN,"+temp+","+lineNo+")";
                        break;
                    case "break":
                        token = "(BREAK,"+temp+","+lineNo+")";
                        break;
                    case "case":
                        token = "(CASE,"+temp+","+lineNo+")";
                        break;
                    case "default":
                        token = "(DEFAULT,"+temp+","+lineNo+")";
                        break;
                    case "true":
                        token = "(BOOLEAN_CONSTANT,"+temp+","+lineNo+")";
                        break;
                    case "false":
                        token = "(BOOLEAN_CONSTANT,"+temp+","+lineNo+")";
                        break;
                    case "not":
                        token = "(VOID,"+temp+","+lineNo+")";
                        break;
                    case "return":
                        token = "(RETURN,"+temp+","+lineNo+")";
                        break;
                    default:
                        token = "Lexical_Error,"+temp+","+lineNo+")";
                }
        }
        return token;
    }
    static boolean DFA_FloatConstant(String temp){
    int i=0,CS=0,FS=3;
    String str="";
    str+=temp;
    while(i<str.length()){
        CS=TT_FloatConstant(CS,str.charAt(i));
        i++;
    }
    if(CS==FS){
        return true;
    }
    else
        return false;
    }
    static int TT_FloatConstant(int CS,char str){
                 // {digit,.,+-}
        int t[][]={{1,2,1},{1,2,4},{3,4,4},{3,4,4},{4,4,4}};
        if(Character.isDigit(str))
            return t[CS][0];
        else if(str=='.')
            return t[CS][1];
        else if(str=='+'||str=='-')
            return t[CS][2];
        else
            return 4;
    }
    static boolean DFA_IntegerConstant(String temp){
    int i=0,CS=0,FS=2;
    String str=temp;
    while(i<str.length()){
        CS=TT_IntegerConstant(CS,str.charAt(i));
        i++;
    }
    if(CS==FS){
        return true;
    }
    else
        return false;
    }
    static int TT_IntegerConstant(int CS,char str){
                  // {digit,+-}
        int t[][]={{2,1},{2,3},{2,3},{3,3}};
        if(Character.isDigit(str))
            return t[CS][0];
        else if(str=='+'||str=='-')
            return t[CS][1];
        else
            return 3;
    }
    static boolean DFA_SimpleIdentifier(String temp){
    int i=0,CS=0,FS=2;
    String str=temp;
    while(i<str.length()){
        CS=TT_SimpleIdentifier(CS,str.charAt(i));
        i++;
    }
    if(CS==FS){
        return true;
    }
    else
        return false;
    }
    static int TT_SimpleIdentifier(int CS,char str){
                  // {alpha,digit,_}
        int t[][]={{2,3,3},{2,2,1},{2,2,3},{3,3,3}};
        if(Character.isLetter(str))
            return t[CS][0];
        if(Character.isDigit(str))
            return t[CS][1];
        else if(str=='_')
            return t[CS][2];
        else
            return 3;
    }
    static boolean DFA_Identifier(String temp){
    int i=0,CS=0,FS=3;
    String str=temp;
    while(i<str.length()){
        CS=TT_Identifier(CS,str.charAt(i));
        i++;
    }
    if(CS==FS){
        return true;
    }
    else
        return false;
    }
    static int TT_Identifier(int CS,char str){
                  // {alpha,digit,ss,_}
        int t[][]={{4,4,1,4},{3,4,4,4},{3,3,4,4},{3,3,4,2},{4,4,4,4}};
        if(Character.isLetter(str))
            return t[CS][0];
        if(Character.isDigit(str))
            return t[CS][1];
        else if(str=='#'||str=='$'||str=='@'||str=='~'||str=='?')
            return t[CS][2];
        else if(str=='_')
            return t[CS][3];
        else
            return 4;
    }
    static boolean DFA_CharacterConstant(String temp){
    int i=0,CS=0,FS=4;
    String str=temp;
    while(i<str.length()){
        CS=TT_CharacterConstant(CS,str.charAt(i));
        i++;
    }
    if(CS==FS){
        isBS=false;
        return true;
    }
    else{
        isBS=false;
        return false;
    }
    }
    static int TT_CharacterConstant(int CS,char str){
                 //{',c,\,es}
        int t[][]={{1,5,5,5},{5,3,2,5},{3,5,3,3},{4,5,5,5},{5,5,5,5},{5,5,5,5}};
        if(isBS==false){
        if(str==(char)39) // for '
            return t[CS][0];
        else if(Character.isLetterOrDigit(str)||str=='"'||str=='~'||str=='!'||str=='@'||str=='#'||str=='$'||
                str=='%'||str=='^'||str=='&'||str=='*'||str=='('||str==')'||str=='-'||str=='_'||str=='+'||str=='='||
                str=='{'||str=='}'||str=='['||str==']'||str=='|'||str==':'||str==';'||str==','||str=='.'||str=='/'||str=='<'
                ||str=='>'||str=='?'||str==' ')
            return t[CS][1];
        else if(str=='\\'){
            isBS=true;
            return t[CS][2];
        }
        else
            return 5;
        }
        else{
        if(str=='n'||str=='t'||str=='r'||str=='b'||str=='f'||str=='\''||str=='\\'){
                isBS=false;
                return t[CS][3];
                }
        else
            return 5;
        }
    } 
    static boolean DFA_StringConstant(String temp){
    int i=0,CS=0,FS=4;
    String str=temp;
    while(i<str.length()){
        CS=TT_StringConstant(CS,str.charAt(i));
        i++;
    }
    if(CS==FS){
        isBS=false;
        return true;
    }
    else{
        isBS=false;
        return false;
    }
    }
    static int TT_StringConstant(int CS,char str){
                 //{",c,\,es}
        int t[][]={{1,5,5,5},{4,3,2,5},{3,5,3,3},{4,1,2,5},{5,5,5,5},{5,5,5,5}};
        if(isBS==false){
        if((str==(char)34)) // for "
            return t[CS][0];
        else if(Character.isLetterOrDigit(str)|| str=='\''||str=='~'||str=='!'||str=='@'||str=='#'||str=='$'||
                str=='%'||str=='^'||str=='&'||str=='*'||str=='('||str==')'||str=='-'||str=='_'||str=='+'||str=='='||
                str=='{'||str=='}'||str=='['||str==']'||str=='|'||str==':'||str==';'||str==','||str=='.'||str=='/'||str=='<'
                ||str=='>'||str=='?'||str==' ')
            return t[CS][1];
        else if(str=='\\'){
            isBS=true;
            return t[CS][2];
        }
        else
            return 5;
        }
        else if(str=='n'||str=='t'||str=='r'||str=='b'||str=='f'||str=='"'||str=='\\'){
            isBS=false;
            return t[CS][3];
        }
        else
            return 5;   
    }
}