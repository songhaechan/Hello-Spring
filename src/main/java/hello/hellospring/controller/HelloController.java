package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // 정적 컨텐츠
    public String hello(Model model) {
        model.addAttribute("data","안냥하세요");
        return "hello";
    }

    @GetMapping("hello-mvc") // MVC
    public String hellowMvc(@RequestParam("name") String name, Model model){
        // @RequestParam -> 사용자에게 데이터를 직접 전달받음 URL을 통해서
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string") // API 문자열 자체를 전달
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api") // API 객체를 JSON으로 전달
    @ResponseBody // HTTP BODY에 직접 데이터를 JSON 형식으로 전달
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }


    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
