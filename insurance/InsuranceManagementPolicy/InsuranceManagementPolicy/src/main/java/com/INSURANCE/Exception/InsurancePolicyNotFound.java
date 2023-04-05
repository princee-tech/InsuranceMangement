package com.INSURANCE.Exception;





public class InsurancePolicyNotFound extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private long fieldValue;

    public InsurancePolicyNotFound(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s with %s number %s not found",resourceName,fieldName,fieldValue));
        this.resourceName= resourceName;
        this.fieldName= fieldName;
        this.fieldValue= fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }


}
