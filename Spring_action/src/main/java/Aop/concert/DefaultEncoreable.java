package Aop.concert;

public class DefaultEncoreable implements Encoreable{
    @Override
    public void performEncore() {
        System.out.println("performEncore");
    }
}
