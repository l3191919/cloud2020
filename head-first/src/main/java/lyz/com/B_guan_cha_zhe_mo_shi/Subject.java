package lyz.com.B_guan_cha_zhe_mo_shi;

public interface Subject {
    //注册
    public void registerObserver(Observer o);
    //删除
    public void removeObserver(Observer o);
    //通知
    public void notifyObserver();
}
