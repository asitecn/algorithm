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

    public List<Box> findMax(List<Box> boxes, Box bottom) {
        List<Box> max_stack = null;
        int max_height = 0;

        for(int i = 0; i < boxes.size(); i++) {
            if (bottom.canBeAbove(boxes.get(i))) {
                List<Box> new_stack = findMax(boxes, boxes.get(i));
                int new_height = height(new_stack);
                if (max_height < new_height) {
                    max_height = new_height;
                    max_stack = new_stack;
                }
            }
        }

        if (max_stack == null) {
            max_stack = new ArrayList<Box>();
        }
        if (bottom != null) {
            max_stack.add(0,bottom);
        }
        return max_stack;
    }

    public void print(List<Box> boxes) {
        for(Box box : boxes) {
            box.print();
        }
    }

    public List<Box> findMax(List<Box> boxes) {
        return findMax(boxes, boxes.get(0));
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
