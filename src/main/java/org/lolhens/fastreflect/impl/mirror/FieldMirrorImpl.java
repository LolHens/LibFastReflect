package org.lolhens.fastreflect.impl.mirror;

import org.lolhens.fastreflect.mirror.FieldMirror;

/**
 * Created by LolHens on 06.07.2015.
 */
public abstract class FieldMirrorImpl<T> implements FieldMirror<T> {
    @Override
    public T invoke(Object instance, Object... args) {
        return getValue();
    }

    @Override
    public void setAccessible(boolean value) {

    }
}
