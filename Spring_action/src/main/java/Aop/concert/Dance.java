package Aop.concert;

public class Dance implements Performance{
    @Override
    public void perform() {
        System.out.println("Dancing");
    }
}
