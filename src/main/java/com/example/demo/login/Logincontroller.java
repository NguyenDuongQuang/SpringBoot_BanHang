package com.example.demo.login;

import com.example.demo.entity.Admins;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.SessionService;
import com.example.demo.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class Logincontroller {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    SessionService session;
    @Autowired
    ShoppingService shoppingCartService;
    @GetMapping("/account/login")
    public String login() {
        return "layout/loginform";
    }

    @PostMapping("/account/login")
    public String login(Model model,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password , HttpServletRequest req) {

        Admins user = adminRepository.findAdminsByUsername(username);
        if (!user.getPassword().equals(password)) {
            model.addAttribute("message", "Invalid password");
        } else {
            String uri = session.get("security-uri");
            if (uri != null) {
                return "redirect:" + uri;
            } else {
                if(user.isTrangThai()){
                    if(user.isAdmin()){
                        model.addAttribute("message", "Đăng Nhập Thành Công");
                        session.set("user", user);
                        return "redirect:/Admin/Table";
                    }else {
                        model.addAttribute("message", "Đang Nhập Thành Công");
                        session.set("user", user);
                        return "redirect:/Home/views";
                    }
                }else{
                    model.addAttribute("message", "Login Không Thành Công , Tài Khoản Của Bạn Bị Cấm Vui Lòng Liên Hệ 0965953837.Để Được Hỗ Trợ");
                }
            }
        }

        return "layout/loginform";
    }
    @RequestMapping("/account/logout")
    public String logout(){
        session.remove("user");
        shoppingCartService.clear();
        return "redirect:/Home/views";
    }
    @RequestMapping("/account/register")
    public String register(@ModelAttribute("item") Admins item){

        return"layout/signup_form";
    }
    @RequestMapping ("/account/signup")
    public String signup(@Validated @ModelAttribute("item") Admins item , BindingResult errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("message", "Some field are not valid . Please fix them");
        }else {
            adminRepository.save(item);
            model.addAttribute("message", "SignUp Success ");
        }
        return "layout/signup_form";
    }
    @RequestMapping("/account/about/{id}")
    public String about(Model model  , @PathVariable("id") long id){
        Admins item = adminRepository.findById(id);
        model.addAttribute("item", item);
        List<Admins> items = adminRepository.findAll();
        model.addAttribute("items", items);
        return "layoutChangeAdmin/aboutadmin";
    }
    @RequestMapping("/account/about/save")
    public String aboutsave(Model model ,@Validated @ModelAttribute("item")  Admins item,BindingResult errors ){
        if(errors.hasErrors()){
            model.addAttribute("message","something was wrong");
        }else {
            adminRepository.save(item);
            model.addAttribute("message","Update Success");
        }
        return "layoutChangeAdmin/aboutadmin";
    }
    @RequestMapping("/Admin/Account/Remove/{id}")
    public String Remove(Model model, @PathVariable("id") Long id, RedirectAttributes prams){
        try {
            adminRepository.deleteById(id);
            prams.addAttribute("message", "Delete Success");
        } catch (Exception e) {
            prams.addAttribute("message", "Can't Account Category beacause the order form account are present ");
        }
        return "redirect:/Admin/Account";
    }
}
