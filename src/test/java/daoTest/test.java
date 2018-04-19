package daoTest;

import com.alibaba.fastjson.JSON;
import com.superbluecat.ziyue.dao.CommentsDao;
import com.superbluecat.ziyue.entities.UsersEntity;
import com.superbluecat.ziyue.service.CommentsService;
import com.superbluecat.ziyue.service.UsersService;
import com.superbluecat.ziyue.tools.R;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class test {

    @Autowired
    private CommentsDao commentsDao;
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private UsersService usersService;

    @Test
    public void testGetOne() {
        try {
            System.out.println(commentsDao.getOne(1));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }

    @Test
    public void testGet() {
        System.out.println(commentsDao.get(1));
    }

    @Test
    public void testCommentsAdd() {
        System.out.println(commentsService.save("aa", "aa", "asd", "sufh", 4, "asd", "sss"));
    }

    @Test
    public void test1() {
        UsersEntity usersEntity = usersService.get("aa", "aa", "aaaa");
        System.out.println(JSON.toJSONString(R.ok().put("theme", usersEntity)));
    }

    @Test
    public void test2() {
        LocalDateTime sylvester = LocalDateTime.of(2018, 3, 31, 23, 59, 59);
        System.out.println(sylvester);
        System.out.println(sylvester.plusMonths(2));
    }
}
