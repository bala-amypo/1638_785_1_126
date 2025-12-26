// package com.example.demo.servlet;

// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// import java.io.IOException;

// @WebServlet("/status")
// public class SimpleStatusServlet extends HttpServlet {

//     @Override
//     protected void doGet(HttpServletRequest req,
//                          HttpServletResponse resp)
//             throws IOException {

//         resp.setContentType("text/plain");
//         resp.getWriter().write("Application is running");
//     }
// }




// RESOURCES:
// spring.application.name=demo
// server.port=9001

// spring.datasource.url=jdbc:mysql://localhost:3306/demo_ab?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
// spring.datasource.username=root
// spring.datasource.password=Amypo
// spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

// spring.jpa.hibernate.ddl-auto=update
// spring.jpa.show-sql=true
// spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect



package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/status")
public class SimpleStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/plain");
        resp.getWriter().write("Application is running");
    }
}
