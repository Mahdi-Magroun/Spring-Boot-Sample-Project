package com.demo.bankapp.service.concretions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bankapp.exception.BadCredentialsException;
import com.demo.bankapp.exception.UserNotFoundException;
import com.demo.bankapp.model.User;
import com.demo.bankapp.repository.UserRepository;
import com.demo.bankapp.request.CreateNewUserRequest;
import com.demo.bankapp.request.LoginRequest;
import com.demo.bankapp.service.abstractions.IUserService;

@Service
// @Transactional
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User addNewUser(CreateNewUserRequest request) {
		// TODO: Mapper.
		User user = new User(request.getUsername(), request.getPassword(), request.getTcno());
		return repository.save(user);
	}

	@Override
	public User login(LoginRequest request) throws UserNotFoundException {

		User user = repository.findByUsername(request.getUsername());

		if (user == null)
			throw new UserNotFoundException(request.getUsername());

		// TODO: Encoding.
		// TODO: Stop timing attacks.
		if (user.getPassword() == null || !user.getPassword().equals(request.getPassword())) {
			throw new BadCredentialsException();
		}

		return user;
	}

}