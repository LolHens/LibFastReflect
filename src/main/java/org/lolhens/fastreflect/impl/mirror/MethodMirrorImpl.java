package org.lolhens.fastreflect.impl.mirror;

import org.lolhens.fastreflect.mirror.MethodMirror;

import java.lang.reflect.Method;

/**
 * Created by LolHens on 06.07.2015.
 */
public abstract class MethodMirrorImpl<T> implements MethodMirror<T> {
    /*public MethodMirrorImpl(Class<?> target, String name, Class<?>... argumentTypes) {

    }

    public MethodMirrorImpl(Class<?> target, Class<T> returnType, Class<?>... argumentTypes) {
        this(target, findMethodWithSignature(target, returnType, argumentTypes), argumentTypes);
    }*/

    private static String findMethodWithSignature(Class<?> target, Class<?> returnType, Class<?>[] argumentTypes) {
        String name = null;

        for (Method method: target.getMethods()) {
            if (method.getReturnType().equals(returnType) && method.getParameterTypes().equals(argumentTypes)) {
                if (name == null) {
                    name = method.getName();
                } else {
                    throw new RuntimeException("More than one method with matching signature found!");
                }
            }
        }

        return name;
    }

    @Override
    public void setAccessible(boolean value) {

    }
}
