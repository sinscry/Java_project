package d_formatter.pojo;

import java.util.Date;

import java.util.Date;
public class GoodsModel {
    private String goodsname;
    private double goodsprice;
    private int goodsnumber;
    private Date goodsdate;
    //省略setter和getter方法

    public void setGoodsdate(Date goodsdate) {
        this.goodsdate = goodsdate;
    }

    public void setGoodsnumber(int goodsnumber) {
        this.goodsnumber = goodsnumber;
    }

    public void setGoodsprice(double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Date getGoodsdate() {
        return goodsdate;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public double getGoodsprice() {
        return goodsprice;
    }

    public int getGoodsnumber() {
        return goodsnumber;
    }
}