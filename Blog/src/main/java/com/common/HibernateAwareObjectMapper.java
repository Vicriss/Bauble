/**
 * @title: HibernateAwareObjectMapper.java
 * @package org.cl.websample.common
 * @description: TODO
 * @author imirror707@gmail.com
 * @date 2015�?7�?31�? 下午9:09:06
 * @version V1.0
 */ 
package com.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * @className: HibernateAwareObjectMapper
 * @description: ����ӳټ��ص�ʵ��תJSON����
 * @author imirror707@gmail.com
 * @date 2015��7��31�� ����9:09:06
 *
 */
public class HibernateAwareObjectMapper extends ObjectMapper {

    public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
    }
}