package com.sapient.entity;

public class Test<T> {

    T member;

    public Test() {
    }

    public Test(T val) {
        member = val;
    }

    public T getMember() {
        return member;
    }

    public void setMember(T member) {
        this.member = member;
    }

    public String toString() {
        return String.format("member is of type %s and its value is %s", member.getClass().getName(), member);
    }
}
