package tutorial;

import java.util.Objects;

public class Disc {

    private int size;

    Disc(int size) {
        this.size = size;
    }

    //do we need to expose?
    int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disc disc = (Disc) o;
        return size == disc.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }
}
