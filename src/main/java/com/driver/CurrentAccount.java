package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only


    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;

        if(balance < 5000){
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        char[] licenseChars = tradeLicenseId.toCharArray();
        boolean isValid = true;
        for(int i = 1; i < tradeLicenseId.length(); i++){
            if(licenseChars[i] == licenseChars[i - 1]){
                isValid = false;
                break;
            }
        }
        
        if(!isValid){
            for (int i = 1; i < licenseChars.length; i++) {
                if(licenseChars[i] == licenseChars[i - 1]){
                    for (int j = i + 1; j < licenseChars.length; j++) {
                        if(licenseChars[j] != licenseChars[i] && licenseChars[j] != licenseChars[ i - 1]){
                            char temp = licenseChars[i];
                            licenseChars[i] = licenseChars[j];
                            licenseChars[j] = temp;
                            isValid = true;
                        }
                    }
                }
                if(isValid){
                    break;
                }
            }
        }

        if(!isValid){
            throw new Exception("Valid License can not be generated");
        }
        tradeLicenseId = new String(licenseChars);
    }

}
