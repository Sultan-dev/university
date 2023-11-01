public class Main {
    public static int[] a = new int[]{32,65,40,11,18,29,37,32,53};

    public static void main(String[] args) {
        quickSort(a, 0, a.length-1);
        System.out.println();
        for (int h = 0; h < a.length; h++){
            System.out.print(a[h]+",");
        }
    }

    public static void quickSort(int[] a, int low, int high){
        if(low < high) {
            int w = split(a, low, high);
            System.out.println(w);
            quickSort(a, low, w - 1);
            quickSort(a, w + 1, high);
        }
    }

    public static int split(int[] a,int low, int high){
        int i = low;
        int x = a[low];

        int k;
        int z;
        for(int j = low + 1; j <= high; j++){
            if(a[j] <= x){
                i = i+1;
                if (i != j){
                    k = a[i];
                    z = a[j];
                    a[i] = z;
                    a[j] = k;
                }
            }
        }
        k = a[i];
        z = a[low];
        a[i] = z;
        a[low] = k;

        for (int h = 0; h < a.length; h++){
            System.out.print(a[h]+",");
        }
        System.out.println();

        return i;
    }
}