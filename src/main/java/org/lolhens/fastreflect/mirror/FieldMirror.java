package org.lolhens.fastreflect.mirror;

/**
 * Created by LolHens on 05.07.2015.
 */
public interface FieldMirror<T> extends InvokableMirror<T> {
    public void setValue(T value);

    public T getValue();
}
