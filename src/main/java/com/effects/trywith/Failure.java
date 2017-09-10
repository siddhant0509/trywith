package com.effects.trywith;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by siddhants on 7/21/16.
 */
public class Failure<T> implements Try<T> {
    private Throwable throwable;

    public Failure(Throwable throwable){
        this.throwable = throwable;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public boolean isFailure() {
        return true;
    }

    @Override
    public T get() {
        throw new RuntimeException(throwable);
    }

    @Override
    public <R> Try<R> map(Function<? super T, R> fn) {
        return (Try<R>) this;
    }

    @Override
    public <R> Try<R> flatMap(Function<? super T, Try<R>> function) {
        return (Try<R>) this;
    }

    @Override
    public void forEach(Consumer<? super T> fn) {

    }

    @Override
    public void forEachFailure(Consumer<Throwable> fn) { //This can throw exceptions. Todo
        fn.accept(throwable);
    }

    @Override
    public <R> Try<R> recover(Function<Throwable, R> fn) {
        Objects.requireNonNull(fn);
        try{
            return new Success<>(fn.apply(throwable));
        }catch (Throwable throwable){
            return new Failure<>(throwable);
        }
    }

    @Override
    public <R> Try<R> recoverMap(Function<Throwable, Try<R>> fn) {
        Objects.requireNonNull(fn);
        try{
            return fn.apply(throwable);
        }catch (Throwable throwable){
            return new Failure<>(throwable);
        }
    }


}
