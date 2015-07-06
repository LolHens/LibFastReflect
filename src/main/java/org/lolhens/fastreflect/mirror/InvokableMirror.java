package org.lolhens.fastreflect.mirror;

/**
 * Created by LolHens on 06.07.2015.
 */
public interface InvokableMirror<T> {
    T invoke(Object instance, Object... args);

    void setAccessible(boolean value);
}
