package com.yves.common.context;


import com.yves.model.common.Org;
import com.yves.model.common.Person;
import com.yves.model.common.enums.CityEnum;

/**
 * @author Administrator
 */
public class ContextLocal {

    private static final ThreadLocal<Context> contextThreadLocal = new ThreadLocal<>();

    public static Context get() {
        return contextThreadLocal.get();
    }

    public static void set(Context context) {
        contextThreadLocal.set(context);
    }


    public static void clear() {
        contextThreadLocal.remove();
    }

    public static void setCity(CityEnum city) {
        Context context = contextThreadLocal.get();

        if(context == null) {
            context = new Context();
            contextThreadLocal.set(context);
        }
        context.setCity(city);
    }

    /**
     * 获取当前城市
     * @return
     */
    public static CityEnum getCity() {
        Context context = contextThreadLocal.get();
        if(context == null){
            return null;
        }
        return context.getCity();
    }

    /**
     * 获取当前登录人
     * @return
     */
    public static Person getCurrentPerson() {
        Context context = contextThreadLocal.get();
        if(context == null){
            return null;
        }
        return context.getPerson();
    }

    public static void setCurrentPerson(Person person) {
        Context context = contextThreadLocal.get();
        if(context == null) {
            context = new Context();
            contextThreadLocal.set(context);
        }
        context.setPerson(person);

    }

    /**
     * 获取当前城市
     * @return
     */
    public static Org getCu() {
        Context context = contextThreadLocal.get();
        if(context == null){
            return null;
        }
        return context.getCu();
    }

    public static void setCu(Org org) {
        Context context = contextThreadLocal.get();
        if(context == null) {
            context = new Context();
            contextThreadLocal.set(context);
        }
        context.setCu(org);

    }

}
