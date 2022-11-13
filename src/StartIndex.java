import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartIndex {
    public int[] StartIndex(int[] arr1,int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] res = new int[n];
        int insert = 0;
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                if (arr1[j] == arr2[i]) {
                    res[i] = j + 1 + insert;
                    insert++;
                } else {
                    res[i] = -1;
                }
            }
        }
        return res;
    }
}
