package dev.przetrwaj.przetrwajapi.report;

public class ReportTypeDAO {
    private String typeName;
    private String typeDescription;

    public ReportTypeDAO(String typeName, String typeDescription) {
        this.typeName = typeName;
        this.typeDescription = typeDescription;
    }

    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getTypeDescription() {
        return typeDescription;
    }
    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public ReportType convertFromDAO() {
        return new ReportType(this.typeName, this.typeDescription);
    }
}
