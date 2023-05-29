import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class test {

    @Test
    public void aaa() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        List<String> list = new ArrayList<>();

        String classAllPath="com.atguigu.springcloud.entities.UserData";
//1.获取Car类 对应的 Class 对象
//        <?> 表示不确定的Java类型
        Class<?> cls = Class.forName(classAllPath);
//        2.输出 cls
        System.out.println(cls);//显示cls对象，是哪个类的Class对象;  class com.hsp.Car
        System.out.println(cls.getClass());//输出cls运行类型;class java.lang.Class
//        3.得到包名
        System.out.println(cls.getPackage().getName());//包名
//        4.得到全类名
        System.out.println(cls.getName());
//        5.通过 cls 创建对象实例
        Object o = cls.newInstance();
        System.out.println(o);//car.toString
        List<String> listString1 = new ArrayList();
        listString1.add("name");
        listString1.add("type");
        listString1.add("aa");
        listString1.add("bb");
        listString1.add("cc");
        List<String> listString2 = new ArrayList();
        listString2.add("name");
        listString2.add("type");
        listString2.add("aa");
        listString2.add("bb");
        listString2.add("cc");

         for(int i = 0;listString1.size()>i;i++){
             Field item = cls.getDeclaredField(listString1.get(i));
             item.setAccessible(true);
             item.set(o,listString2.get(i));

         }
         log.info(JSON.toJSONString(o));
//        Field name = cls.getField("name");
//        Field type = cls.getField("type");
//        Field aa = cls.getField("aa");
//        Field bb = cls.getField("bb");
//        Field cc = cls.getField("cc");


//        7.通过反射给属性赋值
//        name.set(o,"刘");
//        type.set(o,"男");
//        aa.set(o,"啊啊啊");
//        bb.set(o,"不不不");
//        cc.set(o,"冲冲冲");



//        8.得到所有的属性
//        Field[] fields = cls.getFields();
//        for (Field field : fields) {
//            System.out.println(field.getName());
//        }
    }
}
