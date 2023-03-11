package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController
{
    //http://localhost:8080/hello
    @GetMapping("hello")
    public String hello(Model model)
    {
        model.addAttribute("data", "hello");
        return "hello";
    }

    //http://localhost:8080/hello-mvc?name=spring!
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model)
    {
        model.addAttribute("name", name);//html 파일 ${name} 을 치환
        return "hello-template";
    }

    //http://localhost:8080/hello-string?name=mook
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name)
    {
        return "hello " + name;//html 을 보내는것이 아님. 글자를 http 바디에 포함해서 전송
    }

    //http://localhost:8080/hello-api?name=mook
    @GetMapping("hello-api")
    @ResponseBody
    public Hello HelloApi(@RequestParam("name") String name)
    {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;//객체를 반환/ JSON형식으로 전달된다
    }

    static class Hello
    {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
