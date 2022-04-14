import java.io.*;
import java.util.*;

public class Main {

    static void print(char[][] arr){
        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j< arr[i].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    static int[] mx = new int[]{0, 1, 0, -1};
    static int[] my = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        boolean defense = true;
        int R = s.nextInt();
        int C = s.nextInt();
        char[][] medow = new char[R][C];
        for(int i = 0; i<R; i++){
            String str = s.next();
            for(int j = 0; j <C; j++){
                medow[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i< R; i++){
            for(int j = 0; j<C ; j++){
                if(medow[i][j] == 'W') {
                    for(int a = 0, b = 0; a < 4; a++, b++){
                        int new_i = i+mx[a];
                        int new_j = j+my[b];
                        if(new_i <0 || new_i >= R || new_j < 0 || new_j >= C) continue;

                        if(medow[new_i][new_j] == 'S') {
                            defense = false; break;
                        }
                        else if(medow[new_i][new_j] == 'W' || medow[new_i][new_j] == 'D') continue;
                        else medow[new_i][new_j] = 'D';
                    }
                }
            }
        }

        if(defense) {
            System.out.println("1");
            print(medow);
        }
        else System.out.println("0");
    }
}
