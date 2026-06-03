// Find common elements in two arrays

public class interview1 {

    public static boolean itemsInCommon(int[] array1, int[] array2) {

        for (int i : array1) {

            for (int j : array2) {

                if (i == j) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] array1 = {1, 3, 5};
        int[] array2 = {1, 2, 4, 6};

        System.out.println(itemsInCommon(array1, array2));
    }
}