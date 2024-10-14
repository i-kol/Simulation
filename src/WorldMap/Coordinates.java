package WorldMap;

import java.util.Objects;

public class Coordinates {
    public static Integer rowCount;
    public static Integer columnCount;

    public Coordinates(Integer rowCount, Integer columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return rowCount.equals(that.rowCount) && columnCount.equals(that.columnCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowCount, columnCount);
    }
}
