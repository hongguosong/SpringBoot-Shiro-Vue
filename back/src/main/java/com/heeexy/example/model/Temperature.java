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

import java.io.Serializable;
import java.util.Objects;

public class Temperature implements Serializable{
    private int ch1;
    private int ch2;
    private int ch3;
    private int ch4;
    private int ch5;
    private int ch6;
    private int ch7;
    private int ch8;
    private int ch9;
    private int ch10;
    private int ch11;
    private int ch12;
    private int clch1;
    private int clch2;

    public Temperature(int ch1, int ch2, int ch3, int ch4, int ch5, int ch6, int ch7, int ch8, int ch9, int ch10, int ch11, int ch12, int clch1, int clch2) {
        this.ch1 = ch1;
        this.ch2 = ch2;
        this.ch3 = ch3;
        this.ch4 = ch4;
        this.ch5 = ch5;
        this.ch6 = ch6;
        this.ch7 = ch7;
        this.ch8 = ch8;
        this.ch9 = ch9;
        this.ch10 = ch10;
        this.ch11 = ch11;
        this.ch12 = ch12;
        this.clch1 = clch1;
        this.clch2 = clch2;
    }

    public Temperature(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Temperature)) return false;
        Temperature that = (Temperature) o;
        return getCh1() == that.getCh1() &&
                getCh2() == that.getCh2() &&
                getCh3() == that.getCh3() &&
                getCh4() == that.getCh4() &&
                getCh5() == that.getCh5() &&
                getCh6() == that.getCh6() &&
                getCh7() == that.getCh7() &&
                getCh8() == that.getCh8() &&
                getCh9() == that.getCh9() &&
                getCh10() == that.getCh10() &&
                getCh11() == that.getCh11() &&
                getCh12() == that.getCh12() &&
                getClch1() == that.getClch1() &&
                getClch2() == that.getClch2();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCh1(), getCh2(), getCh3(), getCh4(), getCh5(), getCh6(), getCh7(), getCh8(), getCh9(), getCh10(), getCh11(), getCh12(), getClch1(), getClch2());
    }

    public int getCh1() {
        return ch1;
    }

    public void setCh1(int ch1) {
        this.ch1 = ch1;
    }

    public int getCh2() {
        return ch2;
    }

    public void setCh2(int ch2) {
        this.ch2 = ch2;
    }

    public int getCh3() {
        return ch3;
    }

    public void setCh3(int ch3) {
        this.ch3 = ch3;
    }

    public int getCh4() {
        return ch4;
    }

    public void setCh4(int ch4) {
        this.ch4 = ch4;
    }

    public int getCh5() {
        return ch5;
    }

    public void setCh5(int ch5) {
        this.ch5 = ch5;
    }

    public int getCh6() {
        return ch6;
    }

    public void setCh6(int ch6) {
        this.ch6 = ch6;
    }

    public int getCh7() {
        return ch7;
    }

    public void setCh7(int ch7) {
        this.ch7 = ch7;
    }

    public int getCh8() {
        return ch8;
    }

    public void setCh8(int ch8) {
        this.ch8 = ch8;
    }

    public int getCh9() {
        return ch9;
    }

    public void setCh9(int ch9) {
        this.ch9 = ch9;
    }

    public int getCh10() {
        return ch10;
    }

    public void setCh10(int ch10) {
        this.ch10 = ch10;
    }

    public int getCh11() {
        return ch11;
    }

    public void setCh11(int ch11) {
        this.ch11 = ch11;
    }

    public int getCh12() {
        return ch12;
    }

    public void setCh12(int ch12) {
        this.ch12 = ch12;
    }

    public int getClch1() {
        return clch1;
    }

    public void setClch1(int clch1) {
        this.clch1 = clch1;
    }

    public int getClch2() {
        return clch2;
    }

    public void setClch2(int clch2) {
        this.clch2 = clch2;
    }
}
