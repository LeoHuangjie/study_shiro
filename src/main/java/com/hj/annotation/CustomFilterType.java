package com.hj.annotation;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author huangjie
 * @time 2019-06-06 13:56
 */
public class CustomFilterType implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类的注解源信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //获取当前类的class源信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        //获取当前类的资源信息
        Resource resource = metadataReader.getResource();

        if (classMetadata.getClassName().equals("dao")) {
        }
        return false;
    }
}
