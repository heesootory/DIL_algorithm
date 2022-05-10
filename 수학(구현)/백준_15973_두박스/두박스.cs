using System.Collections;
using static System.Console;
using System;

class Program
{
    enum box_status
    {
        face,
        line,
        Null
    }

    static box_status make_status(int i, int j, int k, int l)
    {
        box_status status;
        if (k < i)
        {
            if (l < i) status = box_status.Null;
            else if (l == i) status = box_status.line;
            else status = box_status.face;
        }
        else if (i <= k && k < j) status = box_status.face;
        else if (k == j) status = box_status.line;
        else status = box_status.Null;

        return status;
    }

    public static void Main()
    {

        int x1, y1, x2, y2;
        string[] s = ReadLine().Split(' ');
        x1 = int.Parse(s[0]);
        y1 = int.Parse(s[1]);
        x2 = int.Parse(s[2]);
        y2 = int.Parse(s[3]);

        int a1, b1, a2, b2;
        s = ReadLine().Split(' ');
        a1 = int.Parse(s[0]);
        b1 = int.Parse(s[1]);
        a2 = int.Parse(s[2]);
        b2 = int.Parse(s[3]);

        box_status x_status;
        box_status y_status;

        x_status = make_status(x1, x2, a1, a2);
        y_status = make_status(y1, y2, b1, b2);

        if (x_status == box_status.Null || y_status == box_status.Null) Write("NULL");
        else if (x_status == box_status.line && y_status == box_status.line) Write("POINT");
        else if (x_status == box_status.face && y_status == box_status.face) Write("FACE");
        else Write("LINE");


    }
}