package dev.przetrwaj.przetrwajapi.report.type;

public class ReportTypeDTO {
    private String typeName;
    private String typeDescription;

    public ReportTypeDTO(String typeName, String typeDescription) {
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

    public ReportType convertFromDTO() {
        return new ReportType(this.typeName, this.typeDescription);
    }
}
