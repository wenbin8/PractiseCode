package com.wenbin.base.lambda.chapter1;


import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * @Auther: wenbin
 * @Date: 2018/12/15 17:19
 * @Description: 方法引用
 */
public class MethodReference {

    File[] files = new File(".").listFiles(new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.isHidden();
        }
    });

    File[] hiddenFiles = new File(".").listFiles(File::isHidden);

    public static void main(String[] args) {
        MethodReference methodReference = new MethodReference();
        Arrays.stream(methodReference.files).forEach(file -> System.out.println(file.getName()));
        Arrays.stream(methodReference.hiddenFiles).forEach(file -> System.out.println(file.getName()));
    }


}
