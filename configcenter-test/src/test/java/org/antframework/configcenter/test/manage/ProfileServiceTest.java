/* 
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2017-09-03 16:40 创建
 */
package org.antframework.configcenter.test.manage;

import org.antframework.common.util.facade.EmptyResult;
import org.antframework.common.util.facade.Status;
import org.antframework.configcenter.facade.api.ProfileService;
import org.antframework.configcenter.facade.order.AddOrModifyProfileOrder;
import org.antframework.configcenter.facade.order.DeleteProfileOrder;
import org.antframework.configcenter.facade.order.FindAllProfileOrder;
import org.antframework.configcenter.facade.order.QueryProfileOrder;
import org.antframework.configcenter.facade.result.FindAllProfileResult;
import org.antframework.configcenter.facade.result.QueryProfileResult;
import org.antframework.configcenter.test.AbstractTest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
@Ignore
public class ProfileServiceTest extends AbstractTest {
    @Autowired
    private ProfileService profileService;

    @Test
    public void testAddOrModifyProfile() {
        AddOrModifyProfileOrder order = new AddOrModifyProfileOrder();
        order.setProfileCode("dev");
        order.setMemo("开发环境");
        EmptyResult result = profileService.addOrModifyProfile(order);
        checkResult(result, Status.SUCCESS);
    }

    @Test
    public void testDeleteProfile() {
        DeleteProfileOrder order = new DeleteProfileOrder();
        order.setProfileCode("dev");
        EmptyResult result = profileService.deleteProfile(order);
        checkResult(result, Status.SUCCESS);
    }

    @Test
    public void testFindAllProfile() {
        FindAllProfileResult result = profileService.findAllProfile(new FindAllProfileOrder());
        checkResult(result, Status.SUCCESS);
    }

    @Test
    public void testQueryProfile() {
        QueryProfileOrder order = new QueryProfileOrder();
        order.setPageNo(1);
        order.setPageSize(10);
        order.setProfileCode("dev");
        QueryProfileResult result = profileService.queryProfile(order);
        checkResult(result, Status.SUCCESS);
    }
}
