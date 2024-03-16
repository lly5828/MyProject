package servlet;

import MyInterface.InterfaceToWeb;
import basicClass.Person;
import basicClass.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/LoginServlet")
//public class LoginServlet extends HttpServlet{
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //设置响应的编码格式为UTF-8编码，否则发生中文乱码现象
//        response.setContentType("text/html;charset=UTF-8");
//        //1.获得请求方式
//        String method = request.getMethod();
//        //2.获得请求的资源相关的内容
//        String requestURI = request.getRequestURI();//获得请求URI
//        StringBuffer requestURL = request.getRequestURL();
//        String webName = request.getContextPath();//获得应用路径（应用名称）
//        String querryString = request.getQueryString();//获得查询字符串
//
//        response.getWriter().write("<h1>下面是获得的字符串</h1>");
//        response.getWriter().write("<h1>method(HTTP方法):<h1>");
//        response.getWriter().write("<h1>"+method+"</h1><br>");
//        response.getWriter().write("<h1>requestURi(请求URI）:</h1>");
//        response.getWriter().write("<h1>" + requestURI + "</h1><br>");
//        response.getWriter().write("<h1>webname(应用名称):</h1>");
//        response.getWriter().write("<h1>" + webName + "</h1><br>");
//        response.getWriter().write("<h1>querrystring(查询字符串):</h1>");
//        response.getWriter().write("<h1>" + querryString + "</h1>");
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        super.doPost(req, resp);
//        this.doGet(req, resp);
//
//    }
//}










@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name= req.getParameter("name");
        String stuID=req.getParameter("studentID");

        System.out.println(name);
        System.out.println(stuID);
        Student student= InterfaceToWeb.getStudent(stuID);
        if(!student.getName().equals(name))student=null;
        if(student==null){
            System.out.println("fail");
            resp.getWriter().write("aaa");
//            req.getRequestDispatcher("返回登陆页面").forward(req,resp);
        }else {
            System.out.println("success");
            req.setAttribute("student",student);

//            req.getRequestDispatcher("进入学生页面").forward(req,resp);
        }
    }
}








//public class LoginServlet {
//
//
//
//    public static void main(String[] args) {
//        Student student=new Student("a","1",true,"123");
//        ObjectMapper mapper=new ObjectMapper();
//        try{
//            String json = null;
//            try {
//                json = mapper.writeValueAsString(student);
//            } catch (JsonProcessingException ex) {
//                throw new RuntimeException(ex);
//            }
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            HttpPost post = new HttpPost("http://127.0.0.1:8080/");
//            StringEntity entity = new StringEntity(json, "UTF-8");
//            entity.setContentType("application/json");
//            post.setEntity(entity);
//
//            HttpResponse response = null;
//            try {
//                response = httpClient.execute(post);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//            HttpEntity responseEntity = response.getEntity();
//            if (responseEntity != null) {
//                String result = null;
//                try {
//                    result = EntityUtils.toString(responseEntity, "UTF-8");
//                } catch (IOException ex) {
//
//                }
//                System.out.println(result);
//            }
//            try {
//                httpClient.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//
//
//}
