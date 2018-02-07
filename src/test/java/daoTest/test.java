package daoTest;

import com.superbluecat.ziyue.dao.CommentsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class test {

    @Autowired
    private CommentsDao commentsDao;

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
}