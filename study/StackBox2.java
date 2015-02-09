import java.util.*;
class Box {
    public int h;
    public int w;
    public int d;
    public Box(int h, int w, int d) {
        this.h = h; this.w = w; this.d = d;
    }
    public boolean canBeAbove(Box b) {
        return (this.h < b.h && this.w < b.w && this.d < b.d);
    }

    public void print() {
        System.out.println("h=" + h + ",w=" + w + ",d=" + d);
    }
}

public class StackBox {

    public int height(List<Box> boxes) {
        int sum = 0;
        for(Box box : boxes) {
            sum += box.h;
        }
        return sum;
    }

    public void print(List<Box> boxes) {
        for(Box box : boxes) {
            box.print();
        }
    }

    public List<Box> findMax(List<Box> boxes) {
        int[] dp = new int[boxes.size()];
        dp[0] = box.h;
        for(int i = 1; i < dp.length; i++) {
            dp[i] = box.h;
        }
    }

    public static void main(String args[]) {
        List<Box> boxes = new ArrayList<Box>();
        boxes.add(new Box(3, 9, 7));
        boxes.add(new Box(1, 10, 3));
        boxes.add(new Box(2, 11, 5));
        boxes.add(new Box(4, 12, 8));
        
        StackBox sb = new StackBox();
        List<Box> result = sb.findMax(boxes);
        sb.print(result);
//        System.out.println(sb.findMax(boxes));
    }

}
