package com.example.tarlascraping1.ModelsDTO;

import com.example.tarlascraping1.Models.FieldProcessModel;
import com.example.tarlascraping1.Models.OtherCostsModels;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class FieldProccesDTO {

    private String plantType;
    private String fieldStatus;
    private String fieldType;
    private String axplanation;
    private int  unitFuelCost;
    private OtherCostsModels otherCostsModels;


    public FieldProcessModel FieldProccesDTOMapping (FieldProccesDTO fieldProccesDTO){
        FieldProcessModel fieldProcessModel = new FieldProcessModel();
        fieldProcessModel.setPlantType(fieldProccesDTO.getPlantType());
        fieldProcessModel.setFieldStatus(fieldProccesDTO.getFieldStatus());
        fieldProcessModel.setFieldType(fieldProccesDTO.getFieldType());
        fieldProcessModel.setAxplanation(fieldProccesDTO.getAxplanation());
        fieldProcessModel.setUnitFuelCost(fieldProccesDTO.getUnitFuelCost());
        fieldProcessModel.getOtherCostsModels().add(fieldProccesDTO.getOtherCostsModels());
        fieldProcessModel.setDate(LocalDateTime.now());
        return fieldProcessModel;
    }
}