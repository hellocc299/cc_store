package com.cc;

import com.cc.repository.StaffMenusRepository;
import com.cc.entity.StaffLogin;
import com.cc.entity.StaffMenus;
import com.cc.service.StaffLoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author CC
 * @Date 2022/11/14
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestStaffLogin.class)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@EntityScan("com.cc.repository")
public class TestStaffLogin {
    @Autowired
    private StaffMenusRepository staffMenusRepository;

    @Autowired
    private StaffLoginService staffLoginService;

    @Test
    @Transactional  //开启事务
    @Rollback(false)//设置为不回滚
    public void OneToManyTest() {
        StaffMenus staffMenus1 = new StaffMenus();
        staffMenus1.setMenu("售卖情况");
        staffMenus1.setUrl("/common/salesStatus");

        StaffMenus staffMenus2 = new StaffMenus();
        staffMenus2.setMenu("订单查询");
        staffMenus2.setUrl("/common/order");

        StaffMenus staffMenus3 = new StaffMenus();
        staffMenus3.setMenu("员工管理");
        staffMenus3.setUrl("/admin/staffManage");

        StaffMenus staffMenus4 = new StaffMenus();
        staffMenus4.setMenu("库存管理");
        staffMenus4.setUrl("/common/stockManage");

        StaffMenus staffMenus5 = new StaffMenus();
        staffMenus5.setMenu("价格管理");
        staffMenus5.setUrl("/common/priceManage");

        StaffLogin login1 = new StaffLogin();
        login1.setUsername("admin");
        login1.setPassword("123456admin");

        login1.getStaffMenus().add(staffMenus1);
        login1.getStaffMenus().add(staffMenus2);
        login1.getStaffMenus().add(staffMenus3);
        login1.getStaffMenus().add(staffMenus4);
        login1.getStaffMenus().add(staffMenus5);
        staffLoginService.addStaffLogin(login1);

        StaffLogin login2 = new StaffLogin();
        login2.setUsername("staff");
        login2.setPassword("123456staff");

        login2.getStaffMenus().add(staffMenus1);
        login2.getStaffMenus().add(staffMenus2);
        login2.getStaffMenus().add(staffMenus4);
        login2.getStaffMenus().add(staffMenus5);

        staffLoginService.addStaffLogin(login2);


        staffMenusRepository.save(staffMenus1);
        staffMenusRepository.save(staffMenus1);
        staffMenusRepository.save(staffMenus2);
        staffMenusRepository.save(staffMenus3);
        staffMenusRepository.save(staffMenus4);

    }
}
