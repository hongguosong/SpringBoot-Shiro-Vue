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

public class Yield implements Serializable{
    private int classA;
    private int classB;

    public Yield(int classA, int classB) {
        this.classA = classA;
        this.classB = classB;
    }

    public int getClassA() {
        return classA;
    }

    public void setClassA(int classA) {
        this.classA = classA;
    }

    public int getClassB() {
        return classB;
    }

    public void setClassB(int classB) {
        this.classB = classB;
    }
}
