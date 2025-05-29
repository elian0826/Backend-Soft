package com.estudio.reservas.dto;

import java.util.HashMap;
import java.util.Map;

public class DataGeneral {

    private Map<String, Object> generalData;

    public DataGeneral() {
        this.generalData = new HashMap<>();
    }

    public Map<String, Object> getGeneralData() {
        return generalData;
    }

    public void setGeneralData(Map<String, Object> generalData) {
        this.generalData = generalData;
    }

    public void setData(String key, Object value) {
        if (key != null && value != null) {
            generalData.put(key, value);
        }
    }
}
