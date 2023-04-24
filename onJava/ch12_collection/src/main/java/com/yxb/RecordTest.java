package com.yxb;

public class RecordTest {
    public static void main(String[] args) {
        record RecordItem(int value){
            RecordItem(int value){
                this.value = value;
            }
        }

        System.out.println(new RecordItem(10));
    }
}
