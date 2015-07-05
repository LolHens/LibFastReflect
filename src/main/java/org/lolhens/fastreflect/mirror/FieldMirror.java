package org.lolhens.fastreflect.mirror;

/**
 * Created by PA on 05.07.2015.
 */
public class FieldMirror<T> extends InvokableMirror<T> {
    @Override
    public T invoke(Object instance, Object... args) {
        return getValue();
    }

    public void setValue(T value) {

    }

    public T getValue() {
        return null;
    }
}
