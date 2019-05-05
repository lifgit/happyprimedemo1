package com.javahappyprime.demo1.converter;

public interface PojoConverter<T, S> {

    void toVo(S source, T target);
}
