package org.example;

import java.util.Arrays;

public class radixSort {
    public int getMax(Data arr[], int n, int flag)
    {
        int mx;
        if(flag == 0){
            // sort id
            mx = arr[0].id;
            for(int i=1; i<n; i++){
                mx=Math.max(mx, arr[i].id);
            }
            return mx;
        }else if(flag==1){
            //sort name
            mx = arr[0].name.length();
            for(int i=1; i<n; i++){
                mx=Math.max(mx, arr[i].name.length());
            }
            return mx;
        }

        return 0;
    }
    public void countSort(Data arr[], int n, int digit, int flag)
    {
        Data output[] = new Data[n+1]; // output array
        int i;
        int count[];
        if(flag==0){
            //sort id
            count = new int[10];
            Arrays.fill(count, 0);
            // Store count of occurrences in count[]
            for (i = 0; i < n; i++)
                count[(arr[i].id / digit) % 10]++;
            // Change count[i] so that count[i] now contains
            // actual position of this digit in output[]
            for (i = 1; i < 10; i++)
                count[i] += count[i - 1];
            // Build the output array
            for (i = n - 1; i >= 0; i--) {
                output[count[(arr[i].id / digit) % 10] - 1] = arr[i];
                count[(arr[i].id / digit) % 10]--;
            }
        }else if(flag == 1){
            // sort name
            count = new int[257];
            Arrays.fill(count , 0);
            for (i=0;i<n;i++){
                count[digit<arr[i].name.length() ? (int)arr[i].name.charAt(digit)+1 : 0]++;
            }
            for (i = 1; i < 257; i++)
                count[i] += count[i - 1];
            // Build the output array
            for (i = n - 1; i >= 0; i--) {
                output[count[digit<arr[i].name.length() ? (int)arr[i].name.charAt(digit)+1 : 0] - 1] = arr[i];
                count[digit<arr[i].name.length() ? (int)arr[i].name.charAt(digit)+1 : 0]--;
            }
        }
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
    public void radix_sort(Data arr[], int n, int flag)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n, flag);

        if(flag ==0){
            // sort id
            // Do counting sort for every digit. Note that
            // instead of passing digit number, exp is passed.
            // exp is 10^i where i is current digit number
            for (int digit = 1; m / digit > 0; digit *= 10)
                countSort(arr, n, digit, flag);
        }else if(flag ==1){
            // sort name
            for (int digit = m; digit > 0; digit--)
                countSort(arr, n, digit-1, flag);
        }

    }

    public void print(Data arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i].id + " "+ arr[i].name+ "\n");
    }
}
