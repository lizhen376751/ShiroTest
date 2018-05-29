package com.shiro.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/29.
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        Map map = new LinkedHashMap();
        //认证过滤器
        //拦截所有请求
        map.put("/**","authc");

        //放权
        map.put("/fangquanUser","anon");

        //添加认证过滤器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        //修改登录请求
//        shiroFilterFactoryBean.setLoginUrl("/editUser");

        //关联Manager
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        return  shiroFilterFactoryBean;
    }
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(MyReaml myReaml){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myReaml);
        return  defaultWebSecurityManager;
    }
    @Bean
    public MyReaml getMyReaml(){
        MyReaml myReaml = new MyReaml();
        return myReaml;
    }
}
