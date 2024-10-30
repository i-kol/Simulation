package WorldMap;

import java.util.Objects;

public class Coordinates {
    private final int rowCount;
    private final int columnCount;

    public Coordinates(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return rowCount == that.rowCount && columnCount == that.columnCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowCount, columnCount);
    }
}