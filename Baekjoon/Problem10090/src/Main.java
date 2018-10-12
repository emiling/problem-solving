import java.util.Scanner;

public class Main {
     public static final Scanner scanner = new Scanner(System.in);

     public static long getNumberOfInversions(int[] data){
         int n = data.length;
         int[] buffer = new int[n];
         return getNumberOfInversions(data,0,n-1, buffer);
     }

     public static long getNumberOfInversions(int[] data, int left, int right, int[] buffer) {
         if(left >= right) return 0;

         long count = 0;
         int mid = (right+left)/2;
         count += getNumberOfInversions(data,left,mid,buffer);
         count += getNumberOfInversions(data, mid+1, right, buffer);

         //merging
         int i = left;
         int j = mid+1;
         int k = left;

         while(i <= mid && j <= right) {
             if(data[i] < data[j]) {
                 buffer[k++] = data[i++];
             }else{
                 buffer[k++] = data[j++];
                 int remain = mid-i+1;
                 count += remain;
             }
         }

         while (i <= mid) buffer[k++] = data[i++];
         while (j <= right) buffer[k++] = data[j++];

         for(int idx = left; idx <= right ; idx++) {
             data[idx] = buffer[idx];
         }

         return count;
     }

     public static void main(String[] args) {
         int n = scanner.nextInt();
         int[] data = new int[n];
         for(int i = 0 ; i < n ; i++){
             data[i] = scanner.nextInt();
         }
         long answer = getNumberOfInversions(data);
         System.out.println(answer);
     }
}
