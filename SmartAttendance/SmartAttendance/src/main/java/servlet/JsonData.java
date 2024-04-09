package servlet;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonData<T> {
    int code;//1:fail     0:success
    String message;
    T data;

    public JsonData(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonData(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public JsonData(int code) {
        this.code = code;
    }

    public void postData(HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        Gson gson=new Gson();
        String json=gson.toJson(this);
        resp.getWriter().write(json);
    }
}
