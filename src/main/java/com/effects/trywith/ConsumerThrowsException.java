package com.effects.trywith;

/**
 * Created by siddhants on 7/21/16.
 */
public interface ConsumerThrowsException<T, E extends Throwable> {
    void accept(T t) throws E;
}
