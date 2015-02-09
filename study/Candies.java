public class Candies {
   
    int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for(int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
                System.out.println(candies[i]);
            }
        }
        for(int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        int sum = 0;
        for(int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }
        return sum + ratings.length;
    } 

    public static void main(String args[]) {
        Candies c = new Candies();
        int[] ratings = new int[]{1,3,5};
//        int[] ratings = new int[]{7,4,1,5,3,2,6};
//        int[] ratings = new int[20000];
//        for(int i = 0; i < 20000; i++) {
//            ratings[i] = i+1;
//        }
        System.out.println(c.candy(ratings));
    }
}
