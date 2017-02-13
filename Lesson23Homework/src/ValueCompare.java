
/**
 * Created by Pavel Pavlov on 2/7/2017.
 */
public class ValueCompare implements Comparable<ValueCompare> {
    private Character chars;
    private int value;

    public ValueCompare(Character chars, int value) {
        this.chars = chars;
        this.value = value;
    }

    @Override
    public int compareTo(ValueCompare o) {
        if(this.value == o.value){
            return this.chars.compareTo(o.chars);
        }
        return (this.value - o.value)*-1;
    }

    public int getValue() {
        return value;
    }

    public Character getKey() {
        return chars;
    }
}
