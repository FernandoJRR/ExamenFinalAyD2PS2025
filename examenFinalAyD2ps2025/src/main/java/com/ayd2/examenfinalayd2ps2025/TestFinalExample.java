package com.ayd2.examenfinalayd2ps2025;
import com.ayd2.examenfinalayd2ps2025.FinalExample.Order;
import com.ayd2.examenfinalayd2ps2025.FinalExample.ReportGenerator;

public class TestFinalExample {
    final FinalExample finalExampleMock = new FinalExample();
    final Order orderMock = finalExampleMock.new Order();
    final ReportGenerator reportGeneratorMock = finalExampleMock.new ReportGenerator();

    final String USER_NAME = "Fernando";
    final String USER_EMAIL = "correo@correo.com";
    final String USER_EMAIL_INVALID = "correo.com";
    final String USER_PHONE = "12345678";
    final String USER_ADDRESS = "Direccion";
    final String USER_CITY = "Ciudad";
    final String USER_ZIP = "0000";

    final String SHAPE_CIRCLE = "circle";
    final String SHAPE_RECTANGLE = "rectangle";
    final String SHAPE_TRIANGLE = "triangle";
    final String SHAPE_INVALID = "";

    final double DIM_1 = 1;
    final double DIM_2 = 1;

    final double CIRCLE_RESPONSE = Math.PI * DIM_1 * DIM_2;
    final double RECTANGLE_RESPONSE = DIM_1 * DIM_2;
    final double TRIANGLE_RESPONSE = DIM_1 * DIM_2 / 2;

    final String INPUT_DATA = "data1,data2";

    final String HEADER = "Header Test";
    final String ITEM = "Item 1";
    final double TOTAL = 10.5;

    public void testCreateUser_Exito() {
        String response = finalExampleMock.createUser(USER_NAME, USER_EMAIL, USER_PHONE, USER_ADDRESS, USER_CITY, USER_ZIP);
        assert response.equals("User created: " + USER_NAME);
    }

    public void testCreateUser_FallaNombreNull() {
        String response = finalExampleMock.createUser(null, USER_EMAIL, USER_PHONE, USER_ADDRESS, USER_CITY, USER_ZIP);
        assert response.equals("Name cannot be empty");
    }

    public void testCreateUser_FallaNombreEmpty() {
        String response = finalExampleMock.createUser("", USER_EMAIL, USER_PHONE, USER_ADDRESS, USER_CITY, USER_ZIP);
        assert response.equals("Name cannot be empty");
    }

    public void testCreateUser_FallaEmailNull() {
        String response = finalExampleMock.createUser(USER_NAME, null, USER_PHONE, USER_ADDRESS, USER_CITY, USER_ZIP);
        assert response.equals("Invalid email");
    }

    public void testCreateUser_FallaEmailInvalido() {
        String response = finalExampleMock.createUser(USER_NAME, USER_EMAIL_INVALID, USER_PHONE, USER_ADDRESS, USER_CITY, USER_ZIP);
        assert response.equals("Invalid email");
    }

    public void testCalculateArea_ExitoCircle() {
        double response = finalExampleMock.calculateArea(SHAPE_CIRCLE, DIM_1);
        assert response == CIRCLE_RESPONSE;
    }

    public void testCalculateArea_ExitoRectangle() {
        double response = finalExampleMock.calculateArea(SHAPE_RECTANGLE, DIM_1, DIM_2);
        assert response == RECTANGLE_RESPONSE;
    }

    public void testCalculateArea_ExitoTriangle() {
        double response = finalExampleMock.calculateArea(SHAPE_TRIANGLE, DIM_1, DIM_2);
        assert response == TRIANGLE_RESPONSE;
    }

    public void testCalculateArea_FallaShapeInvalida() {
        try {
            double response = finalExampleMock.calculateArea(SHAPE_INVALID, DIM_1, DIM_2);
            assert false;
        } catch (Exception e) {
            assert e.getMessage().equals("Unknown shape");
        }
    }

    public void testProcessData_Exito() {
        try {
            finalExampleMock.processData(INPUT_DATA);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    public void testOrderPrintOrderSummary_Exito() {
        //No se puede testear porque no se pueden establecer los atributos de Order
        //Todos son privados y no tiene un constructor
    }

    public void testReportGeneratorPrintHeader_Exito() {
        try {
            reportGeneratorMock.printHeader(HEADER);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    public void testReportGeneratorPrintLineItem_Exito() {
        try {
            reportGeneratorMock.printLineItem(ITEM);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    public void testReportGeneratorPrintTotal_Exito() {
        try {
            reportGeneratorMock.printTotal(TOTAL);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }
}
