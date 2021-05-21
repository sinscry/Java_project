package c_type_conversion.pojo;

public class Goods {
    private String goodsname;
    private double goodsprice;
    private int goodsnumber;

    //无参构造方法
    public Goods(){

    }

    //有参数构造方法
    public Goods(String goodsname,double goodsprice, int goodsnumber){
        super();
        this.goodsname=goodsname;
        this.goodsprice=goodsprice;
        this.goodsnumber=goodsnumber;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }
    public void setGoodsprice(double goodsprice){
        this.goodsprice=goodsprice;
    }
    public void setGoodsnumber(int goodsnumber) {
        this.goodsnumber = goodsnumber;
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
