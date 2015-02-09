// A circus is designing a tower routine consisting of people standing atop one another’s shoulders. 
// For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. 
// Given the heights and weights of each person in the circus, write a method to compute the largest possible number of people in such a tower.
// EXAMPLE:
// Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
// Output: The longest tower is length 6 and includes from top to bottom: (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)


import java.util.*;
class HtWt {
    int height;
    int weight;
    public HtWt(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
    public void print() {
        System.out.println(height + "\t" + weight);
    }
    public boolean isFit(HtWt hw) {
        return (height < hw.height && weight < hw.weight);
    }

    public boolean isBefore(HtWt hw) {
        if (height < hw.height) {
            return true;
        }
        if (height == hw.height) {
            return (weight < hw.weight);
        }
        return false;
    }

    public boolean isEqual(HtWt hw) {
        return (height == hw.height && weight == hw.weight);
    }
}

public class HeightWeight {
    ArrayList<HtWt> items;
    ArrayList<HtWt> lastFoundSeq;
    ArrayList<HtWt> maxSeq;

    public HeightWeight(ArrayList<HtWt> items) {
        this.items = items;
        lastFoundSeq = new ArrayList<HtWt>();
        maxSeq = new ArrayList<HtWt>();
    }

    // Returns longer sequence
    ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1,
            ArrayList<HtWt> seq2) {
        return seq1.size() > seq2.size() ? seq1 : seq2;
    }

    // Fills next seq w decreased wts&returns index of 1st unfit item.
    int fillNextSeq(int startFrom, ArrayList<HtWt> seq) {
        int firstUnfitItem = startFrom;
        System.out.println("firstUnfitItem=" + firstUnfitItem);
        boolean isFirst = true;
        if (startFrom < items.size()) {
            HtWt lastItem = null;
            for (int i = 0; i < items.size(); i++) {
                HtWt item = items.get(i);
                if (i == 0 || lastItem.isFit(item)) {
                    seq.add(item);
                    lastItem = item;
                } else {
                    if (isFirst) {
                        firstUnfitItem = i;
                        isFirst = false;
                    }
                }
            }
        }
        return firstUnfitItem;
    }

    // Find the maximum length sequence
    public void findMaxSeq() {
        Collections.sort(items, new Comparator<HtWt>() {
            @Override
            public int compare(HtWt hw1, HtWt hw2) {
                if (hw1.isEqual(hw2)) {
                    return 0;
                }
                if (hw1.isBefore(hw2)) {
                    return -1;
                }
                return 1;
            }
        });
        int currentUnfit = 0;
        while (currentUnfit < items.size()) {
            ArrayList<HtWt> nextSeq = new ArrayList<HtWt>();
            int nextUnfit = fillNextSeq(currentUnfit, nextSeq);
            maxSeq = seqWithMaxLength(maxSeq, nextSeq);
            if (nextUnfit == currentUnfit) break;
            else currentUnfit = nextUnfit;
        }
    }

    public void print() {
        for(HtWt hw : maxSeq) {
            hw.print();
        }
    }

    public static void main(String args[]) {
        ArrayList<HtWt> items = new ArrayList<HtWt>();
        items.add(new HtWt(65, 100));
        items.add(new HtWt(70, 150));
        items.add(new HtWt(56, 90));
        items.add(new HtWt(75, 190));
        items.add(new HtWt(60, 95));
        items.add(new HtWt(68, 110));
        items.add(new HtWt(75, 80));
        items.add(new HtWt(80, 1));

        HeightWeight hw = new HeightWeight(items);
        hw.findMaxSeq();
        hw.print();
    }
}
