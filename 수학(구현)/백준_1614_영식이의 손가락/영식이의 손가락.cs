using System.Collections;
using static System.Console;
using System;

class Program
{
    public static void Main()
    {
        string s = ReadLine();
        long sick_finger = long.Parse(s);
        s = ReadLine();
        long can_count = long.Parse(s);

        long num_count = 0;

        if (can_count == 0)
            for (int i = 1; i < sick_finger; i++) num_count++;
        else
        {
            if (sick_finger == 1 || sick_finger == 5)
            {
                num_count += (4 * 2 * can_count);
                for (int i = 1; i < sick_finger; i++) num_count++;
            }
            else
            {
                num_count += (4 * can_count);
                if (can_count % 2 == 0)
                {
                    for (int i = 1; i < sick_finger; i++) num_count++;
                }
                else
                {
                    for (int i = 5; i > sick_finger; i--) num_count++;
                }
            }
        }
        Write(num_count);
    }
}