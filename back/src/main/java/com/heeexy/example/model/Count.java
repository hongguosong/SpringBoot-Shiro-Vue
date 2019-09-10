package com.heeexy.example.model;/*
 * <p>项目名称: SpringBoot-Shiro-Vue </p>
 * <p>包名称: com.heeexy.example.model </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2019/4/11 </p>
 * <p>公司信息: 苏州鸿然信息科技有限公司</p>
 * @author <a href="mail to: 994662950@qq.com" rel="nofollow">ALEX</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */

public class Count {
    private int totalPanels;
    private int agingPanels;
    private int totalPallets;
    private int agingPallets;
    private int processPallets;
    private int completedPallets;
    private int overtimePallets;
    private int emptyPallets;

    public Count() {
    }

    public Count(int totalPanels, int agingPanels, int totalPallets, int agingPallets, int processPallets, int completedPallets, int overtimePallets, int emptyPallets) {
        this.totalPanels = totalPanels;
        this.agingPanels = agingPanels;
        this.totalPallets = totalPallets;
        this.agingPallets = agingPallets;
        this.processPallets = processPallets;
        this.completedPallets = completedPallets;
        this.overtimePallets = overtimePallets;
        this.emptyPallets = emptyPallets;
    }

    public int getTotalPanels() {
        return totalPanels;
    }

    public void setTotalPanels(int totalPanels) {
        this.totalPanels = totalPanels;
    }

    public int getAgingPanels() {
        return agingPanels;
    }

    public void setAgingPanels(int agingPanels) {
        this.agingPanels = agingPanels;
    }

    public int getTotalPallets() {
        return totalPallets;
    }

    public void setTotalPallets(int totalPallets) {
        this.totalPallets = totalPallets;
    }

    public int getAgingPallets() {
        return agingPallets;
    }

    public void setAgingPallets(int agingPallets) {
        this.agingPallets = agingPallets;
    }

    public int getProcessPallets() {
        return processPallets;
    }

    public void setProcessPallets(int processPallets) {
        this.processPallets = processPallets;
    }

    public int getCompletedPallets() {
        return completedPallets;
    }

    public void setCompletedPallets(int completedPallets) {
        this.completedPallets = completedPallets;
    }

    public int getOvertimePallets() {
        return overtimePallets;
    }

    public void setOvertimePallets(int overtimePallets) {
        this.overtimePallets = overtimePallets;
    }

    public int getEmptyPallets() {
        return emptyPallets;
    }

    public void setEmptyPallets(int emptyPallets) {
        this.emptyPallets = emptyPallets;
    }
}
