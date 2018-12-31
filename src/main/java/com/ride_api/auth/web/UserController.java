package com.ride_api.auth.web;

import com.ride_api.auth.model.Ride;
import com.ride_api.auth.model.User;
import com.ride_api.auth.repository.RideRepository;
import com.ride_api.auth.service.RideService;
import com.ride_api.auth.service.SecurityService;
import com.ride_api.auth.service.UserService;
import com.ride_api.auth.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RideService rideService;

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/postride", method = RequestMethod.GET)
    public String postride(Model model) {
        model.addAttribute("rideForm", new Ride());

        return "postride";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/postride", method = RequestMethod.POST)
    public String postride(@ModelAttribute("rideForm") Ride rideForm, BindingResult bindingResult, Model model) {

        rideService.save(rideForm);

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/all_rides", method = RequestMethod.GET)
    public @ResponseBody Iterable<Ride> getAllRides() {

        return rideRepository.findAll();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}
