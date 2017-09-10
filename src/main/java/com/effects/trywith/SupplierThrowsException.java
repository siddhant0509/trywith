package com.effects.trywith;
/**
 * Created by siddhants on 7/21/16.
 */
public interface SupplierThrowsException<T, E extends Throwable> {
    T get() throws E;
}
