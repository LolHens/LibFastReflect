package org.lolhens.fastreflect.mirror;

/**
 * Created by PA on 06.07.2015.
 */
public abstract class InvokableMirror<T> {
    public abstract T invoke(Object instance, Object... args);
}
