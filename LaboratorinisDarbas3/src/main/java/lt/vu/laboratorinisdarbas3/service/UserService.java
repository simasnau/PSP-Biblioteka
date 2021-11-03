package lt.vu.laboratorinisdarbas3.service;

import lt.vu.laboratorinisdarbas3.model.CountryRule;
import lt.vu.laboratorinisdarbas3.model.User;
import lt.vu.laboratorinisdarbas3.repository.UserRepository;
import lt.vu.laboratorinisdarbas3.service.impl.EmailValidator;
import lt.vu.laboratorinisdarbas3.service.impl.PasswordChecker;
import lt.vu.laboratorinisdarbas3.service.impl.PhoneValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final static String USER_NOT_VALID_MSG = "User is not valid";
    private final static String USER_NOT_EXIST_MSG = "User does not exist";

    @Autowired
    private UserRepository userRepository;

    private final EmailValidator emailValidator = new EmailValidator();
    private final PasswordChecker passwordChecker = new PasswordChecker();
    private final PhoneValidator phoneValidator = new PhoneValidator();

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User findById(Long userId) throws Exception {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new Exception(USER_NOT_EXIST_MSG);
        }

        return userOptional.get();
    }

    public User addUser(User user) throws Exception {
        if (user == null) {
            throw new Exception("User is null");
        }

        if (isUserNotValid(user)) {
            throw new Exception();
        }

        return userRepository.save(user);
    }

    public User updateUser(User user) throws Exception {
        if (user == null || user.getId() == null) {
            throw new Exception("User id cant be null");
        }
        if (isUserNotValid(user)) {
            throw new Exception(USER_NOT_VALID_MSG);
        }
        if (!userRepository.existsById(user.getId())) {
            throw new Exception(USER_NOT_EXIST_MSG);
        }

        return userRepository.save(user);
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    private boolean isUserNotValid(User userInfo) {
        List<Character> specialCharacters = new ArrayList<>();
        specialCharacters.add('?');
        specialCharacters.add('_');
        specialCharacters.add('%');
        specialCharacters.add('#');
        specialCharacters.add('!');
        passwordChecker.setSpecialCharacters(specialCharacters);

        CountryRule lithuania = new CountryRule("LT", 12L, "+370");
        phoneValidator.addCountryRule(lithuania);

        boolean emailValid = emailValidator.validate(userInfo.getEmail());
        boolean passwordValid = passwordChecker.validate(userInfo.getSlaptazodis());
        boolean phoneValid = phoneValidator.validate(userInfo.getTelefonoNumeris());

        return !emailValid || !passwordValid || !phoneValid;
    }

}
