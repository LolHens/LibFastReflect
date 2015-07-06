package org.lolhens.fastreflect.impl;

import org.lolhens.fastreflect.impl.mirror.MethodMirrorImpl;
import org.objectweb.asm.*;

import java.util.function.Consumer;

/**
 * Created by LolHens on 06.07.2015.
 */
public class MirrorCompiler implements Opcodes {
    public static byte[] compile() {
        try {
            return dump("org/lolhens/fastreflect/impl/mirror/Test2", Type.getType(Void.class), Type.getType(MethodMirrorImpl.class), (mv) -> {
                mv.visitMethodInsn(INVOKESTATIC, "org/lolhens/fastreflect/FastReflect", "test", "()V", false);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }

    private static byte[] dump(String className, Type type, Type superClass, Consumer<MethodVisitor> injectInvoke) throws Exception {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS + ClassWriter.COMPUTE_FRAMES);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(52, ACC_PUBLIC + ACC_SUPER, className, "L" + superClass.getInternalName() + "<" + type.getDescriptor() + ">;", superClass.getInternalName(), null);

        cw.visitSource("Test.java", null);

        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(8, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, superClass.getInternalName(), "<init>", "()V", false);
            mv.visitInsn(RETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "L" + className + ";", null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_VARARGS, "invoke", "(Ljava/lang/Object;[Ljava/lang/Object;)" + type.getDescriptor(), null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(11, l0);

            injectInvoke.accept(mv);

            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(12, l1);
            mv.visitInsn(ACONST_NULL);
            mv.visitInsn(ARETURN);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLocalVariable("this", "L" + className + ";", null, l0, l2, 0);
            mv.visitLocalVariable("instance", "Ljava/lang/Object;", null, l0, l2, 1);
            mv.visitLocalVariable("args", "[Ljava/lang/Object;", null, l0, l2, 2);
            mv.visitMaxs(1, 3);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, "invoke", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(8, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKEVIRTUAL, className, "invoke", "(Ljava/lang/Object;[Ljava/lang/Object;)" + type.getDescriptor(), false);
            mv.visitInsn(ARETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "L" + className + ";", null, l0, l1, 0);
            mv.visitMaxs(3, 3);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
