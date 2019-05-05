package com.javahappyprime.demo1.converter.impl;

import com.javahappyprime.demo1.converter.PojoConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SimpleConverter<T, S> implements PojoConverter<T, S> {

    @Override
    public void toVo(S source, T target) {
        if (source == null || target == null) {
            return;
        }
        BeanUtils.copyProperties(source, target);
    }
}
