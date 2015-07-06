package org.lolhens.fastreflect.impl;

/**
 * Created by LolHens on 06.07.2015.
 */
public class MirrorClassLoader extends ClassLoader {
    public Class defineClass(String name, byte[] b) {
        return defineClass(name, b, 0, b.length);
    }
}
