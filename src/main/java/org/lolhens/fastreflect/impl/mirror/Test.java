package org.lolhens.fastreflect.impl.mirror;

import org.lolhens.fastreflect.FastReflect;

/**
 * Created by LolHens on 06.07.2015.
 */
public class Test extends MethodMirrorImpl<Void> {
    @Override
    public Void invoke(Object instance, Object... args) {
        FastReflect.test();
        return null;
    }
}
