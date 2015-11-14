/**
 * @title: HibernateAwareObjectMapper.java
 * @package org.cl.websample.common
 * @description: TODO
 * @author imirror707@gmail.com
 * @date 2015骞?7鏈?31鏃? 涓嬪崍9:09:06
 * @version V1.0
 */ 
package com.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * @className: HibernateAwareObjectMapper
 * @description: 解决延迟加载的实体转JSON报错
 * @author imirror707@gmail.com
 * @date 2015年7月31日 下午9:09:06
 *
 */
public class HibernateAwareObjectMapper extends ObjectMapper {

    public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
    }
}