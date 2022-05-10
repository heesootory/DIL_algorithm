#include <iostream>
#include <cmath>
using namespace std;

enum box_status
{
    face,
    line,
    null
};

box_status x_status;
box_status y_status;

box_status make_status(int i, int j, int k, int l)
{
    box_status status;

    if (k < i)
    {
        if (l < i)
            status = null;
        else if (l == i)
            status = line;
        else
            status = face;
    }
    else if (i <= k && k < j)
        status = face;
    else if (k == j)
        status = line;
    else
        status = null;

    return status;
}

int main()
{
    int x1, y1, x2, y2;
    int a1, b1, a2, b2;
    scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
    scanf("%d %d %d %d", &a1, &b1, &a2, &b2);

    x_status = make_status(x1, x2, a1, a2);
    y_status = make_status(y1, y2, b1, b2);

    if (x_status == null || y_status == null)
        cout << "NULL";
    else if (x_status == line && y_status == line)
        cout << "POINT";
    else if (x_status == face && y_status == face)
        cout << "FACE";
    else
        cout << "LINE";
}
