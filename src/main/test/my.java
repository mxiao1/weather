import com.xiao.dao.Base;
import com.xiao.pojo.Student;
import com.xiao.service.JedisClientSingle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/spring/spring-*.xml")
public class my {
    @Autowired
    private Base base;

    @Autowired
    private JedisClientSingle jedisClientSingle;

    @Test
    public void addTest(){
//        String s = jedisClientSingle.set("xiao", "12345");
//        System.out.println(s);
//        String s1 = jedisClientSingle.get("xiao");
//        System.out.println(s1);
        List<String> list = new ArrayList<>();
        list.add("-");
        list.add("-");
        list.add("xiao");
        for (int i =0 ;i <list.size(); i++){
            if ("-".equals(list.get(i))){
                list.add(i, list.get(i).replace("-", "null"));;
            }
        }
        System.out.println(list);
    }

}
