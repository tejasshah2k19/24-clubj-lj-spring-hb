package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.UserEntity;
import com.repository.UserRepository;
import com.service.MailService;
import com.service.OtpService;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	MailService mailService;

	@Autowired
	OtpService otpService;

	@GetMapping("/newuser")
	public String newUser() {

		return "NewUser";
	}

	@PostMapping("/saveuser")
	public String saveUser(@Validated UserEntity userEntity, BindingResult result, Model model) {
		// dao : repository
		// insert

		if (result.hasErrors()) {
			model.addAttribute("error", result);

			return "NewUser";
		}
		userRepository.save(userEntity);// insert
		return "NewUser";
	}

	@GetMapping("/users")
	public String getAllUsers(Model model) {
		List<UserEntity> users = userRepository.findAll();// select * from users
		model.addAttribute("users", users);
		return "ListUser";
	}

	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam("userId") Integer userId) {
		userRepository.deleteById(userId);
		// get
		return "redirect:/users";// url redirect to another method
	}

	@GetMapping("/viewuser")
	public String viewUser(@RequestParam("userId") Integer userId, Model model) {
		Optional<UserEntity> op = userRepository.findById(userId);
		if (op.isEmpty()) {
			//
			return "redirect:/users";
		} else {
			UserEntity userEntity = op.get();
			model.addAttribute("user", userEntity);
		}
		return "ViewUser";// url redirect to another method
	}

	@GetMapping("edituser")
	public String editUser(@RequestParam("userId") Integer userId, Model model) {
		Optional<UserEntity> op = userRepository.findById(userId);
		if (op.isEmpty()) {
			//
			return "redirect:/users";
		} else {
			UserEntity userEntity = op.get();
			model.addAttribute("user", userEntity);
			return "EditUser";
		}
	}

	@PostMapping("/updateuser")
	public String updateUser(UserEntity userEntity) {
		Optional<UserEntity> op = userRepository.findById(userEntity.getUserId());
		UserEntity dbUser = op.get();// old values
		if (op.isEmpty()) {
			return "";
		} else {
			dbUser.setFirstName(userEntity.getFirstName());
			dbUser.setLastName(userEntity.getLastName());
			userRepository.save(dbUser);

			return "redirect:/users";
		}
	}

	@GetMapping("/sendotp")
	public String sendOtp() {
		// verify email

		// generate otp
		String otp = otpService.generateAlnumOtp(6);

		// send mail
		mailService.sendOtpForgetPassword("tejas14all@gmail.com", otp);
		return "ChangePassword";// email pwd cpwd otp
	}

}
