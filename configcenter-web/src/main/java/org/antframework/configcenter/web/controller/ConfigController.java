/* 
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2017-09-14 16:11 创建
 */
package org.antframework.configcenter.web.controller;

import org.antframework.configcenter.facade.api.ConfigService;
import org.antframework.configcenter.facade.order.FindPropertiesOrder;
import org.antframework.configcenter.facade.result.FindPropertiesResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置controller
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    /**
     * 查找应用在特定环境中的配置
     *
     * @param appCode        应用编码
     * @param queriedAppCode 被查询配置的应用编码
     * @param profileCode    环境编码
     */
    @RequestMapping("/findProperties")
    public FindPropertiesResult findProperties(String appCode, String queriedAppCode, String profileCode) {
        FindPropertiesOrder order = new FindPropertiesOrder();
        order.setAppCode(queriedAppCode);
        order.setProfileCode(profileCode);
        order.setOnlyOutward(!StringUtils.equals(queriedAppCode, appCode));

        return configService.findProperties(order);
    }
}
