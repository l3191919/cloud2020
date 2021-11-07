package lyz.com.B_guan_cha_zhe_mo_shi;

import org.springframework.cloud.client.discovery.DiscoveryClient;

public class CurrentConditionsDisplay implements  Observer, DispalyElement {
    //温度
    private float temperature;
    //湿度
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay (Subject subject){
        this.weatherData = subject;
        weatherData.registerObserver(this);
    }


    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }


    @Override
    public void display() {
        System.out.println("温度="+temperature+"humidity="+humidity+"%");
    }

}
