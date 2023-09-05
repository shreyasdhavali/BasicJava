package com.sand.java.regex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        String str = " apple, apple and please and orange please appleapp";
        System.out.println(str.replaceAll("ple", "Replaced")); //apReplaced, apReplaced and Replacedase and orange Replacedase
        // \b break of word break i.e space bar is also called work breaks
        System.out.println(str.replaceAll("ple\\b", "Replaced")); //apReplaced, apReplaced and please and orange please appleapp
        System.out.println(Arrays.toString(str.split("\\b")));//[ , apple, , , apple,  , and,  , please,  , and,  , orange,  , please,  , appleapp]
        // \\w+ \\ escape character w is word character and + is one match
        String[] strArray = str.split("\\b");
        for (String s : strArray) {
            if (s.matches("\\w+")) { // identify only word characters
                System.out.print(s + " ");//apple apple and please and orange please appleapp
            }
        }
        System.out.println();
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {//apple apple and please and orange please appleapp
            System.out.print(matcher.group() + " ");
        }
        System.out.println();
        //Construct	Description
        //[abc]	a, b, or c (simple class)
        //[^abc]	Any character except a, b, or c (negation)
        //[a-zA-Z]	a through z, or A through Z, inclusive (range)
        //[a-d[m-p]]	a through d, or m through p: [a-dm-p] (union)
        //[a-z&&[def]]	d, e, or f (intersection)
        //[a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)
        //[a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z] (subtraction)

        System.out.println("abc".matches("abc"));// exact abc
        System.out.println("a".matches("[abc]"));// exact a or b or c
        System.out.println(" ".matches("[^abc]"));// anything except a or b or c
        System.out.println("F".matches("[a-zA-z]"));//  anything with a to z Or A to Z
        System.out.println("a".matches("[a-d[m-p]]"));// anything from a to d or m to p
        System.out.println("a".matches("[a-z&&[^bc]]"));// anything from a to z and b or c should not be present
        System.out.println("c".matches("[a-z&&[^m-p]]"));// anyhting from a to z and m to p should not be present

        //.	Any character (may or may not match line terminators)
        //\d	A digit: [0-9]
        //\D	A non-digit: [^0-9]
        //\s	A whitespace character: [ \t\n\x0B\f\r]
        //\S	A non-whitespace character: [^\s]
        //\w	A word character: [a-zA-Z_0-9]
        //\W	A non-word character: [^\w]

        System.out.println("c".matches("."));// anything except new line
        System.out.println("c".matches("\\d"));// any digit
        System.out.println("c".matches("\\D"));// any non digit
        System.out.println("c".matches("\\s"));// any space
        System.out.println("c".matches("\\S"));// any non space
        System.out.println("c".matches("\\w"));// any word char [a-zA-Z_0-9]
        System.out.println("c".matches("\\W"));// any non word char [^a-zA-Z_0-9]
        //Greedy	Reluctant	Possessive	Meaning
        //X?	X??	X?+	X, once or not at all
        //X*	X*?	X*+	X, zero or more times
        //X+	X+?	X++	X, one or more times
        //X{n}	X{n}?	X{n}+	X, exactly n times
        //X{n,}	X{n,}?	X{n,}+	X, at least n times
        //X{n,m}	X{n,m}?	X{n,m}+	X, at least n but not more than m times


        //To match any 2 digits, followed by the exact same two digits, you would use (\d\d)\1 as the regular expression:
        //
        //
        //Enter your regex: (\d\d)\1
        //Enter input string to search: 1212
        //I found the text "1212" starting at index 0 and ending at index 4.
        //If you change the last two digits the match will fail:
        //
        //
        //Enter your regex: (\d\d)\1
        //Enter input string to search: 1234
        //No match found.


        //Boundary Construct	Description
        //^	The beginning of a line
        //$	The end of a line
        //\b	A word boundary  // \bdog\b --> the dog --> true --> the doggie --> false
        //\B	A non-word boundary
        //\A	The beginning of the input
        //\G	The end of the previous match
        //\Z	The end of the input but for the final terminator, if any
        //\z	The end of the input

        // Pattern.compile("[az]$", Pattern.MULTILINE | Pattern.UNIX_LINES);
        //Pattern.CANON_EQ Enables canonical equivalence. When this flag is specified, two characters will be considered to match if, and only if, their full canonical decompositions match. The expression "a\u030A", for example, will match the string "\u00E5" when this flag is specified. By default, matching does not take canonical equivalence into account. Specifying this flag may impose a performance penalty.
        //Pattern.CASE_INSENSITIVE Enables case-insensitive matching. By default, case-insensitive matching assumes that only characters in the US-ASCII charset are being matched. Unicode-aware case-insensitive matching can be enabled by specifying the UNICODE_CASE flag in conjunction with this flag. Case-insensitive matching can also be enabled via the embedded flag expression (?i). Specifying this flag may impose a slight performance penalty.
        //Pattern.COMMENTS Permits whitespace and comments in the pattern. In this mode, whitespace is ignored, and embedded comments starting with # are ignored until the end of a line. Comments mode can also be enabled via the embedded flag expression (?x).
        //Pattern.DOTALL Enables dotall mode. In dotall mode, the expression . matches any character, including a line terminator. By default this expression does not match line terminators. Dotall mode can also be enabled via the embedded flag expression (?s). (The s is a mnemonic for "single-line" mode, which is what this is called in Perl.)
        //Pattern.LITERAL Enables literal parsing of the pattern. When this flag is specified then the input string that specifies the pattern is treated as a sequence of literal characters. Metacharacters or escape sequences in the input sequence will be given no special meaning. The flags CASE_INSENSITIVE and UNICODE_CASE retain their impact on matching when used in conjunction with this flag. The other flags become superfluous. There is no embedded flag character for enabling literal parsing.
        //Pattern.MULTILINE Enables multiline mode. In multiline mode the expressions ^ and $ match just after or just before, respectively, a line terminator or the end of the input sequence. By default these expressions only match at the beginning and the end of the entire input sequence. Multiline mode can also be enabled via the embedded flag expression (?m).
        //Pattern.UNICODE_CASE Enables Unicode-aware case folding. When this flag is specified then case-insensitive matching, when enabled by the CASE_INSENSITIVE flag, is done in a manner consistent with the Unicode Standard. By default, case-insensitive matching assumes that only characters in the US-ASCII charset are being matched. Unicode-aware case folding can also be enabled via the embedded flag expression (?u). Specifying this flag may impose a performance penalty.
        //Pattern.UNIX_LINES Enables UNIX lines mode. In this mode, only the '\n' line terminator is recognized in the behavior of ., ^, and $. UNIX lines mode can also be enabled via the embedded flag expression (?d).
        System.out.println("String compare regex");
        String r = "^[a-zA-Z][a-zA-Z0-9_]{7,29}";
        System.out.println("Julia".matches(r));
        System.out.println("Samantha".matches(r));
        System.out.println("Samantha_21".matches(r));
        System.out.println("1Samantha".matches(r));
        System.out.println("Samantha?10_2A".matches(r));
        System.out.println("JuliaZ007".matches(r));
        System.out.println("Julia@007".matches(r));
        System.out.println("_Julia007".matches(r));
    }

    // Note while using string matches do not use // for comparison
    //While using pattern matches use //

    //check if pattern is good or not.
//    while(testCases>0){
//        String pattern = in.nextLine();
//        try {
//            Pattern.compile(pattern); // to use exception handling so that it does not throw error.
//            System.out.println("Valid");
//        } catch (Exception e) {
//            System.out.println("Invalid");
//        }
//        testCases--;
//    }

    // any number of word character
//    public static void main(String[] args) {
//
//        String regex = "\\b(\\w+)(\\s+\\1\\b)+";
//        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//
//        Scanner in = new Scanner(System.in);
//        int numSentences = Integer.parseInt(in.nextLine());
//
//        while (numSentences-- > 0) {
//            String input = in.nextLine();
//
//            Matcher m = p.matcher(input);
//
//            // Check for subsequences of input that match the compiled pattern
//            while (m.find()) {
//                input = input.replaceAll(m.group(0), m.group(1));
//            }
//
//            // Prints the modified sentence.
//            System.out.println(input);
//        }
//
//        in.close();
//    }

}
