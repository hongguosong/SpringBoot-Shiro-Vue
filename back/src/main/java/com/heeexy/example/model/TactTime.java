package com.heeexy.example.model;/*
 * <p>项目名称: SpringBoot-Shiro-Vue </p>
 * <p>包名称: com.heeexy.example.model </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2019/4/9 </p>
 * <p>公司信息: 苏州鸿然信息科技有限公司</p>
 * @author <a href="mail to: 994662950@qq.com" rel="nofollow">ALEX</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */

public class TactTime {
    private int assy;
    private int fusing;
    private int aoi;
    private int agingIn;
    private int agingOut;
    private int agingInsp;
    private int aoi01;
    private int aoi02;
    private int ft;

    public TactTime(int assy, int fusing, int aoi, int agingIn, int agingOut, int agingInsp, int aoi01, int aoi02, int ft) {
        this.assy = assy;
        this.fusing = fusing;
        this.aoi = aoi;
        this.agingIn = agingIn;
        this.agingOut = agingOut;
        this.agingInsp = agingInsp;
        this.aoi01 = aoi01;
        this.aoi02 = aoi02;
        this.ft = ft;
    }

    public TactTime() {
    }

    public int getAssy() {
        return assy;
    }

    public void setAssy(int assy) {
        this.assy = assy;
    }

    public int getFusing() {
        return fusing;
    }

    public void setFusing(int fusing) {
        this.fusing = fusing;
    }

    public int getAoi() {
        return aoi;
    }

    public void setAoi(int aoi) {
        this.aoi = aoi;
    }

    public int getAgingIn() {
        return agingIn;
    }

    public void setAgingIn(int agingIn) {
        this.agingIn = agingIn;
    }

    public int getAgingOut() {
        return agingOut;
    }

    public void setAgingOut(int agingOut) {
        this.agingOut = agingOut;
    }

    public int getAgingInsp() {
        return agingInsp;
    }

    public void setAgingInsp(int agingInsp) {
        this.agingInsp = agingInsp;
    }

    public int getAoi01() {
        return aoi01;
    }

    public void setAoi01(int aoi01) {
        this.aoi01 = aoi01;
    }

    public int getAoi02() {
        return aoi02;
    }

    public void setAoi02(int aoi02) {
        this.aoi02 = aoi02;
    }

    public int getFt() {
        return ft;
    }

    public void setFt(int ft) {
        this.ft = ft;
    }
}
