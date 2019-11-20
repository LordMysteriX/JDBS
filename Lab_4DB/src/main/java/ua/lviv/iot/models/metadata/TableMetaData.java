package ua.lviv.iot.models.metadata;

import java.util.ArrayList;
import java.util.List;

public class TableMetaData {
    private String dBName;
    private String tableName;
    private List<ColumnMetaData> columnMetaData = new ArrayList<>();
    private List<ua.lviv.iot.models.metadata.ForeignKeyMetaData> foreignKeyList = new ArrayList<>();

    public String getDBName() {
        return dBName;
    }

    public void setDBName(final String dBName) {
        this.dBName = dBName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnMetaData> getColumnMetaData() {
        return columnMetaData;
    }

    public void setColumnMetaData(final List<ColumnMetaData> columnMetaData) {
        this.columnMetaData = columnMetaData;
    }

    public List<ua.lviv.iot.models.metadata.ForeignKeyMetaData> getForeignKeyList() {
        return foreignKeyList;
    }

    public void setForeignKeyList(final List<ua.lviv.iot.models.metadata.ForeignKeyMetaData> foreignKeyList) {
        this.foreignKeyList = foreignKeyList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TABLE: ").append(tableName).append("\n");
        for (ColumnMetaData column : columnMetaData) {
            stringBuilder.append(column).append("\n");
        }
        for (ua.lviv.iot.models.metadata.ForeignKeyMetaData fk : foreignKeyList) {
            stringBuilder.append(fk).append("\n");
        }
        return stringBuilder.toString();
    }
}