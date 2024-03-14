package baitap.ra.business.implement;

import baitap.ra.business.config.InputMethods;
import baitap.ra.business.design.CRUD;
import baitap.ra.business.entity.Student;

public class StudentImplement implements CRUD {
    private static Student[] students = new Student[100];
    private int size = 0;
    @Override
    public void create() {
        if (size == 100){
            System.err.println("mảng đầy");
        }else {
            // logic thêm mới
            // ta 1 đối tượng student
            Student newStudent = new Student();
            newStudent.inputData();
            // thêm vào mang
            students[size] = newStudent;
            size++; // tăng số lương
        }
    }

    @Override
    public void display() {
        if (size == 0){
            System.err.println("mảng ko co ptu");
        }else {
            for (int i = 0; i < size; i++) {
                System.out.println(students[i]);
            }
        }
    }

    @Override
    public void edit() {
        System.out.println("Mời bạn nhập ID học sinh muốn sửa");
        int searchID = InputMethods.getInteger();
        boolean isEdit = false;
        for (int i = 0; i < size; i++)
        {
            if (searchID==students[i].getStudentId())
            {
                students[i].inputData();
                isEdit = true;
                break;
            }
        }
        if (!isEdit)
        {
            System.out.println("Khong tim thay ID muon sua moi nhap lai");
        }
    }

    @Override
    public void delete() {
        System.out.println("Moi ban nhap ID ten hoc sinh muon xoa");
        int deleteID =InputMethods.getInteger();
        boolean check = false;
        for (int i = 0; i < size; i++)
        {
            if (deleteID == students[i].getStudentId())
            {
                for (int j = i; j < size-1 ; j++)
                {
                    students[i] = students[i +1];
                    check = true;
                    System.out.println("Da xoa phan tu ");
                }
                students[size-1] = null;
                size--;
            }
        }
        if (!check){
            System.err.println("Khong co phan tu muon xoa");
        }
    }
}
