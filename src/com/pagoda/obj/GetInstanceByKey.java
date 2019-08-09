package com.pagoda.obj;

public class GetInstanceByKey {

    public static void main(String[] args) {
        String key="Word";
//        getinstantByKey(key);

        try {
            getInstantClassByKey(key);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void getInstantClassByKey(String key) throws Exception {
        String path="com.pagoda.obj."+key;
        Class.forName(path).newInstance();
        Word.class.newInstance();
        new Word().getClass().newInstance();




    }

    private static void getinstantByKey(String key) {
        if (key.equals("word")){
           new Word();
        }else if (key.equals("excel")){
           new Excel();
        }
    }
}
