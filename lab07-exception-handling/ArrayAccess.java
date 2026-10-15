public class ArrayAccess {

    static int getElement(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index " + index + " is out of range");
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 10, 15};
        System.out.println(getElement(nums, 1));
        System.out.println(getElement(nums, 7));
    }
}