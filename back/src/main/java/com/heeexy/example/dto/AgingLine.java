package com.heeexy.example.dto;

import java.io.Serializable;

/**
 * Created by hr-myq on 17-2-7.
 */
public class AgingLine implements Serializable{
    public final static String RUN_STATUS = "bg-run";
    public final static String DOWN_STATUS = "bg-down";

    private Integer id;
    private String name;
    private String description;
    private String lcServerIp;
    private String configName;
    private String status = DOWN_STATUS;

    public AgingLine() {
    }

    public AgingLine(Integer id, String name, String desc, String lcServerIp, String configName) {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.lcServerIp = lcServerIp;
        this.configName = configName;
    }

    public AgingLine(Integer lineId) {
        this.id = lineId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLcServerIp() {
        return lcServerIp;
    }

    public void setLcServerIp(String lcServerIp) {
        this.lcServerIp = lcServerIp;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getStatus() {
        return status;
    }

    /**
     * 设备产线的状态
     * @param status 请使用AgingLine.RUN_STATUS和AgingLine.DOWN_STATUS
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgingLine agingLine = (AgingLine) o;
        return (id != null ? id.equals(agingLine.id) : agingLine.id == null)
                || (lcServerIp != null ? lcServerIp.equals(agingLine.getLcServerIp()) : agingLine.getLcServerIp() == null);

    }

    @Override
    public int hashCode() {
        return (id != null ? id.hashCode() : (lcServerIp != null ? lcServerIp.hashCode() : 0));
    }
}
