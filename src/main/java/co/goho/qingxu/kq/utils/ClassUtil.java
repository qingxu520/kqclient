package co.goho.qingxu.kq.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ClassUtil {

    public static void getFileds(Object classA,Class<?> clazzA,Object classB,Class clazzB){

        Map map =new HashMap();
        Class<?> superClass=clazzA.getSuperclass();
        if(superClass!=null&&superClass.equals(Object.class)){
            //如果父类不是Objcet类，那表示该类继承了自定义类，则执行递归操作。
            getFileds(classA,superClass,classB,clazzB);
        }
       //没有父类，执行以下代码
        Field[] classBFileds=clazzB.getDeclaredFields();
        Field claA;
        for(Field classBFiled : classBFileds){
            classBFiled.setAccessible(true);
            String name=classBFiled .getName();
            try{
                //判断当前类是否有次属性名
                PropertyDescriptor pd=new PropertyDescriptor(name,clazzB);
                Method readMethod=pd.getReadMethod();
                claA=clazzA.getDeclaredField(name);
                claA.setAccessible(true);
                claA.set(classA,readMethod.invoke(classB));
            }catch(Exception e){
                e.printStackTrace();
                //没有的话跳过此属性
                continue;
            }
        }

    }
}
