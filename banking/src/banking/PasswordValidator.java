package banking;

class PasswordValidator {

    public void validatePassword(String password) throws InvalidPasswordFormatException {
        if (password.length() < 8 || !password.contains("*")) {
            throw new InvalidPasswordFormatException();
        }
    }
}

