package com.wenbin.base.genrice.my;

/**
 * Created by wenbin on 2017/12/30.
 */
public interface GenericInterface<T, E> {
    T get(E e);
}
