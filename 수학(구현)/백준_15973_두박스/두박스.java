import java.util.*;

public class Main {
    enum box_status {
        face,
        line,
        nul
    }

    static box_status make_status(int i, int j, int k, int l) {
        box_status status;

        if (k < i) {
            if (l < i)
                status = box_status.nul;
            else if (l == i)
                status = box_status.line;
            else
                status = box_status.face;
        } else if (i <= k && k < j)
            status = box_status.face;
        else if (k == j)
            status = box_status.line;
        else
            status = box_status.nul;

        return status;
    }

    public static void main(String[] args) {
        box_status x_status;
        box_status y_status;
        Scanner s = new Scanner(System.in);
        int x1, y1, x2, y2;
        int a1, b1, a2, b2;

        x1 = s.nextInt();
        y1 = s.nextInt();
        x2 = s.nextInt();
        y2 = s.nextInt();

        a1 = s.nextInt();
        b1 = s.nextInt();
        a2 = s.nextInt();
        b2 = s.nextInt();

        x_status = make_status(x1, x2, a1, a2);
        y_status = make_status(y1, y2, b1, b2);

        if (x_status == box_status.nul || y_status == box_status.nul)
            System.out.println("NULL");
        else if (x_status == box_status.line && y_status == box_status.line)
            System.out.println("POINT");
        else if (x_status == box_status.face && y_status == box_status.face)
            System.out.println("FACE");
        else
            System.out.println("LINE");

    }
}