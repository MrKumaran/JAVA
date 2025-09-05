package Learning.GroundZero;


public class overFlow0 {

    public static void main(String[] args) {
        int r = 3, c = 5;
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        int traverse = r + c - 1; // 5
        int i = 0;
        int a = r-1;
        int b = c-1;
        while(i<traverse){
            if(i % 2 == 0){
                    while(a<r && b<c && a>=0 && b>=0){
                        System.out.print(arr[a][b] + " ");
                        a--;
                        b++;
                    }
                    b--;
                    if (a<0) {
                        a++;
                        b--;
                    }
            }
            else {
                while(a<r && b<c && a>=0 && b>=0){
                    System.out.print(arr[a][b] + " ");
                    a++;
                    b--;
                }
                a--;
                if (b<0){
                    a--;
                    b++;
                }
            }
            i++;
        }
    }

    static void pattern(int n){
        int start = 0;
        int k = 1;
        for (int i = 1; i<=n/2 + 1; i++){
            start += i;
            int element = start;
            for (int j = 1; j<=i; j++){
                System.out.print(element-- + " ");
            }
            System.out.println();
        }
        for (int i = n/2+1; i<n; i++){
            int numberOfChar = i - k;
            k+=2;
            start += numberOfChar;
            int element = start;
            for (int j = 1; j<=numberOfChar; j++){
                System.out.print(element-- + " ");
            }
            System.out.println();
        }
    }

    static void leadersInTheArray(int[] arr){
        int arrLength = arr.length;
        int leader = arr[arrLength-1];
        StringBuilder sb = new StringBuilder(String.valueOf(leader));
        for (int i = arrLength-2; i>=0; i--){
            if (leader<arr[i]) {
                leader = arr[i];
                sb.insert(0, leader + " ");
            }
        }
        System.out.println(sb);
    }

    static int missingNumberToN(int[] arr){
        int arrLength = arr.length;
        int sum = arrLength*(arrLength+1)/2;
        for (int i = 0; i< arrLength; i++){
            sum -= arr[i];
        }
        return sum;
    }

    static int uniqueElement(int[] arr){
        int arrLength = arr.length;
        if (arrLength == 0) return -1;
        int unique = arr[0];
        for (int i = 1; i< arr.length; i++) {
            unique^= arr[i];
        }
        return unique;
    }

    static boolean subArr(int[] arr1, int[] arr2){
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer2<arr2.length && pointer1<arr1.length){
            if (arr1[pointer1] == arr2[pointer2]) {
                pointer2++;
                pointer1++;
            } else {
                pointer1++;
            }
        }
        return pointer2==arr2.length;
    }

    static int equilibrium(int[] arr){
        int arrLength = arr.length;
        if (arrLength == 0) return -1;
        int sum = 0;
        int leftSum = 0;
        for (int i: arr) sum+=i;
        for (int i: arr){
            sum -= i;
            if (sum == leftSum) return i;
            leftSum += i;
        }
        return -1;
    }

    static int bitonic(int[] arr){
        int arrLength = arr.length;
        if (arrLength < 2) return -1;
        for (int i = 0; i < arrLength-1; i++){
            if (!(arr[i] <= arr[i+1])) return arr[i];
        }
        return -1;
    }

}
