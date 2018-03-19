package com.yan.yml;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentOutput {
    private static List<String> fields = Arrays.asList("id", "name", "able");

    public static void main(String[] args) {
        List<Student> students = getPersons();
        List<String> stundentInfos = students.stream().map(
                p -> getOneStudentInfo(p, fields)
        ).collect(
                Collectors.toList());
        System.out.println(String.join("\n", stundentInfos));
    }

    private static String getOneStudentInfo(Student p, List<String> fields) {
        List<String> stuInfos = new ArrayList<>();
        fields.forEach(
                field -> {
                    ReportFieldConfig fieldConfig = FieldsConfigLoader.getFieldConfig(field);
                    Binding binding = new Binding();
                    binding.setVariable("stu", p);
                    GroovyShell shell = new GroovyShell(binding);
                    Object result = shell.evaluate(fieldConfig.getScript());
                    System.out.println("result from groovy script: " + result);
                    stuInfos.add(String.valueOf(result));
                }
        );
        return String.join(",", stuInfos);
    }

    private static List<Student> getPersons() {
        Student s1 = new Student("s1", "liming", "Study");
        Student s2 = new Student("s2", "xueying", "Piano");
        return Arrays.asList(s1, s2);
    }
}
