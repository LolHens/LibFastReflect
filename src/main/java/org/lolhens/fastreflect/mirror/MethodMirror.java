package org.lolhens.fastreflect.mirror;

import java.lang.reflect.Method;

/**
 * Created by PA on 05.07.2015.
 */
public class MethodMirror<T> extends InvokableMirror<T> {
    public MethodMirror(Class<?> target, String name, Class<?>... argumentTypes) {

    }

    public MethodMirror(Class<?> target, Class<T> returnType, Class<?>... argumentTypes) {
        this(target, findMethodWithSignature(target, returnType, argumentTypes), argumentTypes);
    }

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
    public T invoke(Object instance, Object... args) {
        return null;
    }
}
