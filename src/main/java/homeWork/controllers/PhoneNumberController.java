package homeWork.controllers;

import homeWork.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller

//@RequestMapping("/")
public class PhoneNumberController {

    @GetMapping("/check")
    public String showForm(Model model) {
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "form";
    }

    @PostMapping("/check")
    public String checkValidation(@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult bindingResult, Model model) {
        new PhoneNumber().validate(phoneNumber,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "form";
        }
        else {
            model.addAttribute("phoneNumber",phoneNumber.getNumber());
            return "result";
        }


    }

}
