using System;
using static System.Console;

class Program
{
    public static int n;
    public static bool check(int[] arr, int evg)
    {
        for (int i = 0; i < n; i++)
            if (arr[i] < evg) return false;
        return true;
    }
    public static void Main(string[] args)
    {
        n = int.Parse(ReadLine());
        int[] arr = new int[n];
        long sum = 0;
        int max = 0;
        string[] s = ReadLine().Split(' ');
        for (int i = 0; i < n; i++)
        {
            arr[i] = int.Parse(s[i]);
            if (max < arr[i]) max = arr[i];
            sum += arr[i];
        }
        
        Array.Sort(arr);    

        int total = int.Parse(ReadLine());
        int evg = total / n;
        
        if(sum <= total) WriteLine(max);
        else if(check(arr, evg)) WriteLine(evg);
        else
        {   
            int start = 0;
            int end = 0;
            int mid = 0;
            // start, end 정하기
            for(int i = 0; i < n-1 ;i++){
                int norm1 = arr[i];
                int norm2 = arr[i+1];
                int sum1 = 0;
                int sum2 = 0;
                for(int j = 0; j < n; j++){
                    if(arr[j] > norm1) sum1 += norm1;
                    else sum1 += arr[j];
                    if(arr[j] > norm2) sum2 += norm2;
                    else sum2 += arr[j];
                }
                if(sum1 <= total && total <= sum2){
                    start = norm1;
                    end = norm2;
                }
            }
            while(end - start > 1){
                int max_sum = 0;
                mid = (start + end) / 2;
                
                for(int i = 0; i< n; i++){
                    if(arr[i] > mid) max_sum += mid;
                    else max_sum += arr[i];
                }
                if(max_sum > total) end = mid;
                else start = mid;
            }
            WriteLine(start);
        }
    }
}