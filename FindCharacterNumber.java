//Q1 Find the nth index of a character in a given string. Without string operations.

import java.util.*;
import java.util.stream.*;

 
class FindCharacterNumber
{
 static int FindChar(String str, char ch, int N)
{
    int occur = 0;

    for (int i = 0; i < str.length(); i++)
    {
        if (str.charAt(i) == ch)
        {
            occur += 1;
        }
        if (occur == N)
            return i;
    }
    return -1;
}

public static void main(String[] args)
{
    String str = "Who is the expert in the domain of corelab automation industry.";
    char ch = 'e';
    int N = 2;
    System.out.print(FindChar(str, ch, N));
}
}
 