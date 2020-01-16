package leetcode;

public class demo423 {


    public static String originalDigits(String s) {
        int[] count = new int[22], nums = new int[10];
        char[] chs = s.toCharArray();
        for (char e : chs) count[e - 'e']++;
        nums[0] = count[21];
        nums[2] = count[18];
        nums[4] = count[16];
        nums[6] = count[19];
        nums[8] = count[2];
        nums[1] = count[10] - (nums[0] + nums[2] + nums[4]);
        nums[3] = count[3] - nums[8];
        nums[7] = count[14] - nums[6];
        nums[5] = count[17] - nums[7];
        nums[9] = count[4] - (nums[5] + nums[6] + nums[8]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) for (int j = 0; j < nums[i]; j++) sb.append(i);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(originalDigits("ereht"));
        System.out.println('i' - 'e');
        System.out.println('w' - 'e');
        System.out.println('u' - 'e');
        System.out.println('x' - 'e');
        System.out.println('g' - 'e');
        System.out.println('o' - 'e');
        System.out.println('h' - 'e');
        System.out.println('s' - 'e');
        System.out.println('v' - 'e');
        System.out.println('n' - 'e');
    }

}
