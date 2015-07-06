package org.lolhens.fastreflect;

import org.lolhens.fastreflect.impl.MirrorClassLoader;
import org.lolhens.fastreflect.impl.MirrorCompiler;
import org.lolhens.fastreflect.mirror.FieldMirror;
import org.lolhens.fastreflect.mirror.MethodMirror;

/**
 * Created by LolHens on 05.07.2015.
 */
public class FastReflect {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<MethodMirror> clazz = new MirrorClassLoader().defineClass("org.lolhens.fastreflect.impl.mirror.Test2", MirrorCompiler.compile());

        clazz.newInstance().invoke(null);
    }

    public static void test() {
        System.out.println("TEST!!!");
    }

    public static FieldMirror getFieldMirror(Class<?> target, String name) {
        return null;
    }
}
